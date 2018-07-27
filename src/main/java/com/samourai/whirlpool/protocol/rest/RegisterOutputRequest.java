package com.samourai.whirlpool.protocol.rest;

public class RegisterOutputRequest {
    public String mixId;
    public String bordereau;
    public byte[] unblindedSignedBordereau;
    public String sendAddress;
    public String receiveAddress;
}
