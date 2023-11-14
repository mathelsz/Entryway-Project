package com.sistema.entryway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private String entrywayApiSecret;

    public String getEntrywayApiSecret() {
        return entrywayApiSecret;
    }

    public void setEntrywayApiSecret(String entrywayApiSecret) {
        this.entrywayApiSecret = entrywayApiSecret;
    }
}
