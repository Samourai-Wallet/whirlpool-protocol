package com.samourai.whirlpool.protocol.v1.notifications;

public class RevealOutputOrBlameRoundStatusNotification extends RoundStatusNotification {

    public RevealOutputOrBlameRoundStatusNotification() {

    }

    public RevealOutputOrBlameRoundStatusNotification(String roundId) {
        super(MixStatus.REVEAL_OUTPUT, roundId);
    }

}