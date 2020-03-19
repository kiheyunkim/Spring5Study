package com.kiheyunkim.kim.common.config;

import java.util.Date;

public class ReservationNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courtName;
	private Date date;
	private int hour;
	
	public ReservationNotAvailableException(String courtName, Date date, int hour) {
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
	}
	
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	
	public String getCourtName() {
		return courtName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getHour() {
		return hour;
	}
}
