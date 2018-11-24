package com.samourai.whirlpool.protocol.rest;

public class PoolsResponse {
  public PoolInfo[] pools;
  public String feePaymentCode;

  public PoolsResponse() {}

  public PoolsResponse(PoolInfo[] pools, String feePaymentCode) {
    this.pools = pools;
    this.feePaymentCode = feePaymentCode;
  }
}
