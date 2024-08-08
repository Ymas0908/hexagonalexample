package org.example.adapters.config;

import org.example.domain.DomainConfig.DomaineService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"org.example.domain"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomaineService.class})}
)
public class DomainConfig {
}

