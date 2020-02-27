package com.samourai.whirlpool.protocol.fee;

public class WhirlpoolFeeData {

  private int feeIndice;
  private byte[] feePayload; // 2 bytes
  private short feePartner;

  public WhirlpoolFeeData(int feeIndice, byte[] feePayload, short feePartner) {
    this.feeIndice = feeIndice;
    this.feePayload = feePayload != null ? feePayload : null;
    this.feePartner = feePartner;
  }

  public int getFeeIndice() {
    return feeIndice;
  }

  public byte[] getFeePayload() {
    return feePayload;
  }

  public short getFeePartner() {
    return feePartner;
  }
}
