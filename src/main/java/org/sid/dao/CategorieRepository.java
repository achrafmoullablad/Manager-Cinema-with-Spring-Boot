package org.sid.dao;

import org.sid.entite.Categorie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin("*")

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	public Page<Categorie> findByNameContains(String mc, Pageable pageable);


}
