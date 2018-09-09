package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class LiquidityQueuedResponse extends WhirlpoolMessage {

    LiquidityQueuedResponse() {
        super();
    }

    public LiquidityQueuedResponse(String mixId) {
        super(mixId);
    }
}