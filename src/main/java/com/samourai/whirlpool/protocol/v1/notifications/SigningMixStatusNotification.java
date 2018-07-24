package com.samourai.whirlpool.protocol.v1.notifications;

public class SigningMixStatusNotification extends MixStatusNotification {

    public byte[] transaction;

    public SigningMixStatusNotification() {

    }

    public SigningMixStatusNotification(String mixId, byte[] transaction) {
        super(MixStatus.SIGNING, mixId);
        this.transaction = transaction;
    }

}