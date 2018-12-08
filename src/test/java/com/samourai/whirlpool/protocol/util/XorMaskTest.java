package com.samourai.whirlpool.protocol.util;

import com.samourai.wallet.bip47.rpc.BIP47Account;
import com.samourai.wallet.bip47.rpc.BIP47Wallet;
import com.samourai.wallet.hd.HD_Wallet;
import com.samourai.wallet.hd.java.HD_WalletFactoryJava;
import com.samourai.wallet.segwit.SegwitAddress;
import com.samourai.wallet.util.CryptoTestUtil;
import java.nio.ByteBuffer;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutPoint;
import org.bitcoinj.params.TestNet3Params;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XorMaskTest {
  private static final NetworkParameters params = TestNet3Params.get();
  private static final CryptoTestUtil cryptoTestUtil = CryptoTestUtil.getInstance();
  private static final XorMask xorMask = XorMask.getInstance();
  private static final HD_WalletFactoryJava hdWalletFactory = HD_WalletFactoryJava.getInstance();
  private BIP47Account bip47Account;
  private ECKey inputKey;

  @BeforeEach
  public void setup() throws Exception {
    // bip47 wallet
    String words = "all all all all all all all all all all all all";
    String passphrase = "test";
    HD_Wallet bip44wallet = hdWalletFactory.restoreWallet(words, passphrase, 1, params);
    BIP47Wallet bip47Wallet = new BIP47Wallet(47, bip44wallet, 1);
    bip47Account = bip47Wallet.getAccount(0);

    // input key
    inputKey = bip47Wallet.getAccount(1).getNotificationAddress().getECKey();
  }

  @Test
  public void mask() throws Exception {
    byte[] dataToMask = ByteBuffer.allocate(64).putInt(123456).array();
    Assertions.assertEquals(
        "0001e240000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(dataToMask));

    String inputOutPointAddress = new SegwitAddress(inputKey, params).getBech32AsString();
    TransactionOutPoint inputOutPoint =
        cryptoTestUtil.generateTransactionOutPoint(inputOutPointAddress, 1234, params);

    // mask
    byte[] dataMasked =
        xorMask.mask(
            dataToMask,
            bip47Account.getPaymentCode(),
            params,
            inputKey.getPrivKeyBytes(),
            inputOutPoint);
    Assertions.assertEquals(
        "10d8bb0615984f519c7e1a82fe44ee8993bf58fffe42ad8515f7e8cb691d4df9375b88c1de26ccef8dfce7f91b768603f8f93108f8e3b35db56018207a5918db",
        Hex.toHexString(dataMasked));
  }

  @Test
  public void unmask() throws Exception {
    byte[] dataMasked =
        Hex.decode(
            "10d8bb0615984f519c7e1a82fe44ee8993bf58fffe42ad8515f7e8cb691d4df9375b88c1de26ccef8dfce7f91b768603f8f93108f8e3b35db56018207a5918db");

    String inputOutPointAddress = new SegwitAddress(inputKey, params).getBech32AsString();
    TransactionOutPoint inputOutPoint =
        cryptoTestUtil.generateTransactionOutPoint(inputOutPointAddress, 1234, params);

    // unmask
    byte[] dataUnmasked =
        xorMask.unmask(dataMasked, bip47Account, inputOutPoint, inputKey.getPubKey());

    // verify
    Assertions.assertEquals(
        "0001e240000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(dataUnmasked));
  }

  @Test
  public void maskUnmask() throws Exception {
    byte[] dataToMask = ByteBuffer.allocate(64).putInt(123456).array();

    String inputOutPointAddress = new SegwitAddress(inputKey, params).getBech32AsString();
    TransactionOutPoint inputOutPoint =
        cryptoTestUtil.generateTransactionOutPoint(inputOutPointAddress, 1234, params);

    // mask
    byte[] dataMasked =
        xorMask.mask(
            dataToMask,
            bip47Account.getPaymentCode(),
            params,
            inputKey.getPrivKeyBytes(),
            inputOutPoint);
    Assertions.assertEquals(
        "10d8bb0615984f519c7e1a82fe44ee8993bf58fffe42ad8515f7e8cb691d4df9375b88c1de26ccef8dfce7f91b768603f8f93108f8e3b35db56018207a5918db",
        Hex.toHexString(dataMasked));

    // unmask
    byte[] dataUnmasked =
        xorMask.unmask(dataMasked, bip47Account, inputOutPoint, inputKey.getPubKey());

    // verify
    Assertions.assertArrayEquals(dataToMask, dataUnmasked);
  }
}
