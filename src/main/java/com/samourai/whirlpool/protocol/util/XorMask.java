package com.samourai.whirlpool.protocol.util;

import com.samourai.wallet.bip47.rpc.BIP47Account;
import com.samourai.wallet.bip47.rpc.PaymentCode;
import com.samourai.wallet.bip47.rpc.secretPoint.ISecretPoint;
import com.samourai.wallet.bip47.rpc.secretPoint.ISecretPointFactory;
import com.samourai.wallet.hd.HD_Address;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XorMask {
  private static final Logger log = LoggerFactory.getLogger(XorMask.class);

  private static XorMask instance = null;
  private ISecretPointFactory secretPointFactory;

  public static XorMask getInstance(ISecretPointFactory secretPointFactory) {
    if (instance == null) {
      instance = new XorMask(secretPointFactory);
    }
    return instance;
  }

  private XorMask(ISecretPointFactory secretPointFactory) {
    this.secretPointFactory = secretPointFactory;
  }

  public byte[] mask(
      byte[] dataToMask,
      String paymentCodeOfSecretAccount,
      NetworkParameters params,
      byte[] input0PrivKey,
      TransactionOutPoint input0OutPoint)
      throws Exception {
    HD_Address notifAddressCli =
        new PaymentCode(paymentCodeOfSecretAccount).notificationAddress(params);
    ISecretPoint secretPointMask =
        secretPointFactory.newSecretPoint(input0PrivKey, notifAddressCli.getPubKey());
    byte[] dataMasked = PaymentCode.xorMask(dataToMask, secretPointMask, input0OutPoint);
    return dataMasked;
  }

  public byte[] unmask(
      byte[] dataMasked,
      BIP47Account secretAccount,
      TransactionOutPoint input0OutPoint,
      byte[] input0Pubkey) {
    HD_Address notifAddressServer = secretAccount.getNotificationAddress();
    try {
      ISecretPoint secretPointUnmask =
          secretPointFactory.newSecretPoint(
              notifAddressServer.getECKey().getPrivKeyBytes(), input0Pubkey);
      byte[] dataUnmasked = PaymentCode.xorMask(dataMasked, secretPointUnmask, input0OutPoint);
      return dataUnmasked;
    } catch (Exception e) {
      log.error("", e);
      return null;
    }
  }
}
