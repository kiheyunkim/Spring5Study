package com.kiheyunkim.kim.reservation.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationController {
	private final ReservationService reservationService;
	
	@Lazy
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public void setupForm() {
		
	}
	
	@PostMapping
	public Callable<String> submitForm(@RequestParam("courtName")String courtName, Model model) {
		return ()->{
			List<Reservation> reservations = java.util.Collections.emptyList();
			if(courtName != null) {
				Thread.sleep(2000);
				reservations = reservationService.query(courtName);
			}
			model.addAttribute("reservations",reservations);
			return "reservationQuery";
		};
		/*
			List<Reservation> reservations  = reservationService.query(courtName);
			model.addAttribute("reservation",reservations);
			return "reservationQuery";
		*/
	}
	
}
