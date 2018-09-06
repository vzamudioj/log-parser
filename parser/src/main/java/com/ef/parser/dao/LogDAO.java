package com.ef.parser.dao;

import java.util.List;

import com.ef.parser.model.Comment;
import com.ef.parser.model.Log;

import com.ef.parser.model.Parameters;

public interface LogDAO {

	void saveAllLog(List<Log> logs);
	
	public List<Log> getSelectionLog(Parameters params);

	void saveComment(Comment comment);

	

	
}
