/**
 * 
 */
package com.fbo.rest.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fbo.rest.domain.IUserRepository;
import com.fbo.rest.domain.User;

/**
 * @author FBO
 *
 */
@Service
public class UserService implements UserDetailsService {

	private final IUserRepository userRepo;

	/**
	 * @param userRepo
	 */
	@Autowired
	public UserService(final IUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	/**
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final User user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User : " + username + " not found in our system");
		}
		return new CustomUserDetails(user);
	}

	/**
	 * @return
	 */
	public List<User> showAll() {

		return (List<User>) userRepo.findAll();

	}

	/**
	 * @param user
	 * @return
	 */
	public User createNew(final User user) {

		return userRepo.save(user);

	}

	/**
	 * @param user
	 * @return
	 */
	public User update(final User user) {

		return userRepo.save(user);

	}

	/**
	 * @param user
	 */
	public void removeUser(final User user) {

		userRepo.delete(user);

	}

	private final static class CustomUserDetails extends User implements UserDetails {

		private CustomUserDetails(final User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		private static final long serialVersionUID = 5639683223516504866L;
	}
}
