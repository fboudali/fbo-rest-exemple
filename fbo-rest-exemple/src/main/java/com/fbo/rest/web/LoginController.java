package com.fbo.rest.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fahd BOUDALI
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * @return
	 */
	@RequestMapping(method = GET)
	public String showLoginPage() {
		System.out.println("oui");
		return "login";

	}

}
