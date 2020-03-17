package com.kiheyunkim.kim.reservation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kiheyunkim.kim.player.Player;
import com.kiheyunkim.kim.reservation.service.ReservationService;
import com.kiheyunkim.kim.sportType.SportType;

public class ReservationServiceImp implements ReservationService {

	public static final SportType TENNIS = new SportType(1,"Tennis");
	public static final SportType SOCCER = new SportType(2, "soccer");
	
	public final List<Reservation> reservations = new ArrayList<Reservation>();
	
	public ReservationServiceImp() {
		reservations.add(new Reservation("Tennis #1", 
				Date.from(LocalDate.of(2008, 1, 4).atStartOfDay(ZoneId.systemDefault()).toInstant())
				, 16, new Player("James","N/A"), TENNIS));
		
		reservations.add(new Reservation("Tennis #2", 
				Date.from(LocalDate.of(2008, 1, 14).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				20, new Player("James", "N/A"), TENNIS));
	}
	
	@Override
	public List<Reservation> query(String courtName) {
		// TODO Auto-generated method stub
		return null;
	}
}
