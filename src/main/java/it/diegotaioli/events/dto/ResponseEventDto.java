package it.diegotaioli.events.dto;


import java.time.LocalDateTime;
import java.util.List;

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
	private String description;
	private LocalDateTime date;
	private Integer guests;
	private List<ResponseMemberDto> members;

}
