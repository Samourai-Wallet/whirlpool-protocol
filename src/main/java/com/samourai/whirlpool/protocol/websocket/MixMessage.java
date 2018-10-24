package com.samourai.whirlpool.protocol.websocket;

public abstract class MixMessage {
  public String mixId;

  public MixMessage() {}

  public MixMessage(String mixId) {
    this.mixId = mixId;
  }
}
