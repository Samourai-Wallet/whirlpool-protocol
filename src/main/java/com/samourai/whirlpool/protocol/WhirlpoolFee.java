package com.samourai.whirlpool.protocol;

import com.samourai.wallet.bip47.rpc.BIP47Account;
import com.samourai.whirlpool.protocol.util.XorMask;
import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhirlpoolFee {
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static final short FEE_VERSION = 1;
  private static final short FEE_LENGTH = 64;
  private static final XorMask xorMask = XorMask.getInstance();

  protected WhirlpoolFee() {}

  public byte[] encode(
      int indice,
      String paymentCode,
      NetworkParameters params,
      byte[] input0PrivKey,
      TransactionOutPoint input0OutPoint)
      throws Exception {
    byte[] dataToMaskBytes = encodeBytes(indice);
    if (dataToMaskBytes == null) {
      return null;
    }
    return xorMask.mask(dataToMaskBytes, paymentCode, params, input0PrivKey, input0OutPoint);
  }

  public Integer decode(
      byte[] dataMasked,
      BIP47Account secretAccountBip47,
      TransactionOutPoint input0OutPoint,
      byte[] input0Pubkey) {
    byte[] dataUnmaskedBytes =
        xorMask.unmask(dataMasked, secretAccountBip47, input0OutPoint, input0Pubkey);
    if (dataUnmaskedBytes == null) {
      return null;
    }
    Integer dataUnmasked = decodeBytes(dataUnmaskedBytes);
    return dataUnmasked;
  }

  // encode/decode bytes

  protected byte[] encodeBytes(int indice) {
    return ByteBuffer.allocate(FEE_LENGTH).putShort(FEE_VERSION).putInt(indice).array();
  }

  protected Integer decodeBytes(byte[] data) {
    if (data.length != FEE_LENGTH) {
      log.error("Invalid samouraiFee length: " + data.length + " vs " + FEE_LENGTH);
      return null;
    }
    ByteBuffer bb = ByteBuffer.wrap(data);
    short version = bb.getShort();
    if (version != FEE_VERSION) {
      log.error("Invalid samouraiFee version: " + version + " vs " + FEE_VERSION);
      return null;
    }
    int indice = bb.getInt();
    if (indice < 0) {
      log.error("Invalid samouraiFee indice: " + indice);
      return null;
    }
    return indice;
  }
}
