package it.diegotaioli.events.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
@Entity @Table(name="members")
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "name required")
	@Size(min = 3, message = "name too short")
	private String firstName;
	@NotEmpty(message = "lastname required")
	@Size(min = 3, message = "lastname too short")
	private String lastName;
	@NotEmpty(message = "email required")
	@Size(min = 3, message = "email too short")
	private String email;

}
