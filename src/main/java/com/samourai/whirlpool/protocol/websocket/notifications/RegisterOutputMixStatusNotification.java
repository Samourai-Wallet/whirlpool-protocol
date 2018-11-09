package com.samourai.whirlpool.protocol.websocket.notifications;

public class RegisterOutputMixStatusNotification extends MixStatusNotification {
  private String inputsHash;

  public RegisterOutputMixStatusNotification() {}

  public RegisterOutputMixStatusNotification(String mixId, String inputsHash) {
    super(MixStatus.REGISTER_OUTPUT, mixId);
    this.inputsHash = inputsHash;
  }

  public String getInputsHash() {
    return inputsHash;
  }
}
