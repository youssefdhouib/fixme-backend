package com.fixme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//test connection mongoDB
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class FixmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixmeApplication.class, args);
	}
	
	// ============================
	// MongoDB connection test
	// ============================
	@Bean
	CommandLineRunner testMongoConnection(MongoTemplate mongoTemplate) {
		return args -> {
			try {
				// Try to list collections (forces connection)
				mongoTemplate.getDb().listCollectionNames().first();
				System.out.println("\n========================================");
				System.out.println("  ✅ MongoDB connection OK!");
				System.out.println("========================================\n");
			} catch (Exception e) {
				System.out.println("\n========================================");
				System.out.println("  ❌ MongoDB connection FAILED");
				System.out.println("  Error: " + e.getMessage());
				System.out.println("========================================\n");
			}
		};
	}
}
