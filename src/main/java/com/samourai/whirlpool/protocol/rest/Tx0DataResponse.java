package com.samourai.whirlpool.protocol.rest;

public class Tx0DataResponse {
  public String feePaymentCode;
  public String feePayload64;
  public String feeAddress;
  public Integer feeIndice;

  public Tx0DataResponse() {}

  public Tx0DataResponse(String feePaymentCode, String feePayload64) {
    this.feePaymentCode = feePaymentCode;
    this.feePayload64 = feePayload64;
    this.feeAddress = null;
    this.feeIndice = null;
  }

  public Tx0DataResponse(String feePaymentCode, String feeAddress, int feeIndice) {
    this.feePaymentCode = feePaymentCode;
    this.feePayload64 = null;
    this.feeAddress = feeAddress;
    this.feeIndice = feeIndice;
  }
}
