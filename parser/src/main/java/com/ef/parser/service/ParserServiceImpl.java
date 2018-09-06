package com.ef.parser.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.parser.dao.LogDAO;
import com.ef.parser.model.Comment;
import com.ef.parser.model.Log;

import com.ef.parser.model.Parameters;
import com.ef.parser.repository.LogRepository;

@Service
public class ParserServiceImpl implements ParserService {

	@Autowired
	LogDAO logDAO;

	@Override
	public void parseFile(String fileToBeParsed) throws IOException, ParseException {
		// TODO Auto-generated method stub
		List<Log> logs = new ArrayList<>();
		Reader in = new FileReader(fileToBeParsed);
		int i = 1;
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter('|').parse(in);
		for (CSVRecord record : records) {
			if (i == 150000) {
				break;
			}
			Log log = new Log();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			String dateString = record.get(0);
			dateString = dateString.replace("\uFEFF", ""); // remove UTF BOM

			java.util.Date date = formatter.parse(dateString);

			java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());

			log.setDate(sqlDate);

			log.setIpAddress(record.get(1));
			log.setHttpMethod(record.get(2));

			log.setReponse(record.get(3));

			log.setHttpClient(record.get(4));

			logs.add(log);

			i++;

		}

		// save to data base
		logDAO.saveAllLog(logs);

	}

	@Override
	public List<Log> getSelectionLog(Parameters params) {
		List<Log> logs = new ArrayList<>();

		logs = logDAO.getSelectionLog(params);

		return logs;

	}

	@Override
	public void printSelectionLog(List<Log> logs) {

		for (Log log : logs) {
			System.out.println(log.getIpAddress() + "  ");
		}

	}

	@Override
	public void saveComments(List<Log> logs, Parameters parameters) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		for (Log log : logs) {

			Comment comment = new Comment();

			comment.ip = log.getIpAddress();
			comment.comment = "This ip has exceeded more than " + Long.toString(parameters.getThreshold())
					+ " requests from :" + dateFormat.format(parameters.getStartDate()) + " to "
					+ dateFormat.format(parameters.getEndDate());

			logDAO.saveComment(comment);
		}

	}

}
