package com.samourai.whirlpool.protocol.websocket.notifications;

public class SigningMixStatusNotification extends MixStatusNotification {

    public byte[] transaction;

    public SigningMixStatusNotification() {

    }

    public SigningMixStatusNotification(String mixId, byte[] transaction) {
        super(MixStatus.SIGNING, mixId);
        this.transaction = transaction;
    }

}