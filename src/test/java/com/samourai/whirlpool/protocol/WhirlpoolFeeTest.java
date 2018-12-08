package com.samourai.whirlpool.protocol;

import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhirlpoolFeeTest {
  private static final WhirlpoolFee whirlpoolFee = WhirlpoolProtocol.getWhirlpoolFee();

  @Test
  public void encodeBytes() throws Exception {
    Assertions.assertEquals(
        "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(0)));
    Assertions.assertEquals(
        "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(1)));
    Assertions.assertEquals(
        "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(123456)));
  }

  @Test
  public void decodeBytes() throws Exception {
    Assertions.assertEquals(
        0,
        (int)
            whirlpoolFee.decodeBytes(
                Hex.decode(
                    "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    Assertions.assertEquals(
        1,
        (int)
            whirlpoolFee.decodeBytes(
                Hex.decode(
                    "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    Assertions.assertEquals(
        123456,
        (int)
            whirlpoolFee.decodeBytes(
                Hex.decode(
                    "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
  }

  @Test
  public void decodeEncodedBytes() throws Exception {
    for (int i = 0; i < 1000; i++) {
      byte[] encoded = whirlpoolFee.encodeBytes(i);
      Assertions.assertEquals(i, (int) whirlpoolFee.decodeBytes(encoded));
    }
  }
}
