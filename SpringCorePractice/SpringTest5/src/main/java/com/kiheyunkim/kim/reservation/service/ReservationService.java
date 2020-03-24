package com.kiheyunkim.kim.reservation.service;

import java.util.List;

import com.kiheyunkim.kim.common.config.ReservationNotAvailableException;
import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.sportType.model.SportType;

public interface ReservationService {
	public List<Reservation> query(String courtName);
	void make(Reservation reservation) throws ReservationNotAvailableException;
	public List<SportType> getAllSportTypes();
}
