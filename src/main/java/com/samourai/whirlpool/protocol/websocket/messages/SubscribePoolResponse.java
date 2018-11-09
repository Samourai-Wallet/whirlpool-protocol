package com.samourai.whirlpool.protocol.websocket.messages;

public class SubscribePoolResponse {
  public String networkId;
  public long denomination;
  public long minerFeeMin;
  public long minerFeeMax;

  public SubscribePoolResponse() {}

  public SubscribePoolResponse(
      String networkId, long denomination, long minerFeeMin, long minerFeeMax) {
    super();
    this.networkId = networkId;
    this.denomination = denomination;
    this.minerFeeMin = minerFeeMin;
    this.minerFeeMax = minerFeeMax;
  }
}
