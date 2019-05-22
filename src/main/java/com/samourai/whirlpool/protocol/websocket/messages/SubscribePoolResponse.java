package com.samourai.whirlpool.protocol.websocket.messages;

public class SubscribePoolResponse {
  public String networkId;
  public long denomination;
  public long mustMixBalanceMin;
  public long mustMixBalanceCap;
  public long mustMixBalanceMax;

  public SubscribePoolResponse() {}

  public SubscribePoolResponse(
      String networkId,
      long denomination,
      long mustMixBalanceMin,
      long mustMixBalanceCap,
      long mustMixBalanceMax) {
    super();
    this.networkId = networkId;
    this.denomination = denomination;
    this.mustMixBalanceMin = mustMixBalanceMin;
    this.mustMixBalanceCap = mustMixBalanceCap;
    this.mustMixBalanceMax = mustMixBalanceMax;
  }
}
