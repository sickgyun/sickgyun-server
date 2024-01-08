package com.sickgyun.server.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.sickgyun.server")
public class OpenFeignConfig {
}
