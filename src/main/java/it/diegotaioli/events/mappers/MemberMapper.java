package it.diegotaioli.events.mappers;

import it.diegotaioli.events.dto.ResponseMemberDto;
import it.diegotaioli.events.models.Member;

public class MemberMapper {
	
	public static ResponseMemberDto toDto(Member member) {

		ResponseMemberDto responseMemberDto = new ResponseMemberDto();
		responseMemberDto.setId(member.getId());
		responseMemberDto.setFirstname(member.getFirstname());
		responseMemberDto.setLastname(member.getLastname());
		responseMemberDto.setEmail(member.getEmail());
		
		return responseMemberDto;
	}

}
