package com.samourai.whirlpool.protocol.v1.messages;

public class RegisterOutputRequest {
    public String mixId;
    public String bordereau;
    public byte[] unblindedSignedBordereau;
    public String sendAddress;
    public String receiveAddress;
}
