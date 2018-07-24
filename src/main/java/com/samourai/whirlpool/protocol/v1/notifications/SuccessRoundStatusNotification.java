package com.samourai.whirlpool.protocol.v1.notifications;

public class SuccessRoundStatusNotification extends RoundStatusNotification {

    public SuccessRoundStatusNotification() {

    }

    public SuccessRoundStatusNotification(String roundId) {
        super(MixStatus.SUCCESS, roundId);
    }

}