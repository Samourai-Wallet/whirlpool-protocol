package com.samourai.whirlpool.protocol.rest;

public class PoolsResponse {
  public PoolInfo[] pools;
  public long feeValue;
  public String feePaymentCode;
  public String feePayload64;

  public PoolsResponse() {}

  public PoolsResponse(
      PoolInfo[] pools, long feeValue, String feePaymentCode, String feePayload64) {
    this.pools = pools;
    this.feeValue = feeValue;
    this.feePaymentCode = feePaymentCode;
    this.feePayload64 = feePayload64;
  }
}
