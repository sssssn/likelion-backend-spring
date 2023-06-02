package com.likelion.project04;

import com.likelion.project04.week7.day5.models.Customer;
import com.likelion.project04.week7.day5.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Project04Application {

	private static final Logger log = LoggerFactory.getLogger(Project04Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Project04Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "sssssn") String name) {
		return "Hello " + name;
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args -> {
			repository.save(new Customer("sn", "k"));

			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
		};
	}
}