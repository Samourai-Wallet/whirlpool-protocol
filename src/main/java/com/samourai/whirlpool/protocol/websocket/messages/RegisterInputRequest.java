package com.samourai.whirlpool.protocol.websocket.messages;

public class RegisterInputRequest {
  public String poolId;
  public String utxoHash;
  public long utxoIndex;

  public String pubkey64;
  public String signature;
  public boolean liquidity;

  public boolean testMode;

  public RegisterInputRequest() {}

  public RegisterInputRequest(
      String poolId,
      String utxoHash,
      long utxoIndex,
      String pubkey64,
      String signature,
      boolean liquidity,
      boolean testMode) {
    this.poolId = poolId;
    this.utxoHash = utxoHash;
    this.utxoIndex = utxoIndex;
    this.pubkey64 = pubkey64;
    this.signature = signature;
    this.liquidity = liquidity;
    this.testMode = testMode;
  }
}
