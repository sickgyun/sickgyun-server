package com.sickgyun.server.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
	JwtCredentials.class,
})
public class CredentialConfig {
}
