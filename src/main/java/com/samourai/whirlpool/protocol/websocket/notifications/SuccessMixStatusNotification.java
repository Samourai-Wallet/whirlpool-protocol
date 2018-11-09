package com.samourai.whirlpool.protocol.websocket.notifications;

public class SuccessMixStatusNotification extends MixStatusNotification {

  public SuccessMixStatusNotification() {}

  public SuccessMixStatusNotification(String mixId) {
    super(MixStatus.SUCCESS, mixId);
  }
}
