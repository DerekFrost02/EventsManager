package it.diegotaioli.events.models;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="places")
public class Place {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "name required")
	@Size(min = 3, message = "name too short")
	private String name;
	
	@NotEmpty(message = "address required")
	@Size(min = 3, message = "address too short")
	private String address;
	
	@NotEmpty(message = "city required")
	@Size(min = 2, message = "city too short")
	private String city;
	
	private Double lon;
	
	private Double lng;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "place")
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
	)
	private List<Event> events;

}
