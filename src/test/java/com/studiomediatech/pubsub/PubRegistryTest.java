package com.studiomediatech.pubsub;

import org.junit.jupiter.api.Assertions;
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

        var sut = new PubRegistry();

        assertThat(sut.instance).isNotNull();
        assertThat(sut.instance.get()).isNull();
    }


    @Test
    void ensureThrowsOnRegisterWithoutSetInstance() throws Exception {

        Assertions.assertThrows(IllegalStateException.class, () -> PubRegistry.register(new PubBuilder<>("foobar")));
    }


    @SuppressWarnings("static-access")
    @Test
    void ensureAppliesRegisterToProvidedInstanceFromContext() throws Exception {

        var instance = new PubRegistry();
        ApplicationContext applicationContext = Mockito.mock(ApplicationContext.class);
        when(applicationContext.getBean(PubRegistry.class)).thenReturn(instance);

        var sut = new PubRegistry();
        sut.setApplicationContext(applicationContext);

        assertThat(sut.instance).isNotNull();
        assertThat(sut.instance.get()).isEqualTo(instance);

        PubRegistry.instance = () -> null;
    }
}
