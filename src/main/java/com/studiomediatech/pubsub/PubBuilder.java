package com.studiomediatech.pubsub;

public final class PubBuilder<T> {

    private final String topic;

    private PubBuilder(String topic) {

        this.topic = topic;
    }

    public static <T> PubBuilder<T> publishTo(String topic) {

        return new PubBuilder<>(topic);
    }


    public <T> void withValue(T values) {
    }
}
