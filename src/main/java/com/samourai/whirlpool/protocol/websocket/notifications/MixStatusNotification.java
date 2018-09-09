package com.samourai.whirlpool.protocol.websocket.notifications;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public abstract class MixStatusNotification extends WhirlpoolMessage {
    public MixStatus status;

    public MixStatusNotification() {

    }

    public MixStatusNotification(MixStatus status, String mixId) {
        super(mixId);
        this.status = status;
    }
}