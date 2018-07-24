package com.samourai.whirlpool.protocol;

public class WhirlpoolProtocol {

    // STOMP configuration
    public static final String SOCKET_SUBSCRIBE_USER_PRIVATE = "/private";
    public static final String SOCKET_SUBSCRIBE_USER_REPLY = "/reply";
    public static final String SOCKET_SUBSCRIBE_QUEUE = "/queue";

    // STOMP endpoints
    public static final String ENDPOINT_REGISTER_INPUT = "/registerInput";
    public static final String ENDPOINT_REVEAL_OUTPUT = "/revealOutput";
    public static final String ENDPOINT_SIGNING = "/signing";

    /**
     * Header specifying the message type.
     */
    public static final String HEADER_MESSAGE_TYPE = "messageType";

    /**
     * Header specifying the protocol version.
     */
    public static final String HEADER_PROTOCOL_VERSION = "protocolVersion";
    public static final String PROTOCOL_VERSION = "0.1";

    public WhirlpoolProtocol() {
    }
}
