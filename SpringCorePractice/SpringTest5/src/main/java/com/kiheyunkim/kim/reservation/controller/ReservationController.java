package com.kiheyunkim.kim.reservation.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.kiheyunkim.kim.reservation.model.Reservation;
import com.kiheyunkim.kim.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationController {
	private final ReservationService reservationService;
	private final TaskExecutor taskExcutor;
	
	@Lazy
	public ReservationController(ReservationService reservationService,TaskExecutor taskExecutor) {
		this.reservationService = reservationService;
		this.taskExcutor = taskExecutor;
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
	}
	/*
	@GetMapping(params = "courtName")
	public ResponseBodyEmitter find(@RequestParam("courtName")String courtName) {
		System.out.println(courtName);
		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		taskExcutor.execute(()->{
			Collection<Reservation> reservations = reservationService.query(courtName);
			try {
				System.out.println(reservations.size());
				for(Reservation reservation : reservations) {
					Thread.sleep(2000);
					emitter.send(reservation);					
				}
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		
		return emitter;
	}
	*/
	
	/*
	@GetMapping(params = "courtName")
	public ResponseEntity<ResponseBodyEmitter> find(@RequestParam("courtName")String courtName){
		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		
		taskExcutor.execute(()->{
			Collection<Reservation> reservations = reservationService.query(courtName);
			try {
				System.out.println(reservations.size());
				for(Reservation reservation : reservations) {
					emitter.send(reservation);					
				}
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			}
		});
		
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
				.header("Custom-Header", "Custom-Value")
				.body(emitter);
	}
	*/
	
	@GetMapping(params = "courtName")
	public SseEmitter find(@RequestParam("courtName")String courtName) {
		final SseEmitter emitter = new SseEmitter();
		taskExcutor.execute(()->{
			Collection<Reservation> reservations = reservationService.query(courtName);
			try {
				for(Reservation reservation : reservations) {
					emitter.send(SseEmitter.event().id(String.valueOf(reservation.getHour()))
							.data(reservation));
				}
				emitter.complete();
			} catch (Exception e) {
				emitter.completeWithError(e);
			}
		});
		
		return emitter;
	}
}
