package com.samourai.whirlpool.protocol.rest;

public class RegisterOutputRequest {
    public String inputsHash;
    public String bordereau;
    public byte[] unblindedSignedBordereau;
    public String receiveAddress;
}
