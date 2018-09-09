package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class RegisterInputResponse extends WhirlpoolMessage {
    public byte[] signedBordereau;

    public RegisterInputResponse() {
        super();
    }

    public RegisterInputResponse(String mixId, byte[] signedBordereau) {
        super(mixId);
        this.signedBordereau = signedBordereau;
    }
}