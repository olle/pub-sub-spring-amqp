package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Test;


public class PubBuilderApiTest {

    @Test
    void ex1() throws Exception {

        PubBuilder.publishTo("author-added")
            .withValue("William Gibson");
    }
}
