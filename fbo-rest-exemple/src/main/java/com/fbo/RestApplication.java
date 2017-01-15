package com.fbo;

import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fbo.boot.domain.IUserRepository;
import com.fbo.boot.domain.User;

/**
 * User's repository
 * 
 * @author Fahd BOUDALI
 *
 */
@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RestApplication {
	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		final ConfigurableApplicationContext runner = SpringApplication.run(RestApplication.class, args);
//		embeddedDataPreInsertion(runner);
	}

	/**
	 * Insert some poeple in DB
	 * 
	 * @param runner
	 */
	private static void embeddedDataPreInsertion(final ConfigurableApplicationContext runner) {
		LOGGER.info("Inserting some poeple");
		final IUserRepository repository = runner.getBean(IUserRepository.class);
		final User user1 = new User();
		user1.setFirstName("fahd");
		user1.setLastName("boudali");
		repository.save(user1);
	}

}
