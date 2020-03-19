package com.kiheyunkim.kim.reservation.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kiheyunkim.kim.player.model.Player;
import com.kiheyunkim.kim.sportType.model.SportType;

public class Reservation {
	private String courtName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private int hour;
	private Player player;
	private SportType sportType;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(String courtName, Date date, int hour, Player player, SportType sportType) {
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
		this.player = player;
		this.sportType = sportType;
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
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
	
	public SportType getSportType() {
		return sportType;
	}
}
