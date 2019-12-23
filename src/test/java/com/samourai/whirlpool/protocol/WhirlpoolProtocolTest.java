package com.samourai.whirlpool.protocol;

import com.samourai.whirlpool.protocol.beans.Utxo;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhirlpoolProtocolTest {

  @Test
  public void computeInputsHash() throws Exception {
    List<Utxo> utxos = new LinkedList<>();

    utxos.add(new Utxo("040df121854c7db49e38b6fcb61c2b0953c8b234ce53c1b2a2fb122a4e1c3d2e", 0));
    Assertions.assertEquals(
        "d98762e7d256e9cbc93d6cf9f4ff160c6a3253e8665d34ab6321b0220bc00c9393ba6f6008b75b8ca89a37514c1fcda8a4ad01069af8488ea86357ff219a25bd",
        WhirlpoolProtocol.computeInputsHash(utxos));

    utxos.add(new Utxo("6517ece36402a89d76d075c60a8d3d0e051e4e5efa42a01c9033328707631b61", 5));
    Assertions.assertEquals(
        "a8615d928839ab1a23c7a32f2f58cfa5af92bfc46469d3acf42df75f23b731cc4a8fccd94bf65477c887c5b8705e4ef86574362dc9244ae5d4d5835b6eb3a357",
        WhirlpoolProtocol.computeInputsHash(utxos));
  }
}
