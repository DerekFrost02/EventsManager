package it.diegotaioli.events.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class Member {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}
