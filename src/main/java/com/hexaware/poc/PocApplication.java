package com.hexaware.poc;

import com.github.javafaker.Faker;
import com.hexaware.poc.dao.JobDao;
import com.hexaware.poc.dao.UserDao;
import com.hexaware.poc.entity.Job;
import com.hexaware.poc.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	// Generate 10 random Users and Jobs using Java Faker
	@Bean
	CommandLineRunner commandLineRunner(UserDao userDao, JobDao jobDao) {
		return args -> {
			Faker faker = new Faker();
			for (int i = 0; i < 10; i++) {
				User user = new User(faker.name().firstName(), faker.name().lastName());
				userDao.save(user);

				Job job = new Job(
						faker.job().title(),
						faker.job().position(),
						faker.job().field(),
						faker.job().seniority()
				);
				jobDao.save(job);
			}
		};
	}

}
