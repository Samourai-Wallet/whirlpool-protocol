package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterOutputMixStatusNotification extends MixStatusNotification {

    public RegisterOutputMixStatusNotification() {

    }

    public RegisterOutputMixStatusNotification(String mixId) {
        super(MixStatus.REGISTER_OUTPUT, mixId);
    }
}