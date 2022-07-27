package com.prathamesh.SpringBootJpaDemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prathamesh.SpringBootJpaDemo.models.Alien;


public interface AlienRepository extends JpaRepository<Alien, Integer> {
	List<Alien> findByAname(String name);
	List<Alien> findByAidGreaterThan(int id);
	
	@Query("from Alien where aname=?1 order by aid")
	List<Alien> findByAnameSortById(String aname);
}
