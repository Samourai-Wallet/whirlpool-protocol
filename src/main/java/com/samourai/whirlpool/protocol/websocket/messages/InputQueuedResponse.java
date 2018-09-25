package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class InputQueuedResponse extends WhirlpoolMessage {
    private String reason;

    InputQueuedResponse() {
        super();
    }

    public InputQueuedResponse(String mixId, String reason) {
        super(mixId);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}