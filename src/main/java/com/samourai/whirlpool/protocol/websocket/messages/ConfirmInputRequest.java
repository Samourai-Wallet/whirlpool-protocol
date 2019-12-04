package com.samourai.whirlpool.protocol.websocket.messages;

public class ConfirmInputRequest {
  public String mixId;
  public String blindedBordereau64;
  public String userHash;

  public ConfirmInputRequest() {}

  public ConfirmInputRequest(String mixId, String blindedBordereau64, String userHash) {
    this.mixId = mixId;
    this.blindedBordereau64 = blindedBordereau64;
    this.userHash = userHash;
  }
}
