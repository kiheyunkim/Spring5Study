package com.kiheyunkim.kim.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.kiheyunkim.kim.common.config.ReservationNotAvailableException;
import com.kiheyunkim.kim.player.Player;
import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;
import com.kiheyunkim.kim.sportType.model.SportType;


@Component
public class DataInitializer {

    private static final List<String> NAMES = Arrays.asList("Roger", "James", "Marten", "Josh");
    private final ReservationService reservationService;
    private final Random rnd = new Random();
    
    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");

    public DataInitializer(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostConstruct
    public void init() {

        List<SportType> sportTypes = Arrays.asList(TENNIS, SOCCER);

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
