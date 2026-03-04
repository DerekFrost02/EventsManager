package it.diegotaioli.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.diegotaioli.events.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
