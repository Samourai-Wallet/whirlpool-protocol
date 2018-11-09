package com.samourai.whirlpool.protocol.rest;

import com.samourai.whirlpool.protocol.websocket.notifications.MixStatus;

public class PoolInfo {
  public String poolId;
  public long denomination; // in satoshis
  public long minerFeeMin; // in satoshis
  public long minerFeeMax; // in satoshis
  public int minAnonymitySet;
  public int nbRegistered;

  // mix info

  public int mixAnonymitySet;
  public MixStatus mixStatus;
  public long elapsedTime;
  public int mixNbConfirmed;

  public PoolInfo() {}

  public PoolInfo(
      String poolId,
      long denomination,
      long minerFeeMin,
      long minerFeeMax,
      int minAnonymitySet,
      int nbRegistered,
      int mixAnonymitySet,
      MixStatus mixStatus,
      long elapsedTime,
      int mixNbConfirmed) {
    this.poolId = poolId;
    this.denomination = denomination;
    this.minerFeeMin = minerFeeMin;
    this.minerFeeMax = minerFeeMax;
    this.minAnonymitySet = minAnonymitySet;
    this.nbRegistered = nbRegistered;

    this.mixAnonymitySet = mixAnonymitySet;
    this.mixStatus = mixStatus;
    this.elapsedTime = elapsedTime;
    this.mixNbConfirmed = mixNbConfirmed;
  }
}
