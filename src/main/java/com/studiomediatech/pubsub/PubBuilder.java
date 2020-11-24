package com.studiomediatech.pubsub;

public final class PubBuilder {

    private final PubRegistry pubRegistry;

    public PubBuilder(PubRegistry pubRegistry) {

        this.pubRegistry = pubRegistry;
    }

    public <T> ChainingPubBuilder<T> publishTo(String topic, Class<T> type) {

        return ChainingPubBuilder.publishTo(topic, type).withRegistry(pubRegistry);
    }
}
