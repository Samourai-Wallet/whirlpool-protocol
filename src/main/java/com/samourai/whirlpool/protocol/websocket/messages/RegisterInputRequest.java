package com.samourai.whirlpool.protocol.websocket.messages;

public class RegisterInputRequest {
  public String poolId;
  public String utxoHash;
  public long utxoIndex;

  public String signature;
  public boolean liquidity;

  public boolean testMode;
  public String resumeConfirmedMixId;

  public RegisterInputRequest() {}

  public RegisterInputRequest(
      String poolId,
      String utxoHash,
      long utxoIndex,
      String signature,
      boolean liquidity,
      boolean testMode,
      String resumeConfirmedMixId) {
    this.poolId = poolId;
    this.utxoHash = utxoHash;
    this.utxoIndex = utxoIndex;
    this.signature = signature;
    this.liquidity = liquidity;
    this.testMode = testMode;
    this.resumeConfirmedMixId = resumeConfirmedMixId;
  }
}
