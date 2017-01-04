package com.fbo;

import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fbo.ig2i.entity.Person;
import com.fbo.ig2i.repo.PersonRepository;

/**
 * Person's repository
 * @author Fahd BOUDALI
 *
 */
@SpringBootApplication
public class RestApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	/**
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(final PersonRepository repository) {

		return  new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				//Putting some Poeple in it 
				log.info("Putting some Poeple in it ");
				repository.save(new Person("Fahd", "Boudali"));
				repository.save(new Person("John", "Doe"));
				repository.save(new Person("Vic", "Mackey"));

			};
		};


	}

}
