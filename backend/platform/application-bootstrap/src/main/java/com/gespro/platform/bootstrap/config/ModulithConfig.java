package com.gespro.platform.bootstrap.config;

import com.gespro.platform.bootstrap.GesproApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.modulith.core.ApplicationModules;

/**
 * Minimal configuration to expose the Modulith {@link ApplicationModules} bean so
 * other components (e.g. diagnostics, tests) can introspect the module graph
 * without manually constructing it every time.
 */
@Configuration
public class ModulithConfig {

    @Bean
    ApplicationModules applicationModules() {
        return ApplicationModules.of(GesproApplication.class);
    }
}
