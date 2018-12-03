package com.cvpp.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class XmlParsingApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(XmlParsingApplication.class);
	
	public static void main(String[] args) {
		log.info("Application started");
		SpringApplication.run(XmlParsingApplication.class, args);
		log.info("Applicatin end");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		XmlParser parser = new XmlParser();
		parser.Parse();
//		parser.create();
	}
}
