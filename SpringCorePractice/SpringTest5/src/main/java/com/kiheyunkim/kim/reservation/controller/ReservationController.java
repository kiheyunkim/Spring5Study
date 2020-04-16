package com.kiheyunkim.kim.reservation.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Delayed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationController {
	private final ReservationService reservationService;
	private final TaskExecutor taskExecutor;
	
	@Lazy
	@Autowired
	public ReservationController(ReservationService reservationService, TaskExecutor taskExecutor) {
		this.reservationService = reservationService;
		this.taskExecutor = taskExecutor;
	}
	
	@GetMapping
	public void setupForm() {
		
	}
	
	@PostMapping
	public String submitForm(@RequestParam("courtName")String courtName, Model model) {
		
		List<Reservation> reservations  = reservationService.query(courtName);
		model.addAttribute("reservation",reservations);
		return "reservationQuery";
	}
	
	@GetMapping(params = "courtName")
	public ResponseBodyEmitter find(@RequestParam("courtName")String courtName) {
		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		taskExecutor.execute(()->{
			Collection<Reservation> reservations = reservationService.query(courtName);
			System.out.println(reservations.size());
			try {
				for(Reservation reservation : reservations) {
					emitter.send(reservation);					
				}
				emitter.complete();
			}catch (Exception e) {
				emitter.completeWithError(e);
			}
		});
		
		return emitter;
	}
	
	@GetMapping(params = "courtName2")
	public SseEmitter find2(@RequestParam("courtName2") String courtName) {
		final SseEmitter emitter = new SseEmitter();
		taskExecutor.execute(()->{
			Collection<Reservation> reservations = reservationService.query(courtName);
			try {
				for(Reservation reservation : reservations) {
					try {
						Thread.sleep(125);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					emitter.send(reservation);
				}
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			}
		});
		
		return emitter;
	}
	
}
