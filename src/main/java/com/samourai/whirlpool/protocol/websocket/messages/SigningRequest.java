package com.samourai.whirlpool.protocol.websocket.messages;

public class SigningRequest {
  public String mixId;
  public String[] witnesses64;

  public SigningRequest() {}

  public SigningRequest(String mixId, String[] witnesses64) {
    this.mixId = mixId;
    this.witnesses64 = witnesses64;
  }
}
