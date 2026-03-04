package it.diegotaioli.events.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="events")
public class Event {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "name required")
	@Size(min = 3, message = "name too short")
	private String name;
	@NotEmpty(message = "place required")
	private String place;
	private String description;
	@NotNull(message = "date required")
	private LocalDateTime date;
	@NotNull(message = "guests required")
	private int guests;
	
}
