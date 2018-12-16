package com.samourai.whirlpool.protocol.fee;

public class WhirlpoolFeeData {

  private int feeIndice;
  private byte[] feePayload; // 2 bytes

  public WhirlpoolFeeData(int feeIndice, byte[] feePayload) {
    this.feeIndice = feeIndice;
    this.feePayload = feePayload != null ? feePayload : null;
  }

  public int getFeeIndice() {
    return feeIndice;
  }

  public byte[] getFeePayload() {
    return feePayload;
  }
}
