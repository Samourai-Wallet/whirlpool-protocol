package com.samourai.whirlpool.protocol;

import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhirlpoolFeeTest {
  private static final WhirlpoolFee whirlpoolFee = WhirlpoolProtocol.getWhirlpoolFee();

  @Test
  public void encode() throws Exception {
    Assertions.assertEquals(
        "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encode(0)));
    Assertions.assertEquals(
        "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encode(1)));
    Assertions.assertEquals(
        "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encode(123456)));
  }

  @Test
  public void decode() throws Exception {
    Assertions.assertEquals(
        0,
        (int)
            whirlpoolFee.decode(
                Hex.decode(
                    "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    Assertions.assertEquals(
        1,
        (int)
            whirlpoolFee.decode(
                Hex.decode(
                    "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    Assertions.assertEquals(
        123456,
        (int)
            whirlpoolFee.decode(
                Hex.decode(
                    "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
  }

  @Test
  public void reverse() throws Exception {
    for (int i = 0; i < 1000; i++) {
      byte[] encoded = whirlpoolFee.encode(i);
      Assertions.assertEquals(i, (int) whirlpoolFee.decode(encoded));
    }
  }
}
