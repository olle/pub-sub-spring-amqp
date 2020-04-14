package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Test;


public class SubscriptionBuilderApiTest {

    @Test
    void ex1() {

        SubscriptionBuilder.subscribeTo("author-added", String.class)
            .onEach(author -> System.out.println("Author was added: " + author));
    }


    @Test
    void ex2() throws Exception {

        SubscriptionBuilder.subscribeTo("gate-opened", GateOpenedEvent.class)
            .onEach(gate -> System.out.println(gate.toString()));
    }

    static class GateOpenedEvent {

        public long getGateNumber() {

            return 123;
        }
    }
}
