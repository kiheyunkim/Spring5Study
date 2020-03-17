package com.kiheyunkim.kim.reservation.controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiheyunkim.kim.reservation.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;

@Controller
@Lazy
@RequestMapping("/reservationQuery")
public class ReservationController {
	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public void setupForm() {
		
	}
	
	@PostMapping
	public String submitForm(@RequestParam("courtName")String courtName, Model model) {
		List<Reservation> reservations = java.util.Collections.emptyList();
		if(courtName!= null ) {
			reservations  = reservationService.query(courtName);
		}
		
		model.addAttribute("reservation",reservations);
		return "reservationQuery";
	}
	
}
