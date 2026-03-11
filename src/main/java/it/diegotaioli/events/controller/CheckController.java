package it.diegotaioli.events.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	
	@GetMapping("api/up")
	public ResponseEntity<Map<String, Object>> home(){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("status", HttpStatus.OK);
		body.put("message", "UP");
		return ResponseEntity.ok(body);
	}

}
