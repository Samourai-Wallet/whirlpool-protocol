package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class RegisterInputResponse extends WhirlpoolMessage {
    public String signedBordereau64;

    public RegisterInputResponse() {
        super();
    }

    public RegisterInputResponse(String mixId, String signedBordereau64) {
        super(mixId);
        this.signedBordereau64 = signedBordereau64;
    }
}