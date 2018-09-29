package com.samourai.whirlpool.protocol.websocket.messages;

public class SubscribePoolResponse {
    private String networkId;
    private long denomination;
    private long minerFeeMin;
    private long minerFeeMax;

    public SubscribePoolResponse() {

    }

    public SubscribePoolResponse(String networkId, long denomination, long minerFeeMin, long minerFeeMax) {
        super();
        this.networkId = networkId;
        this.denomination = denomination;
        this.minerFeeMin = minerFeeMin;
        this.minerFeeMax = minerFeeMax;
    }

    public String getNetworkId() {
        return networkId;
    }

    public long getDenomination() {
        return denomination;
    }

    public long getMinerFeeMin() {
        return minerFeeMin;
    }

    public long getMinerFeeMax() {
        return minerFeeMax;
    }
}