package com.kiheyunkim.kim.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {
	private final ReservationService reservationService;
	
	@Autowired
	public ReservationFormController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservation",reservation);
		return "reservationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String submitForm(@ModelAttribute("reservation")Reservation reservation,
			BindingResult result,
			SessionStatus status) {
		System.out.println(reservation.getCourtName());
		System.out.println(reservation.getDate());
		System.out.println(reservation.getHour());
		
		System.out.println(result.getAllErrors());
		System.out.println(status.toString());
		
		reservationService.make(reservation);
		return "redirect:reservationSuccess";
	}
}
