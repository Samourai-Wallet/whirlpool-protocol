package com.samourai.whirlpool.protocol.v1.notifications;

public class FailRoundStatusNotification extends RoundStatusNotification {

    public FailRoundStatusNotification() {

    }

    public FailRoundStatusNotification(String roundId) {
        super(RoundStatus.FAIL, roundId);
    }

}