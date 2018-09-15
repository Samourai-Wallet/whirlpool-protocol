package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterInputMixStatusNotification extends MixStatusNotification {
    private String publicKeyBase64;
    private String networkId;
    private long denomination;
    private long minerFeeMin;
    private long minerFeeMax;

    public RegisterInputMixStatusNotification() {

    }

    public RegisterInputMixStatusNotification(String mixId, String publicKeyBase64, String networkId, long denomination, long minerFeeMin, long minerFeeMax) {
        super(MixStatus.REGISTER_INPUT, mixId);
        this.publicKeyBase64 = publicKeyBase64;
        this.networkId = networkId;
        this.denomination = denomination;
        this.minerFeeMin = minerFeeMin;
        this.minerFeeMax = minerFeeMax;
    }

    public String getPublicKeyBase64() {
        return publicKeyBase64;
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