package com.studiomediatech.pubsub;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.function.Supplier;


class PubRegistry implements ApplicationContextAware {

    protected static Supplier<PubRegistry> instance = () -> null;

    public static <T> void register(PubBuilder<T> builder) {

        var registry = instance.get();

        if (registry == null) {
            throw new IllegalStateException("No registry is initialized.");
        }

        registry.accept(builder);
    }


    private <T> void accept(PubBuilder<T> builder) {

        // TODO Auto-generated method stub
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        PubRegistry.instance = () -> applicationContext.getBean(getClass());
    }
}
