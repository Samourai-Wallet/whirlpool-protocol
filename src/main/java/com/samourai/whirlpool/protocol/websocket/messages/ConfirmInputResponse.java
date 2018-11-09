package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.MixMessage;

public class ConfirmInputResponse extends MixMessage {
  public String signedBordereau64;

  public ConfirmInputResponse() {
    super();
  }

  public ConfirmInputResponse(String mixId, String signedBordereau64) {
    super(mixId);
    this.signedBordereau64 = signedBordereau64;
  }
}
