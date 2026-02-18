package it.diegotaioli.events.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.diegotaioli.events.models.Location;

@Repository
public class LocationRepository {
	
private JdbcTemplate jdbcTemplate; 
	
	public LocationRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Location> findById(Long id)
	{
		String query = "SELECT * FROM locations WHERE id =" + id;
		return find(query);
	}
	
	public List<Location> findAll()
	{
		String query = "SELECT * FROM locations";
		return find(query);
	}
	
	private List<Location> find(String query) 
	{
		
		RowMapper<Location> rowMapper = new RowMapper<Location>() {

			@Override
			public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				String country = rs.getString("country");
				
				Location location = new Location(id, name, city, country);
				return location;
			}
		};
		
		List<Location> locations = jdbcTemplate.query(query, rowMapper);
		return locations;
		
	}

}
