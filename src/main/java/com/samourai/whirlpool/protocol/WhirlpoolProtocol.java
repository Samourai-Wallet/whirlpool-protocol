package com.samourai.whirlpool.protocol;

import com.samourai.wallet.util.Z85;
import com.samourai.whirlpool.protocol.beans.Utxo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class WhirlpoolProtocol {
  /** Current protocol version. */
  public static final String PROTOCOL_VERSION = "0.21";

  // STOMP configuration
  public static final String WS_PREFIX_USER_PRIVATE = "/private";
  public static final String WS_PREFIX_USER_REPLY = "/reply";

  /** Header specifying the message type. */
  public static final String HEADER_MESSAGE_TYPE = "messageType";

  /** Header specifying the protocol version. */
  public static final String HEADER_PROTOCOL_VERSION = "protocolVersion";

  /** Header specifying the pool id. */
  public static final String HEADER_POOL_ID = "poolId";

  private static final Z85 z85 = Z85.getInstance();

  public WhirlpoolProtocol() {}

  public static String getUrlRegisterOutput(String server, boolean ssl) {
    String protocol = ssl ? "https" : "http";
    String url = protocol + "://" + server + WhirlpoolEndpoint.REST_REGISTER_OUTPUT;
    return url;
  }

  public static String getUrlConnect(String server, boolean ssl) {
    String protocol = ssl ? "wss" : "ws";
    String url = protocol + "://" + server + WhirlpoolEndpoint.WS_CONNECT;
    return url;
  }

  public static String getUrlFetchPools(String server, boolean ssl) {
    String protocol = ssl ? "https" : "http";
    String url = protocol + "://" + server + WhirlpoolEndpoint.REST_POOLS;
    return url;
  }

  public static String getUrlTx0Data(String server, boolean ssl, String scode) {
    String protocol = ssl ? "https" : "http";
    String url = protocol + "://" + server + WhirlpoolEndpoint.REST_TX0_DATA;
    if (!StringUtils.isEmpty(url)) {
      url += "?scode=" + scode;
    }
    return url;
  }

  public static long computePremixBalanceMin(
      long denomination, long mustMixBalanceMin, boolean liquidity) {
    if (liquidity) {
      return denomination;
    }
    return mustMixBalanceMin;
  }

  public static long computePremixBalanceMax(
      long denomination, long mustMixBalanceMax, boolean liquidity) {
    if (liquidity) {
      return denomination;
    }
    return mustMixBalanceMax;
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
    if (encoded == null) {
      return null;
    }
    return z85.decode(encoded);
  }

  public static String encodeBytes(byte[] data) {
    if (data == null) {
      return null;
    }
    return z85.encode(data);
  }
}
