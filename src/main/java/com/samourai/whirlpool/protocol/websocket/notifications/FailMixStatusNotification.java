package com.samourai.whirlpool.protocol.websocket.notifications;

public class FailMixStatusNotification extends MixStatusNotification {

  public FailMixStatusNotification() {}

  public FailMixStatusNotification(String mixId) {
    super(MixStatus.FAIL, mixId);
  }
}
