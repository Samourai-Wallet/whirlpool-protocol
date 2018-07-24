package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterOutputMixStatusNotification extends MixStatusNotification {

    private String registerOutputUrl;
    public RegisterOutputMixStatusNotification() {

    }

    public RegisterOutputMixStatusNotification(String mixId, String registerOutputUrl) {
        super(MixStatus.REGISTER_OUTPUT, mixId);
        this.registerOutputUrl = registerOutputUrl;
    }

    public String getRegisterOutputUrl() {
        return registerOutputUrl;
    }
}