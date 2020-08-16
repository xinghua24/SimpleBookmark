package com.xinghua24.bookmarkproxy.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Component
public class JwtAuthenticationConfig {
	@Value("${xinghua24.security.jwt.secret}")
	private String secret;
}
