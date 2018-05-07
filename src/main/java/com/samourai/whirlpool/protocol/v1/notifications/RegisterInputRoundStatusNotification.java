package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterInputRoundStatusNotification extends RoundStatusNotification {

    public RegisterInputRoundStatusNotification() {

    }

    public RegisterInputRoundStatusNotification(String roundId) {
        super(RoundStatus.REGISTER_INPUT, roundId);
    }
}