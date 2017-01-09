package com.fbo;

import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fbo.ig2i.domain.Person;
import com.fbo.ig2i.domain.PersonRepository;

/**
 * Person's repository
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
	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		ConfigurableApplicationContext runner = SpringApplication.run(RestApplication.class, args);
		embeddedDataPreInsertion(runner);

	}

	/**
	 * Insert some poeple in DB
	 * 
	 * @param runner
	 */
	private static void embeddedDataPreInsertion(ConfigurableApplicationContext runner) {
		LOGGER.info("Inserting some poeple");
		PersonRepository repository = runner.getBean(PersonRepository.class);
		repository.save(new Person("Fahd", "Boudali"));
		repository.save(new Person("John", "Doe"));
		repository.save(new Person("Vic", "Mackey"));
	}

}
