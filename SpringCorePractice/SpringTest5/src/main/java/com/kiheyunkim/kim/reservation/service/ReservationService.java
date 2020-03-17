package com.kiheyunkim.kim.reservation.service;

import java.util.List;

import com.kiheyunkim.kim.reservation.model.Reservation;

public interface ReservationService {
	public List<Reservation> query(String courtName);
}
