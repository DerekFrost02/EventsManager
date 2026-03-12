package it.diegotaioli.events.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="members")
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "name required")
	@Size(min = 3, message = "name too short")
	private String firstname;
	@NotEmpty(message = "lastname required")
	@Size(min = 3, message = "lastname too short")
	private String lastname;
	@NotEmpty(message = "email required")
	@Size(min = 3, message = "email too short")
	private String email;
	
	@ManyToMany(mappedBy = "members")
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property="id"
	)
	private List<Event> events;

}
