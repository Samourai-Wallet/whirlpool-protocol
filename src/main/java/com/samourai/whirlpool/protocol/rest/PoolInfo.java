package com.samourai.whirlpool.protocol.rest;

import com.samourai.whirlpool.protocol.websocket.notifications.MixStatus;

public class PoolInfo {
    public String poolId;
    public long denomination; // in satoshis
    public long minerFee; // in satoshis
    public int minAnonymitySet;

    // mix info

    public int mixAnonymitySet;
    public MixStatus mixStatus;
    public long elapsedTime;
    public int mixNbConnected;
    public int mixNbRegistered;
}
