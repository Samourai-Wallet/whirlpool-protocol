package com.samourai.whirlpool.protocol.websocket.notifications;

public class ConfirmInputMixStatusNotification extends MixStatusNotification {
  public String publicKey64;

  public ConfirmInputMixStatusNotification() {}

  public ConfirmInputMixStatusNotification(String mixId, String publicKey64) {
    super(MixStatus.CONFIRM_INPUT, mixId);
    this.publicKey64 = publicKey64;
  }
}
