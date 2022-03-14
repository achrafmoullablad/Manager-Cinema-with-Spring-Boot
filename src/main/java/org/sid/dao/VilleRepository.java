package org.sid.dao;


import org.sid.entite.Ville;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface VilleRepository  extends JpaRepository<Ville, Long>{
	public Page<Ville> findByNameContains(String mc, Pageable pageable);



}
