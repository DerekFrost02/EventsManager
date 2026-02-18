package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.models.Member;
import it.diegotaioli.events.repositories.MemberRepository;

@Service
public class MemberService {
	
    private MemberRepository membrRepository;
	
	public MemberService(MemberRepository membrRepository) {
		this.membrRepository = membrRepository;
	}
	
	public List<Member> getAll()
	{
		return this.membrRepository.findAll();
	}

}
