package com.redcare.challenge.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(GithubProperties.class)
public class AppConfig {

    @Bean
    RestClient githubRestClient(GithubProperties properties) {
        RestClient.Builder builder = RestClient.builder()
                .baseUrl(properties.apiBaseUrl())
                .defaultHeader("Accept", "application/vnd.github+json")
                .defaultHeader("X-GitHub-Api-Version", "2022-11-28")
                .defaultHeader("User-Agent", "github-popularity-scorer");

        if (properties.token() != null && !properties.token().isBlank()) {
            builder.defaultHeader("Authorization", "Bearer " + properties.token());
        }

        return builder.build();
    }
}
