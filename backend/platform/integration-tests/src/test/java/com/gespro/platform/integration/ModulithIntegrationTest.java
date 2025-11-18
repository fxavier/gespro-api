package com.gespro.platform.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithIntegrationTest {

    @Test
    void shouldDiscoverAllBoundedContexts() throws Exception {
        Class<?> bootstrapType = Class.forName("com.gespro.platform.bootstrap.GesproApplication");
        ApplicationModules modules = ApplicationModules.of(bootstrapType);

        assertThat(modules.stream().count()).isGreaterThanOrEqualTo(14L);
    }
}
