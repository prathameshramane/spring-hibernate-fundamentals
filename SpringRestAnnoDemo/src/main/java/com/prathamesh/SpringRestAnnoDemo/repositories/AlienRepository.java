package com.prathamesh.SpringRestAnnoDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.prathamesh.SpringRestAnnoDemo.models.Alien;


@RepositoryRestResource(collectionResourceRel="aliens", path="aliens")
public interface AlienRepository extends JpaRepository<Alien, Integer> {
}
