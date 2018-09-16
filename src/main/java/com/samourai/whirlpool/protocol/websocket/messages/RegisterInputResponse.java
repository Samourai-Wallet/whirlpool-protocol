package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.WhirlpoolMessage;

public class RegisterInputResponse extends WhirlpoolMessage {
    public String signedBordereauBase64;

    public RegisterInputResponse() {
        super();
    }

    public RegisterInputResponse(String mixId, String signedBordereauBase64) {
        super(mixId);
        this.signedBordereauBase64 = signedBordereauBase64;
    }
}