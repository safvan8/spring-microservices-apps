package com.safvan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate rt() {
        return new RestTemplate();
    }

    // Configuration for a Sampler bean to control tracing and sampling behavior.
    // In this case, it's set to ALWAYS_SAMPLE, meaning that all requests will be traced.
    // This data is collected and sent to a Zipkin server for monitoring and analysis.
    @Bean
    public Sampler configSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    // Comment the code above or use Sampler.NEVER_SAMPLE if you don't want to send data
    // to the Zipkin server. This would disable tracing.
}
