package com.samourai.whirlpool.protocol;

import java.lang.invoke.MethodHandles;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhirlpoolFee {
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static final short FEE_VERSION = 1;
  private static final short FEE_LENGTH = 64;

  protected WhirlpoolFee() {}

  public byte[] encode(int indice) {
    return ByteBuffer.allocate(FEE_LENGTH).putShort(FEE_VERSION).putInt(indice).array();
  }

  public Integer decode(byte[] data) {
    if (data.length != FEE_LENGTH) {
      log.error("Invalid samouraiFee length: " + data.length + " vs " + FEE_LENGTH);
      return null;
    }
    ByteBuffer bb = ByteBuffer.wrap(data);
    short version = bb.getShort();
    if (version != FEE_VERSION) {
      log.error("Invalid samouraiFee version: " + version + " vs " + FEE_VERSION);
      return null;
    }
    int indice = bb.getInt();
    if (indice < 0) {
      log.error("Invalid samouraiFee indice: " + indice);
      return null;
    }
    return indice;
  }
}
