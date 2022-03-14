package org.sid.entite;



import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ ToString
public class ProjectionFilm {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateProjection;
	private double prix;
@ManyToOne
@JsonProperty(access = Access.WRITE_ONLY)
private Salle salle;
@ManyToOne
private Film film;
@OneToMany(mappedBy = "projectionFilm")
@JsonProperty(access = Access.WRITE_ONLY)
private Collection<Ticket> tickets;
@ManyToOne
private Seance seance;



	

}
