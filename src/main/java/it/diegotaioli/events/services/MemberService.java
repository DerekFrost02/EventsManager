package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.dto.ResponseMemberDto;
import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.mappers.MemberMapper;
import it.diegotaioli.events.models.Member;
import it.diegotaioli.events.repositories.MemberRepository;

@Service
public class MemberService {
	
    private MemberRepository membrRepository;
	
	public MemberService(MemberRepository membrRepository) {
		this.membrRepository = membrRepository;
	}
	
	public List<ResponseMemberDto> getAll()
	{
		return this.membrRepository.findAll()
				.stream()
				.map(MemberMapper::toDto)
				.toList();
	}
	
	public ResponseMemberDto getById(Long id) throws ResourceNotFoundException
	{
		ResponseMemberDto membr = this.membrRepository.findById(id).map(MemberMapper::toDto)
				.orElseThrow(
					() ->new ResourceNotFoundException("Evento con id " + id + " non trovato")
		);
		return membr;
	}

}
