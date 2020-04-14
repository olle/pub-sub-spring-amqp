package com.studiomediatech.pubsub;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PubBuilderApiTest {

    @Mock
    PubRegistry registry;

    @BeforeEach
    void setup() {

        PubRegistry.instance = () -> registry;
    }


    @AfterEach
    void teardown() {

        PubRegistry.instance = () -> null;
    }


    @Test
    void ex1() throws Exception {

        PubBuilder.publishTo("author-added")
            .withValue("William Gibson");
    }
}
