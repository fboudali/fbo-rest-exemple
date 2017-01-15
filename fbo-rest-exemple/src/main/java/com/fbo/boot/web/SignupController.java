package com.fbo.boot.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fbo.boot.domain.IUserRepository;
import com.fbo.boot.domain.User;

/**
 * Allows users to sign up.
 *
 *
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

	/** User repo */
	private final IUserRepository userRepository;

	@Autowired
	public SignupController(final IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = GET)
	public String signupForm(@ModelAttribute final User user) {
		return "user/signup";
	}

	@RequestMapping(method = POST)
	public String signup(@Valid User user, final BindingResult result, final RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "user/signup";
		}
		user = userRepository.save(user);
		redirect.addFlashAttribute("globalMessage", "Successfully signed up");

		final List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		final UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), authorities);
		final Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), authorities);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/";
	}
}
