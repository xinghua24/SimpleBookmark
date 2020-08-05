package com.xinghua24.bookmarkproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BookmarkProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkProxyApplication.class, args);
	}

}
