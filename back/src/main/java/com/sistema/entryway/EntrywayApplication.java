package com.sistema.entryway;

import com.sistema.entryway.config.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class EntrywayApplication {
	private static final Logger log = LoggerFactory.getLogger(EntrywayApplication.class);

    public static void main(String[] args) {

        var app = new SpringApplication(EntrywayApplication.class);
        var env = app.run(args).getEnvironment();
        var protocol = "http";

        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        log.info("""
                        \n\t----------------------------------------------------------
                        \tLocal: \t\t{}://localhost:{}
                        \t----------------------------------------------------------
                        """,
                protocol,
                env.getProperty("server.port")
        );
    }
}
