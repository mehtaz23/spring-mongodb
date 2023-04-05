package com.example.springmongodb.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ACTUATOR_BASE = "/actuator";
    private static final String MATCHERS_ACTUATOR_HEALTH = ACTUATOR_BASE + "/health";
    private static final String MATCHERS_ACTUATOR_PROMETHEUS = ACTUATOR_BASE + "/prometheus";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/users").permitAll()
                .antMatchers(HttpMethod.GET,"/users").permitAll()
                .antMatchers(MATCHERS_ACTUATOR_HEALTH).permitAll()
                .antMatchers(MATCHERS_ACTUATOR_PROMETHEUS).permitAll()
                .anyRequest().authenticated();
    }
}
