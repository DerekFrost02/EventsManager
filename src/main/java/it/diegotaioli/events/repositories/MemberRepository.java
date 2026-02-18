package it.diegotaioli.events.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.diegotaioli.events.models.Member;

@Repository
public class MemberRepository {
	
private JdbcTemplate jdbcTemplate; 
	
	public MemberRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Member> findAll() 
	{
		String query = "SELECT * FROM members";
		
		RowMapper<Member> rowMapper = new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Long id = rs.getLong("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				
				Member membr = new Member(id, firstname, lastname, email);
				return membr;
			}
		};
		
		List<Member> membrs = jdbcTemplate.query(query, rowMapper);
		return membrs;
		
	}

}
