package com.samourai.whirlpool.protocol.websocket.messages;

public class ConfirmInputRequest {
    public String mixId;
    public String blindedBordereau64;

    public ConfirmInputRequest() {
    }

    public ConfirmInputRequest(String mixId, String blindedBordereau64) {
        this.mixId = mixId;
        this.blindedBordereau64 = blindedBordereau64;
    }
}