package com.ef.parser;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ef.parser.model.Log;
import com.ef.parser.model.Parameters;
import com.ef.parser.service.ParserService;

@SpringBootApplication
public class ParserApplication implements ApplicationRunner {

	@Autowired
	ParserService parserService;

	public static void main(String... args) throws Exception {
		SpringApplication.run(ParserApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Parameters parameters = new Parameters(args);
		List<Log> logs = new ArrayList<>();
		String fileToBeParsed = "C:/access.log";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		if (parameters.areOK()) {

			System.out.println("\n\n\n" + "Starting parsing process ...");

			parserService.parseFile(fileToBeParsed);

			System.out.println("\n\n\n" + "File parsed sucessfully !!!");

			logs = parserService.getSelectionLog(parameters);

			System.out.println("\n" + "This IPs have exceeded more than " + Long.toString(parameters.getThreshold())
			+ " requests from :" + dateFormat.format(parameters.getStartDate()) + " to "
			+ dateFormat.format(parameters.getEndDate()) +  "\n");

			parserService.printSelectionLog(logs);
			
			parserService.saveComments(logs, parameters);

		} else {
			System.out.println("Incorrect Parameters");
			System.out.println("The format of parameteres must be:");
			System.out.println("--startDate=yyyy-MM-dd.HH:mm:ss --duration=daily/hourly --threshold=integer");
		}
	}

}
