package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterInputMixStatusNotification extends MixStatusNotification {
    private byte[] publicKey;
    private String networkId;
    private long denomination;
    private long minerFee;

    public RegisterInputMixStatusNotification() {

    }

    public RegisterInputMixStatusNotification(String mixId, byte[] publicKey, String networkId, long denomination, long minerFee) {
        super(MixStatus.REGISTER_INPUT, mixId);
        this.publicKey = publicKey;
        this.networkId = networkId;
        this.denomination = denomination;
        this.minerFee = minerFee;
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

    public long getMinerFee() {
        return minerFee;
    }
}