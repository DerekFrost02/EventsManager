package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.dto.ResponseMemberDto;
import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.services.MemberService;

@RestController
public class MemberController {
	
    private MemberService membrService;
	
	public MemberController(MemberService membrService) {
		this.membrService = membrService;
	}
	
	@GetMapping("api/members")
	public ResponseEntity<List<ResponseMemberDto>> index()
	{
		List<ResponseMemberDto> membrs = this.membrService.getAll();
		return ResponseEntity.ok(membrs);
	}
	
	@GetMapping("api/members/{id}")
	public ResponseEntity<ResponseMemberDto> indexById(@PathVariable String id) throws ResourceNotFoundException
	{
		Long chiave = Long.parseLong(id);
		ResponseMemberDto membr = this.membrService.getById(chiave);
		return ResponseEntity.ok(membr);
	}


}
