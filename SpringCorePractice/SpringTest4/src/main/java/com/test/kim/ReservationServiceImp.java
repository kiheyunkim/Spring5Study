package com.test.kim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImp implements ReservationService {

	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccor");
	
	private final List<Reservation> reservations = new ArrayList<Reservation>();
	
	public ReservationServiceImp() {
		reservations.add(new Reservation("Tennis #1", LocalDate.of(2020, 3, 3), 16, new Player("Roger", "N/A"), TENNIS));
		reservations.add(new Reservation("Tennis 2", LocalDate.of(2020, 3, 17), 16, new Player("Roger", "N/A"), TENNIS));
	}
	
	@Override
	public List<Reservation> query(String courtName) {
		// TODO Auto-generated method stub
		return this.reservations.stream()
				.filter(reservation->Objects.equals(reservation.getCourtName(),courtName))
				.collect(Collectors.toList());
	}
	
}
