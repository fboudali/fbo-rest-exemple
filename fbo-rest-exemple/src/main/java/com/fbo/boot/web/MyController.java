package com.fbo.boot.web;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbo.boot.domain.User;
import com.fbo.boot.service.UserService;

/**
 * @author Fahd BOUDALI
 *
 */
@RestController
@RequestMapping("/poeple")
public class MyController {

	/**
	 * Default html
	 */

	@Autowired
	UserService userService;

	/**
	 * @return
	 */
	@RequestMapping(method = GET)
	public List<User> showAll() {

		final List<User> users = userService.showAll();
		return users;

	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(method = POST)
	public User createNew(final User user) {

		return userService.createNew(user);

	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(method = PUT)
	public User update(final User user) {

		return userService.update(user);

	}

	/**
	 * @param user
	 */
	@RequestMapping(method = DELETE)
	public void removeUser(final User user) {

		userService.removeUser(user);

	}

}
