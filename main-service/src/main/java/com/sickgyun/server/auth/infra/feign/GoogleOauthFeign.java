package com.sickgyun.server.auth.infra.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sickgyun.server.auth.infra.feign.dto.GoogleUserInfoResponse;

@FeignClient(name = "GoogleOauthFeign", url = "https://www.googleapis.com/oauth2/v1/userinfo")
public interface GoogleOauthFeign {
	@GetMapping
	GoogleUserInfoResponse getInfo(@RequestParam(name = "access_token") String accessToken);
}
