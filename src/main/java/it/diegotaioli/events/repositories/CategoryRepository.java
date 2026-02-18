package it.diegotaioli.events.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import it.diegotaioli.events.models.Category;

@Repository
public class CategoryRepository {
	
private JdbcTemplate jdbcTemplate; 
	
	public CategoryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Category> findAll() 
	{
		String query = "SELECT * FROM categories";
		
		RowMapper<Category> rowMapper = new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				
				Category category = new Category(id, name);
				return category;
			}
		};
		
		List<Category> categories = jdbcTemplate.query(query, rowMapper);
		return categories;
		
	}

}
