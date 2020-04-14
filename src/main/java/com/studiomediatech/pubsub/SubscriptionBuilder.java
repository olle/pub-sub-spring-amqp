package com.studiomediatech.pubsub;

import java.util.function.Consumer;


public final class SubscriptionBuilder<T> {

    private final String topic;
    private final Class<T> type;

    private SubscriptionBuilder(String topic, Class<T> type) {

        this.topic = topic;
        this.type = type;
    }

    public static <T> SubscriptionBuilder<T> subscribeTo(String topic, Class<T> type) {

        return new SubscriptionBuilder<T>(topic, type);
    }


    public void onEach(Consumer<T> consumer) {

        // TODO Auto-generated method stub
    }
}
