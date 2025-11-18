package com.gespro.platform.bootstrap.diagnostics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.core.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.stereotype.Component;

/**
 * Emits a small log once the Spring context is ready so we can confirm that the
 * Modulith modules were detected correctly.
 */
@Component
public class ModulithDiagnostics {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModulithDiagnostics.class);

    private final ApplicationModules modules;

    public ModulithDiagnostics(ApplicationModules modules) {
        this.modules = modules;
    }

    @EventListener(ApplicationReadyEvent.class)
    void logDetectedModules() {
        LOGGER.info("Gespro Modulith discovered {} modules.", modules.stream().count());
        for (ApplicationModule module : modules) {
            LOGGER.info(" - {}", module.getDisplayName());
        }
    }
}
