package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterInputRoundStatusNotification extends RoundStatusNotification {
    private byte[] publicKey;
    private String networkId;
    private long denomination;
    private long minerFee;

    public RegisterInputRoundStatusNotification() {

    }

    public RegisterInputRoundStatusNotification(String roundId, byte[] publicKey, String networkId, long denomination, long minerFee) {
        super(RoundStatus.REGISTER_INPUT, roundId);
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