package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterOutputRoundStatusNotification extends RoundStatusNotification {

    private String registerOutputUrl;
    public RegisterOutputRoundStatusNotification() {

    }

    public RegisterOutputRoundStatusNotification(String roundId, String registerOutputUrl) {
        super(RoundStatus.REGISTER_OUTPUT, roundId);
        this.registerOutputUrl = registerOutputUrl;
    }

    public String getRegisterOutputUrl() {
        return registerOutputUrl;
    }
}