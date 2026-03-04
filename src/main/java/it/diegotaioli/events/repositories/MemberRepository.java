package it.diegotaioli.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.diegotaioli.events.models.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	

}
