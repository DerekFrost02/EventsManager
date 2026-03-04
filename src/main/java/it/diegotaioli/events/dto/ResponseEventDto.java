package it.diegotaioli.events.dto;

import java.time.LocalDateTime;

import it.diegotaioli.events.models.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class ResponseEventDto 
{
	private Long id;
	private String name;
	private String place;
	private Integer guests;
	//private LocalDateTime createdAt; 

}
