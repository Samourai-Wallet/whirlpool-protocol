package com.samourai.whirlpool.protocol.v1.notifications;

public abstract class RoundStatusNotification {
    public MixStatus status;
    public String roundId;

    public RoundStatusNotification() {

    }

    public RoundStatusNotification(MixStatus status, String roundId) {
        this.status = status;
        this.roundId = roundId;
    }
}