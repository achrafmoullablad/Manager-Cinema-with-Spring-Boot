package org.sid.dao;



import org.sid.entite.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface TickeRepository extends JpaRepository<Ticket, Long> {

	Page<Ticket> findBynomClientContains(String mc, PageRequest of);

	@Query("select t from Ticket t where t.projectionFilm.id = :idp")
	public Page<Ticket> Ticketsparprojection(@Param ("idp")Long id, Pageable pageable);
}
