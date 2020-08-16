package com.xinghua24.bookmarkproxy.security.jwt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * Authenticate requests with header 'Authorization: Bearer jwt-token'
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtAuthenticationConfig jwtAuthenticationConfig;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);

			Claims claims = extractClaims(jwt);
			String username = claims.getSubject();
			Date expiration = claims.getExpiration();

			if (username != null && expiration != null && !expiration.before(new Date())
					&& SecurityContextHolder.getContext().getAuthentication() == null) {
				String strAuthorities = claims.get("authorities", String.class);
				List<String> authorities = Arrays.asList(strAuthorities.split("\\s"));
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null,
						authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(token);
			}
		}
		filterChain.doFilter(request, response);
	}

	private Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(jwtAuthenticationConfig.getSecret()).parseClaimsJws(token).getBody();
	}

}
