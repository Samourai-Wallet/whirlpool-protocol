package com.samourai.whirlpool.protocol;

public class WhirlpoolEndpoint {

  // WEBSOCKET endpoints
  public static final String WS_PREFIX = "/ws/";
  public static final String WS_CONNECT = WS_PREFIX + "connect";
  public static final String WS_REGISTER_INPUT = WS_PREFIX + "registerInput";
  public static final String WS_CONFIRM_INPUT = WS_PREFIX + "confirmInput";
  public static final String WS_REVEAL_OUTPUT = WS_PREFIX + "revealOutput";
  public static final String WS_SIGNING = WS_PREFIX + "signing";

  // REST endpoints
  public static final String REST_PREFIX = "/rest/";
  public static final String REST_REGISTER_OUTPUT = REST_PREFIX + "registerOutput";
  public static final String REST_POOLS = REST_PREFIX + "pools";
  public static final String REST_TX0_DATA = REST_PREFIX + "tx0";

  public WhirlpoolEndpoint() {}
}
