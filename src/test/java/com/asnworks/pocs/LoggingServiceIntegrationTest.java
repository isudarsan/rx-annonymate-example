package com.asnworks.pocs;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggingServiceIntegrationTest {

    private static final String LOG_FILE_PATH = "logstest/application-direct-log.txt";

    @Autowired
    private LoggingService loggingService;

    @BeforeEach
    public void setUp() throws IOException {
        Path logFilePath = new File(LOG_FILE_PATH).toPath();
        if (Files.exists(logFilePath)) {
            Files.write(logFilePath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

//    @AfterEach
//    public void tearDown() throws IOException {
//        Path logFilePath = new File(LOG_FILE_PATH).toPath();
//        if (Files.exists(logFilePath)) {
//            Files.write(logFilePath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
//        }
//    }

    @Test
    public void testLogMessages() throws IOException {
        // Trigger logging
        loggingService.logMessages();

        // Verify log file exists
        File logFile = new File(LOG_FILE_PATH);
        assertThat(logFile).exists();

//        // Read log file contents
//        List<String> logLines = Files.readAllLines(logFile.toPath(), StandardCharsets.UTF_8);
//
//       
//        assertThat(logLines).anyMatch(line -> line.contains("User Name: Max Mustermann, Email: max.mustermann@mercedes-benz.com"));
//        assertThat(logLines).anyMatch(line -> line.contains("Address: Musterstraße 2, 70771, Karlsruhe"));
//        assertThat(logLines).anyMatch(line -> line.contains("Benutzername: Max Mustermann, E-Mail: max.mustermann@mercedes-benz.com"));
//        assertThat(logLines).anyMatch(line -> line.contains("Adresse: Musterstraße 2, 70771, Karlsruhe"));
    }
}