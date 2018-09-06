package com.ef.parser.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.ef.parser.model.Log;
import com.ef.parser.model.Parameters;

public interface ParserService {

	
	
	public void parseFile(String filetoBeParsed) throws FileNotFoundException, IOException, ParseException;
	
	
	// public void printAllLog();
	
	 

	List<Log> getSelectionLog(Parameters params);
	

	void printSelectionLog(List<Log> logs);


	public void saveComments(List<Log> logs, Parameters parameters);

	
	
	
	
	
}
