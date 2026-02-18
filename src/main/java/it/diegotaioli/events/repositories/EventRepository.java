package it.diegotaioli.events.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.models.Event;

@Repository
public class EventRepository {
	
	private JdbcTemplate jdbcTemplate; 
	
	public EventRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Event> findAll(){
		String query = "SELECT * FROM events";
		List<Event> events = jdbcTemplate.query(query, getRowMapper());
		return events;
	}
	
	public Optional<Event> findById(Long id) throws ResourceNotFoundException{
		String query = "SELECT * FROM events WHERE id = ?";
		
		RowMapper<Event> rowMapper = this.getRowMapper();
		
		Optional <Event> event = jdbcTemplate.query(query, rowMapper, id)
				.stream()
				.findFirst();
			
		return event;

	}
	
	private RowMapper<Event> getRowMapper() 
	{
		RowMapper<Event> rowMapper = new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String place = rs.getString("place");
				String description = rs.getString("description");
				LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
				int guests = rs.getInt("guests");
				
				Event event = new Event(id, name, place, description, date, guests);
				return event;
			}
		};		
		return rowMapper;	
	}
}
