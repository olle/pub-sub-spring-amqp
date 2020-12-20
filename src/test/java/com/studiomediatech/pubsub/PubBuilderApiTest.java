package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PubBuilderApiTest {

    @Mock
    PubRegistry registry;

    @Test
    void ex1() throws Exception {

        PubRegistry.instance = () -> registry;

        ChainingPubBuilder.publishTo("author-added", String.class)
            .withAll()
            .from("William Gibson", "Douglas Adams");

        PubRegistry.instance = () -> null;
    }
}
