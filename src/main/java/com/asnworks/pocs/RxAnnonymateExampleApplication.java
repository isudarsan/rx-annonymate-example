package com.asnworks.pocs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * 
 */
@SpringBootApplication
public class RxAnnonymateExampleApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(RxAnnonymateExampleApplication.class);

	private final LoggingService loggingService;

	public RxAnnonymateExampleApplication(LoggingService loggingService) {
		this.loggingService = loggingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RxAnnonymateExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("Application started");
		loggingService.logMessages();
		logger.info("Application finished");
	}
}

@Service
class LoggingService {

	private static final Path LOG_FILE_PATH = Paths.get("logstest/application-direct-log.txt");

	public void logMessages() {
		try {
			if (!Files.exists(LOG_FILE_PATH)) {
				Files.createDirectories(LOG_FILE_PATH.getParent());
				Files.createFile(LOG_FILE_PATH);
			}

//			Files.write(LOG_FILE_PATH, "User Name: Max Mustermann, Email: max.mustermann@mercedes-benz.com\n"
//					.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//			Files.write(LOG_FILE_PATH, "Address: Musterstraße 2, 70771, Karlsruhe\n".getBytes(StandardCharsets.UTF_8),
//					StandardOpenOption.APPEND);
//
//			Files.write(LOG_FILE_PATH, "Benutzername: Max Mustermann, E-Mail: max.mustermann@mercedes-benz.com\n"
//					.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//			Files.write(LOG_FILE_PATH, "Adresse: Musterstraße 2, 70771, Karlsruhe\n".getBytes(StandardCharsets.UTF_8),
//					StandardOpenOption.APPEND);
			
			Files.write(LOG_FILE_PATH, "hello: world !!\n".getBytes(StandardCharsets.UTF_8),
					StandardOpenOption.APPEND);
			
			
			Files.write(LOG_FILE_PATH, "Welcome to the world of python !\n".getBytes(StandardCharsets.UTF_8),
					StandardOpenOption.APPEND);
			
			Files.write(LOG_FILE_PATH, "No - PII Branch\n".getBytes(StandardCharsets.UTF_8),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}