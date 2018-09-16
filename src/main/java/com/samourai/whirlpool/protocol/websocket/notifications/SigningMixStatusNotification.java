package com.samourai.whirlpool.protocol.websocket.notifications;

public class SigningMixStatusNotification extends MixStatusNotification {

    public String transactionBase64;

    public SigningMixStatusNotification() {

    }

    public SigningMixStatusNotification(String mixId, String transactionBase64) {
        super(MixStatus.SIGNING, mixId);
        this.transactionBase64 = transactionBase64;
    }

}