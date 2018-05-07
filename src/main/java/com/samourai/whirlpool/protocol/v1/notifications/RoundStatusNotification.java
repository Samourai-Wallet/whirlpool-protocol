package com.samourai.whirlpool.protocol.v1.notifications;

public abstract class RoundStatusNotification {
    public RoundStatus status;
    public String roundId;

    public RoundStatusNotification() {

    }

    public RoundStatusNotification(RoundStatus status, String roundId) {
        this.status = status;
        this.roundId = roundId;
    }
}