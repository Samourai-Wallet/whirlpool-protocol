package com.samourai.whirlpool.protocol.websocket.notifications;

public class SigningMixStatusNotification extends MixStatusNotification {

  public String transaction64;

  public SigningMixStatusNotification() {}

  public SigningMixStatusNotification(String mixId, String transaction64) {
    super(MixStatus.SIGNING, mixId);
    this.transaction64 = transaction64;
  }
}
