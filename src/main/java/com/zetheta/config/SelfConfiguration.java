package com.zetheta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SelfConfiguration {
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) {
    	security.csrf(customizer->customizer.disable());
    	security.authorizeHttpRequests(auth->auth.requestMatchers("/","/signup").permitAll().anyRequest().authenticated());
    	security.formLogin(Customizer.withDefaults());
    	security.httpBasic(Customizer.withDefaults());
		return security.build();
    	
    }
}
