package com.kiheyunkim.kim.reservation.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kiheyunkim.kim.player.Player;
import com.kiheyunkim.kim.sportType.model.SportType;

public class Reservation {
	private String courtName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private int hour;
	private Player player;
	private SportType sportType;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(String courtName, LocalDate date2, int hour, Player player, SportType tennis) {
		this.courtName = courtName;
		this.date = date2;
		this.hour = hour;
		this.player = player;
		this.sportType = tennis;
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
