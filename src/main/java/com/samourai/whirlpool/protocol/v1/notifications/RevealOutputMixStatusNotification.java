package com.samourai.whirlpool.protocol.v1.notifications;

public class RevealOutputMixStatusNotification extends MixStatusNotification {

    public RevealOutputMixStatusNotification() {

    }

    public RevealOutputMixStatusNotification(String mixId) {
        super(MixStatus.REVEAL_OUTPUT, mixId);
    }

}