package com.studiomediatech.pubsub;

import java.util.function.Consumer;


public final class PubBuilder<T> {

    private final String topic;
    private T values;

    private Consumer<PubBuilder<T>> sink = PubRegistry::register;

    // Available to tests.
    protected PubBuilder(String topic) {

        this.topic = topic;
    }

    public static <T> PubBuilder<T> publishTo(String topic) {

        return new PubBuilder<>(topic);
    }


    public void withValue(T values) {

        this.values = values;

        register();
    }


    private void register() {

        sink.accept(this);
    }
}
