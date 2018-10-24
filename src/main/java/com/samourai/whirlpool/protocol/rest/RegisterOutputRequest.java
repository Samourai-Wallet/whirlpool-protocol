package com.samourai.whirlpool.protocol.rest;

public class RegisterOutputRequest {
  public String inputsHash;
  public String unblindedSignedBordereau64;
  public String receiveAddress;

  public RegisterOutputRequest() {}

  public RegisterOutputRequest(
      String inputsHash, String unblindedSignedBordereau64, String receiveAddress) {
    this.inputsHash = inputsHash;
    this.unblindedSignedBordereau64 = unblindedSignedBordereau64;
    this.receiveAddress = receiveAddress;
  }
}
