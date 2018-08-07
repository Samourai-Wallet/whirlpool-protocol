package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterInputMixStatusNotification extends MixStatusNotification {
    private byte[] publicKey;
    private String networkId;
    private long denomination;
    private long minerFeeMin;
    private long minerFeeMax;

    public RegisterInputMixStatusNotification() {

    }

    public RegisterInputMixStatusNotification(String mixId, byte[] publicKey, String networkId, long denomination, long minerFeeMin, long minerFeeMax) {
        super(MixStatus.REGISTER_INPUT, mixId);
        this.publicKey = publicKey;
        this.networkId = networkId;
        this.denomination = denomination;
        this.minerFeeMin = minerFeeMin;
        this.minerFeeMax = minerFeeMax;
    }

    public byte[] getPublicKey() {
        return publicKey;
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