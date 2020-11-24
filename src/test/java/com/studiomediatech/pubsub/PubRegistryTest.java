package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PubRegistryTest {

    @SuppressWarnings("static-access")
    @Test
    void ensureNoInstanceSetByDefault() {

        PubRegistry sut = new PubRegistry();

        assertThat(sut.instance).isNotNull();
        assertThat(sut.instance.get()).isNull();
    }


    @SuppressWarnings("static-access")
    @Test
    void ensureAppliesRegisterToProvidedInstanceFromContext() throws Exception {

        PubRegistry instance = new PubRegistry();
        ApplicationContext applicationContext = Mockito.mock(ApplicationContext.class);
        when(applicationContext.getBean(PubRegistry.class)).thenReturn(instance);

        PubRegistry sut = new PubRegistry();
        sut.setApplicationContext(applicationContext);

        assertThat(sut.instance).isNotNull();
        assertThat(sut.instance.get()).isEqualTo(instance);

        PubRegistry.instance = () -> null;
    }
}
