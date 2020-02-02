package com.samourai.whirlpool.protocol.fee;

import com.samourai.wallet.bip47.rpc.BIP47Account;
import com.samourai.wallet.bip47.rpc.secretPoint.ISecretPointFactory;
import com.samourai.whirlpool.protocol.util.XorMask;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhirlpoolFee {
  private static final Logger log = LoggerFactory.getLogger(WhirlpoolFee.class);
  private static WhirlpoolFee instance = null;

  private static final short FEE_VERSION = 1;
  public static final short FEE_LENGTH = 64;
  public static final short FEE_PAYLOAD_LENGTH = 2;
  private static final byte[] FEE_PAYLOAD_DEFAULT = new byte[FEE_PAYLOAD_LENGTH]; // 00

  private ISecretPointFactory secretPointFactory;

  public static WhirlpoolFee getInstance(ISecretPointFactory secretPointFactory) {
    if (instance == null) {
      instance = new WhirlpoolFee(secretPointFactory);
    }
    return instance;
  }

  private WhirlpoolFee(ISecretPointFactory secretPointFactory) {
    this.secretPointFactory = secretPointFactory;
  }

  public byte[] encode(
      int feeIndice,
      byte[] feePayload,
      String paymentCode,
      NetworkParameters params,
      byte[] input0PrivKey,
      TransactionOutPoint input0OutPoint)
      throws Exception {
    byte[] dataToMaskBytes = encodeBytes(feeIndice, feePayload);
    if (dataToMaskBytes == null) {
      return null;
    }
    return XorMask.getInstance(secretPointFactory)
        .mask(dataToMaskBytes, paymentCode, params, input0PrivKey, input0OutPoint);
  }

  public WhirlpoolFeeData decode(
      byte[] dataMasked,
      BIP47Account secretAccountBip47,
      TransactionOutPoint input0OutPoint,
      byte[] input0Pubkey) {
    byte[] dataUnmaskedBytes =
        XorMask.getInstance(secretPointFactory)
            .unmask(dataMasked, secretAccountBip47, input0OutPoint, input0Pubkey);
    if (dataUnmaskedBytes == null) {
      return null;
    }
    return decodeBytes(dataUnmaskedBytes);
  }

  // encode/decode bytes

  protected byte[] encodeBytes(int feeIndice, byte[] feePayload) throws Exception {
    // 8 bytes total:
    // - feeVersion: 2 bytes (short)
    // - indice: 4 bytes (int)
    // - feePayload: 2 bytes (short)
    if (feePayload != null && feePayload.length != FEE_PAYLOAD_LENGTH) {
      throw new Exception("Invalid feePayload: " + feePayload.length + " vs " + FEE_PAYLOAD_LENGTH);
    }
    ByteBuffer byteBuffer = ByteBuffer.allocate(FEE_LENGTH).putShort(FEE_VERSION).putInt(feeIndice);
    if (feePayload != null) {
      byteBuffer.put(feePayload);
    } else {
      // default value at 0
      byteBuffer.put(FEE_PAYLOAD_DEFAULT);
    }
    return byteBuffer.array();
  }

  protected WhirlpoolFeeData decodeBytes(byte[] data) {
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
    int feeIndice = bb.getInt();
    byte[] feePayload = new byte[FEE_PAYLOAD_LENGTH];
    bb.get(feePayload);
    if (Arrays.equals(feePayload, FEE_PAYLOAD_DEFAULT)) {
      // null when default value
      feePayload = null;
    }

    return new WhirlpoolFeeData(feeIndice, feePayload);
  }
}
