package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterInputMixStatusNotification extends MixStatusNotification {
    private String publicKey64;
    private String networkId;
    private long denomination;
    private long minerFeeMin;
    private long minerFeeMax;

    public RegisterInputMixStatusNotification() {

    }

    public RegisterInputMixStatusNotification(String mixId, String publicKey64, String networkId, long denomination, long minerFeeMin, long minerFeeMax) {
        super(MixStatus.REGISTER_INPUT, mixId);
        this.publicKey64 = publicKey64;
        this.networkId = networkId;
        this.denomination = denomination;
        this.minerFeeMin = minerFeeMin;
        this.minerFeeMax = minerFeeMax;
    }

    public String getPublicKey64() {
        return publicKey64;
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