package com.fbo.ig2i.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fbo.ig2i.repo.PersonRepository;

/**
 * @author Fahd BOUDALI
 *
 * @see @RestController <br/>to return json
 */
@Controller
public class MyController {

	/**
	 * Default html
	 */
	private static final String WELCOME_HTML = "welcome";

	@Autowired
	PersonRepository personRepo;

	/**
	 * @param numba1
	 * @param numba2
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addition/{numba1}/{numba2}", method = RequestMethod.GET)
	public String addition(@PathVariable int numba1, @PathVariable int numba2, Model model) {

		model.addAttribute("result", numba1 + numba2);
		return WELCOME_HTML;
	}

}
