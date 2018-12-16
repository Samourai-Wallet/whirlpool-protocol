package com.samourai.whirlpool.protocol.fee;

import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhirlpoolFeeTest {
  private static final WhirlpoolFee whirlpoolFee = WhirlpoolFee.getInstance();

  @Test
  public void encodeBytes() throws Exception {
    // without feePayload
    Assertions.assertEquals(
        "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(0, null)));
    Assertions.assertEquals(
        "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(0, null)));
    Assertions.assertEquals(
        "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(1, null)));
    Assertions.assertEquals(
        "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(123456, null)));

    // with feePayload
    Assertions.assertEquals(
        "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(0, new byte[] {0, 0})));
    Assertions.assertEquals(
        "00010000000100010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(1, new byte[] {0, 1})));
    Assertions.assertEquals(
        "00010001e24001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
        Hex.toHexString(whirlpoolFee.encodeBytes(123456, new byte[] {1, 1})));
  }

  @Test
  public void decodeBytes() throws Exception {
    // without feePayload
    assertEqualsFeeData(
        0,
        new byte[] {0, 0},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    assertEqualsFeeData(
        1,
        new byte[] {0, 0},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    assertEqualsFeeData(
        123456,
        new byte[] {0, 0},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010001e24000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));

    // with feePayload
    assertEqualsFeeData(
        0,
        new byte[] {0, 0},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    assertEqualsFeeData(
        1,
        new byte[] {0, 1},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010000000100010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    assertEqualsFeeData(
        123456,
        new byte[] {1, 1},
        whirlpoolFee.decodeBytes(
            Hex.decode(
                "00010001e24001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
  }

  private void assertEqualsFeeData(int feeIndice, byte[] feePayload, WhirlpoolFeeData feeData) {
    Assertions.assertEquals(feeIndice, feeData.getFeeIndice());
    Assertions.assertArrayEquals(feeData.getFeePayload(), feePayload);
  }

  @Test
  public void decodeEncodedBytes() throws Exception {
    for (int i = 0; i < 1000; i++) {
      byte[] encoded = whirlpoolFee.encodeBytes(i, new byte[] {1, 1});
      assertEqualsFeeData(i, new byte[] {1, 1}, whirlpoolFee.decodeBytes(encoded));
    }
  }
}
