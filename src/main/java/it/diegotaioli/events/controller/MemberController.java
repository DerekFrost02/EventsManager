package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.models.Member;
import it.diegotaioli.events.services.MemberService;

@RestController
public class MemberController {
	
    private MemberService membrService;
	
	public MemberController(MemberService membrService) {
		this.membrService = membrService;
	}
	
	@GetMapping("api/members")
	public ResponseEntity<List<Member>> index()
	{
		List<Member> membrs = this.membrService.getAll();
		return ResponseEntity.ok(membrs);
	}


}
