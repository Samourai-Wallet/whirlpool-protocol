package com.samourai.whirlpool.protocol.websocket.messages;

public class RegisterInputRequest {
    public String mixId;

    public String utxoHash;
    public long utxoIndex;

    public String pubkeyBase64;
    public String signature;
    public String blindedBordereauBase64;
    public boolean liquidity;

    public boolean testMode;
}