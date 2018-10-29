package com.samourai.whirlpool.protocol;

import com.samourai.wallet.util.Z85;
import com.samourai.whirlpool.protocol.beans.Utxo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

public class WhirlpoolProtocol {

  // STOMP configuration
  public static final String SOCKET_SUBSCRIBE_USER_PRIVATE = "/private";
  public static final String SOCKET_SUBSCRIBE_USER_REPLY = "/reply";

  // STOMP endpoints
  public static final String ENDPOINT_CONNECT = "/connect";
  public static final String ENDPOINT_REGISTER_INPUT = "/registerInput";
  public static final String ENDPOINT_CONFIRM_INPUT = "/confirmInput";
  public static final String ENDPOINT_REVEAL_OUTPUT = "/revealOutput";
  public static final String ENDPOINT_SIGNING = "/signing";

  // REST endpoints
  public static final String ENDPOINT_REGISTER_OUTPUT = "/registerOutput";
  public static final String ENDPOINT_POOLS = "/pools";

  /** Header specifying the message type. */
  public static final String HEADER_MESSAGE_TYPE = "messageType";

  /** Header specifying the protocol version. */
  public static final String HEADER_PROTOCOL_VERSION = "protocolVersion";

  /** Header specifying the pool id. */
  public static final String HEADER_POOL_ID = "poolId";

  /** Current protocol version. */
  public static final String PROTOCOL_VERSION = "0.13";

  private static final Z85 z85 = Z85.getInstance();

  public WhirlpoolProtocol() {}

  public static long computeInputBalanceMin(
      long denomination, boolean liquidity, long minerFeeMin) {
    long amount = denomination;
    if (!liquidity) {
      amount += minerFeeMin;
    }
    return amount;
  }

  public static long computeInputBalanceMax(
      long denomination, boolean liquidity, long minerFeeMax) {
    long amount = denomination + minerFeeMax;
    return amount;
  }

  public static String computeRegisterOutputUrl(String server) {
    String registerOutputUrl = "http://" + server + ENDPOINT_REGISTER_OUTPUT;
    return registerOutputUrl;
  }

  public static String computeInputsHash(Collection<Utxo> utxos) {
    List inputs = new ArrayList();
    for (Utxo utxo : utxos) {
      inputs.add(utxo.getHash() + String.valueOf(utxo.getIndex()));
    }
    Collections.sort(inputs);
    String inputsString = joinStrings(";", inputs);
    String inputsHash = DigestUtils.sha512Hex(inputsString);
    return inputsHash;
  }

  private static String joinStrings(String delimiter, Collection<String> strings) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (String str : strings) {
      if (!first) {
        sb.append(delimiter);
      }
      sb.append(str);
      first = false;
    }
    return sb.toString();
  }

  public static byte[] decodeBytes(String encoded) {
    return z85.decode(encoded);
  }

  public static String encodeBytes(byte[] data) {
    return z85.encode(data);
  }
}
