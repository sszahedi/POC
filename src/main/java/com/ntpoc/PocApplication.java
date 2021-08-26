package com.ntpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	// Generate 10 random Users and Jobs using Java Faker
//	@Bean
//	CommandLineRunner commandLineRunner(UserDao userDao, JobDao jobDao) {
//		return args -> {
//			Faker faker = new Faker();
//			for (int i = 0; i < 10; i++) {
//				User user = new User(faker.name().firstName(), faker.name().lastName());
//				userDao.save(user);
//
//				Job job = new Job(
//						faker.job().title(),
//						faker.job().position(),
//						faker.job().field(),
//						faker.job().seniority()
//				);
//				jobDao.save(job);
//			}
//		};
//	}

}
