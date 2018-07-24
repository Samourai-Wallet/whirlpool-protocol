package com.samourai.whirlpool.protocol.v1.notifications;

public class SuccessMixStatusNotification extends MixStatusNotification {

    public SuccessMixStatusNotification() {

    }

    public SuccessMixStatusNotification(String mixId) {
        super(MixStatus.SUCCESS, mixId);
    }

}