package com.studiomediatech.pubsub;

import java.util.function.Consumer;


public class ChainingPubBuilder<T> {

    /**
     * The target, used in the terminal operation. Can be modified from {@link #withSink(Consumer)}.
     */
    private Consumer<ChainingPubBuilder<T>> sink = PubRegistry::register;

    private String topic;
    private T values;

    public void withValue(T values) {

        this.values = values;

        register();
    }


    private void register() {

        sink.accept(this);
    }


    public static <T> ChainingPubBuilder<T> publishTo(String topic, Class<T> type) {

        // TODO Auto-generated method stub
        return null;
    }


    protected ChainingPubBuilder<T> withRegistry(PubRegistry pubRegistry) {

        // this.sink = pubRegistry::register;

        // TODO Auto-generated method stub
        return null;
    }


    public ChainingPubBuilder<T> withAll() {

        // TODO Auto-generated method stub
        return this;
    }


    public void from(String... values) {

        // TODO Auto-generated method stub
    }
}
