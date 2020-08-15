package com.xinghua24.bookmarkproxy.security.jwt;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class JwtAuthenticationConfig {
	@Value("${xinghua24.security.jwt.secret")
	private String secret;
}
