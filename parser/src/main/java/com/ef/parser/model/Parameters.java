package com.ef.parser.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.ApplicationArguments;

public class Parameters {
	private Long threshold;

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private Date startDate;
	private Date endDate;

	private ApplicationArguments args;

	public Parameters(ApplicationArguments args) throws ParseException {
		this.args = args;
		if (args.containsOption("startDate")) {
			String date = args.getOptionValues("startDate").get(0);
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd.hh:mm:ss");
			this.startDate = formatter.parse(date);
			this.endDate = startDate;

			if (args.containsOption("duration")) {
				String duration = args.getOptionValues("duration").get(0);
				if (duration.equals("hourly")) {
					this.endDate = new Date(this.startDate.getTime() + TimeUnit.HOURS.toMillis(1));
				} else if (duration.equals("daily")) {
					this.endDate = new Date(this.startDate.getTime() + TimeUnit.DAYS.toMillis(1));
				}

				if (args.containsOption("threshold")) {
					this.threshold = new Long(args.getOptionValues("threshold").get(0));
				}

			}

		}

	}

	public boolean areOK() {
		return (this.args.containsOption("startDate") && this.args.containsOption("duration")
				&& this.args.containsOption("threshold"));
	}
}