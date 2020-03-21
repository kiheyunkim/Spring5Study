package com.kiheyunkim.kim.common.config;

import java.time.LocalDate;
import java.util.Date;

public class ReservationNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courtName;
	private LocalDate date;
	private int hour;
	
	public ReservationNotAvailableException(String courtName, LocalDate date, int hour) {
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
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getHour() {
		return hour;
	}
}
