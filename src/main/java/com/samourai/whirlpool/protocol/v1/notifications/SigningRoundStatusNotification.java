package com.samourai.whirlpool.protocol.v1.notifications;

public class SigningRoundStatusNotification extends RoundStatusNotification {

    public byte[] transaction;

    public SigningRoundStatusNotification() {

    }

    public SigningRoundStatusNotification(String roundId, byte[] transaction) {
        super(MixStatus.SIGNING, roundId);
        this.transaction = transaction;
    }

}