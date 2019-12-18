package com.samourai.whirlpool.protocol.rest;

public class Tx0DataResponse {
  public String feePaymentCode;
  public long feeValue;
  public long feeChange;
  public int feeDiscountPercent;
  public String message;
  public String feePayload64;
  public String feeAddress;
  public Integer feeIndice;

  public Tx0DataResponse() {}

  public Tx0DataResponse(
      String feePaymentCode,
      long feeValue,
      long feeChange,
      int feeDiscountPercent,
      String message,
      String feePayload64,
      String feeAddress,
      int feeIndice) {
    this.feePaymentCode = feePaymentCode;
    this.feeValue = feeValue;
    this.feeChange = feeChange;
    this.feeDiscountPercent = feeDiscountPercent;
    this.message = message;
    this.feePayload64 = feePayload64;
    this.feeAddress = feeAddress;
    this.feeIndice = feeIndice;
  }
}
