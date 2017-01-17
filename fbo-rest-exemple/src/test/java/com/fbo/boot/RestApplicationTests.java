package com.fbo.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Fahd BOUDALI
 * @see {@link https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {

	@Before
	public void setup() {

		final Authentication auth = new TestingAuthenticationToken("user", "pass", "ROLE_USER");

		final SecurityContext ctx = SecurityContextHolder.getContext();
		ctx.setAuthentication(auth);
		SecurityContextHolder.setContext(ctx);

	}

	/**
	 * 
	 */

	@Test
	public void contextLoads() {
	}

	@After
	public void cleanup() {
		SecurityContextHolder.clearContext();
	}

}
