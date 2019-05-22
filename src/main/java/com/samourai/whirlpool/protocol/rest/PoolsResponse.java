package com.samourai.whirlpool.protocol.rest;

public class PoolsResponse {
  public PoolInfo[] pools;

  public PoolsResponse() {}

  public PoolsResponse(PoolInfo[] pools) {
    this.pools = pools;
  }
}
