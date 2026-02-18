package it.diegotaioli.events.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class Event {
	
	private Long id;
	private String name;
	private String place;
	private String description;
	private LocalDateTime date;
	private int guests;
	
}
