package com.samourai.whirlpool.protocol.v1.notifications;

public class RevealOutputOrBlameRoundStatusNotification extends RoundStatusNotification {

    public RevealOutputOrBlameRoundStatusNotification() {

    }

    public RevealOutputOrBlameRoundStatusNotification(String roundId) {
        super(RoundStatus.REVEAL_OUTPUT_OR_BLAME, roundId);
    }

}