package com.web.springbootwebconfig.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 16:46 2019/10/29
 */
@SpringBootConfiguration
public class TomcatConfig {

    @Bean
    public EmbeddedWebServerFactoryCustomizerAutoConfiguration EmbeddedWebServerFactoryCustomizerAutoConfiguration() {
        return null;
    }
}
