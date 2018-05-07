package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterOutputRoundStatusNotification extends RoundStatusNotification {

    public RegisterOutputRoundStatusNotification() {

    }

    public RegisterOutputRoundStatusNotification(String roundId) {
        super(RoundStatus.REGISTER_OUTPUT, roundId);
    }

}