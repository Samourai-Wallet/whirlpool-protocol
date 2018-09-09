package com.samourai.whirlpool.protocol.websocket;

public abstract class WhirlpoolMessage {
    public String mixId;

    public WhirlpoolMessage() {

    }

    public WhirlpoolMessage(String mixId) {
        this.mixId = mixId;
    }
}