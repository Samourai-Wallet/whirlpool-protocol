package com.samourai.whirlpool.protocol.websocket.messages;

import com.samourai.whirlpool.protocol.websocket.MixMessage;

public class ErrorResponse extends MixMessage {
  public String message;

  public ErrorResponse() {
    super();
  }

  public ErrorResponse(String message) {
    super(null); // no mixId available for errors
    this.message = message;
  }
}
