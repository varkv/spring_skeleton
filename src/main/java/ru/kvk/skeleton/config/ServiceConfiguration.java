package ru.kvk.skeleton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by King on 11.06.2015.
 */

@Configuration
@ComponentScan(basePackages = "ru.kvk.skeleton",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                        value = {
                                WebMvcConfiguration.class,
                                SecurityConfiguration.class
                        })
        })
public class ServiceConfiguration {


}
