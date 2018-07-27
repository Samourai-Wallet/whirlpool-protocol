package com.samourai.whirlpool.protocol.websocket.messages;

public class RegisterInputRequest {
    public String mixId;

    public String utxoHash;
    public long utxoIndex;

    public byte[] pubkey;
    public String signature;
    public byte[] blindedBordereau;
    public String paymentCode;
    public boolean liquidity;
}