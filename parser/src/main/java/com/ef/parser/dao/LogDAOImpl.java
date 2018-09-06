package com.ef.parser.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ef.parser.model.Comment;
import com.ef.parser.model.Log;

import com.ef.parser.model.Parameters;
import com.ef.parser.repository.CommentRepository;
import com.ef.parser.repository.LogRepository;

@Repository
public class LogDAOImpl implements LogDAO {

	@Autowired
	private LogRepository logRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	private EntityManager em;

	@Override
	public void saveAllLog(List<Log> logs) {
		// TODO Auto-generated method stub

		logRepository.saveAll(logs);

	}

	@Override
	public List<Log> getSelectionLog(Parameters params) {
		// TODO Auto-generated method stub
		List<Log> list = new ArrayList<>();
		TypedQuery<Log> queryString = em
				.createQuery("SELECT l FROM Log l " + " WHERE l.date BETWEEN :startDate AND :endDate "
						+ "GROUP BY l.ipAddress HAVING count(l.ipAddress) >= :threshold", Log.class)
				.setParameter("startDate", params.getStartDate()).setParameter("endDate", params.getEndDate())
				.setParameter("threshold", params.getThreshold());

		list = queryString.getResultList();

		System.out.println("\n\n" + "Query executed sucessfully !!!" + "\n");

		return list;

	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub

		commentRepository.save(comment);

	}

}
