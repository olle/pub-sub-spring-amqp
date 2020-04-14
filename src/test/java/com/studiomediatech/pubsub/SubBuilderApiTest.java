package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Test;


public class SubBuilderApiTest {

    @Test
    void ex1() {

        SubBuilder.subscribeTo("author-added", String.class)
            .onEach(author -> System.out.println("Author was added: " + author));
    }


    @Test
    void ex2() throws Exception {

        SubBuilder.subscribeTo("gate-opened", GateOpenedEvent.class)
            .onEach(gate -> System.out.println(gate.toString()));
    }

    static class GateOpenedEvent {

        public long getGateNumber() {

            return 123;
        }
    }
}
