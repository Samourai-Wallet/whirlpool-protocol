package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class InputQueuedResponse extends WhirlpoolMessage {

    InputQueuedResponse() {
        super();
    }

    public InputQueuedResponse(String mixId) {
        super(mixId);
    }
}