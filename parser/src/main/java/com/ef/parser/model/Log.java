package com.ef.parser.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="date")
	private Timestamp date;
	
	@Column(name="ipaddress")
	private String ipAddress;
	
	@Column(name="httpmethod")
	private String httpMethod;
	
	@Column(name="response")
	private String response;
	
	@Column(name="httpclient")
	private String httpClient;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getResponse() {
		return response;
	}

	public void setReponse(String response) {
		this.response = response;
	}

	public String getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(String httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", date=" + date + ", ipAddress=" + ipAddress + ", httpMethod=" + httpMethod
				+ ", response=" + response + ", httpClient=" + httpClient + "]";
	}
	
	
	

	
	
	
}
