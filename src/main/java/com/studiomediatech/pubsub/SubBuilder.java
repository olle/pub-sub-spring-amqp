package com.studiomediatech.pubsub;

import java.util.function.Consumer;


public final class SubBuilder<T> {

    private final String topic;
    private final Class<T> type;

    private SubBuilder(String topic, Class<T> type) {

        this.topic = topic;
        this.type = type;
    }

    public static <T> SubBuilder<T> subscribeTo(String topic, Class<T> type) {

        return new SubBuilder<T>(topic, type);
    }


    public void onEach(Consumer<T> consumer) {

        // TODO Auto-generated method stub
    }
}
