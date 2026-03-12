package it.diegotaioli.events.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class ResponseMemberDto {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;

}
