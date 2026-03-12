package it.diegotaioli.events.mappers;

import it.diegotaioli.events.dto.ResponseEventDto;
import it.diegotaioli.events.models.Event;

public class EventMapper {
	
	public static ResponseEventDto toDto(Event event) {
		
		ResponseEventDto responseEventDto = new ResponseEventDto();
		responseEventDto.setId(event.getId());
		responseEventDto.setName(event.getName());
		responseEventDto.setPlace(event.getPlace().getName() + " " + event.getPlace().getAddress() + " " + event.getPlace().getCity());
		responseEventDto.setDescription(event.getDescription());
		responseEventDto.setDate(event.getDate());
		responseEventDto.setGuests(event.getGuests());
		responseEventDto.setMembers(event.getMembers()
				.stream().map(MemberMapper::toDto).toList());
		
		return responseEventDto;
	}

}
