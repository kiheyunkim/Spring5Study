package com.kiheyunkim.kim.common.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.kiheyunkim.kim.player.model.Player;
import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;
import com.kiheyunkim.kim.sportType.model.SportType;

@Configuration
public class Initialization {
	private static final List<String> NAMES = Arrays.asList("Roger", "James", "Marten", "Josh");
	private final ReservationService reservationService;
	private final Random rnd = new Random();

	@Lazy
	@Autowired
	public Initialization(ReservationService reservationService) {
	    this.reservationService = reservationService;
	}

	@PostConstruct
	public void init() {
	    List<SportType> sportTypes = reservationService.getAllSportTypes();
	    System.out.println(sportTypes.size());
	    for (int i = 0; i < 100 ; i++) {
	        int type = rnd.nextInt(sportTypes.size());
	        int courtNum = rnd.nextInt(3);
	        SportType sportType = sportTypes.get(type);
	        String court = sportType.getName() + " #" + courtNum;

	        String name = NAMES.get(rnd.nextInt(NAMES.size()));

	        try {
	            reservationService.make(new Reservation(court, LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1), rnd.nextInt(24), new Player(name, "N/A"), sportType));
	        } catch (ReservationNotAvailableException e) {}
	    }
	}
}
