package com.samourai.whirlpool.protocol;

public class WhirlpoolEndpoint {

  // WEBSOCKET endpoints
  public static final String WS_CONNECT = "/ws/connect";
  public static final String WS_REGISTER_INPUT = "/ws/registerInput";
  public static final String WS_CONFIRM_INPUT = "/ws/confirmInput";
  public static final String WS_REVEAL_OUTPUT = "/ws/revealOutput";
  public static final String WS_SIGNING = "/ws/signing";

  // REST endpoints
  public static final String REST_REGISTER_OUTPUT = "/rest/registerOutput";
  public static final String REST_POOLS = "/rest/pools";

  public WhirlpoolEndpoint() {}
}
