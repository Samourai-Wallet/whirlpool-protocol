package com.samourai.whirlpool.protocol.websocket.messages;

public class RevealOutputRequest {
  public String mixId;
  public String receiveAddress;

  public RevealOutputRequest() {}

  public RevealOutputRequest(String mixId, String receiveAddress) {
    this.mixId = mixId;
    this.receiveAddress = receiveAddress;
  }
}
