package com.samourai.whirlpool.protocol.v1.notifications;

public abstract class MixStatusNotification {
    public MixStatus status;
    public String mixId;

    public MixStatusNotification() {

    }

    public MixStatusNotification(MixStatus status, String mixId) {
        this.status = status;
        this.mixId = mixId;
    }
}