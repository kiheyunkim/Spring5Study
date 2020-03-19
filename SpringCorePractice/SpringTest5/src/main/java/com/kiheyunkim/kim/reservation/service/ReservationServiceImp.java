package com.kiheyunkim.kim.reservation.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kiheyunkim.kim.common.config.ReservationNotAvailableException;
import com.kiheyunkim.kim.player.model.Player;
import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.sportType.model.SportType;

@Service
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
		
		return this.reservations.stream()
				.filter(element -> element.getCourtName().equals(courtName))
				.collect(Collectors.toList());		
	}

	@Override
	public void make(Reservation reservation) throws ReservationNotAvailableException {
		long cnt = reservations.stream()
				.filter(made -> Objects.equals(made.getCourtName(), reservation.getCourtName()))
				.filter(made -> Objects.equals(made.getDate(),reservation.getDate()))
				.filter(made -> made.getHour() == reservation.getHour())
				.count();
		
		if(cnt > 0) {
			throw new ReservationNotAvailableException(reservation.getCourtName(),
					reservation.getDate(), reservation.getHour());
		}else {
			reservations.add(reservation);
		}
				
		
	}
}
