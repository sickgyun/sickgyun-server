package com.sickgyun.server.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class S3Bucket {
	@Value("${aws.s3.bucket}")
	private String s3Bucket;
}
