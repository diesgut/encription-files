package com.diesgut.ecriptionfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diesgut.ecriptionfiles.service.IPGPService;

@SpringBootApplication
public class PgpcaseApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(PgpcaseApplication.class);

	public final static String FOLDER_DEPOSIT = System.getProperty("user.home") + "/CDS_FILES/";
	public final static String FOLDER_ENCRYPT = FOLDER_DEPOSIT + "/ENCRYPT/";
	public final static String FOLDER_DECRYPT = FOLDER_DEPOSIT + "/DECRYPT/";

	@Autowired
	IPGPService ipgpService;

	public static void main(String[] args) {
		SpringApplication.run(PgpcaseApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("StartApplication...");
		boolean success = new File(FOLDER_DEPOSIT).mkdirs();
		success = new File(FOLDER_ENCRYPT).mkdirs();
		success = new File(FOLDER_DECRYPT).mkdirs();
		ipgpService.encryptFiles();
	}

}
