package com.samourai.whirlpool.protocol.websocket.messages;

public class RegisterInputRequest {
    public String poolId;
    public String utxoHash;
    public long utxoIndex;

    public String pubkey64;
    public String signature;
    public boolean liquidity;

    public boolean testMode;
}