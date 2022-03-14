package org.sid.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.validation.Valid;

import org.apache.commons.io.IOUtils;

import org.sid.dao.CinemaRepository;
import org.sid.dao.FilmRepository;
import org.sid.dao.ProjectionFilmRepository;
import org.sid.dao.SalleRepository;
import org.sid.dao.TickeRepository;
import org.sid.dao.VilleRepository;

import org.sid.entite.Cinema;
import org.sid.entite.Film;
import org.sid.entite.ProjectionFilm;
import org.sid.entite.Salle;
import org.sid.entite.Ticket;
import org.sid.entite.Ville;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Conrolleur {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private FilmRepository filmRepository;


	@Autowired
	private ProjectionFilmRepository projectionFilmRepository;
	
	

	@Autowired
	private TickeRepository tickeRepository;
	
	

	

	
	
	
	
	
@GetMapping(path = "/villes")
	public String listVilles(Model model,
			//afficher dans url
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "5")int size,
		    @RequestParam (name="keyword",defaultValue = "")String mc){
		Page<Ville> pageVilles=villeRepository.findByNameContains(mc, PageRequest.of(page ,size));
		model.addAttribute("villes",pageVilles.getContent());
		model.addAttribute("pages",new int [pageVilles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "villes";
	}
	

	@GetMapping(path="/formVille")
		public String formPatient(Model model) {
		model.addAttribute("ville",new Ville());
		  return "formVille";
		}
	@PostMapping("/saveVille")
	public String savePatient(Model model ,@Valid Ville ville,BindingResult bindingResult) {
		if( bindingResult.hasErrors()) return "formVille";
		villeRepository.save(ville);
		model.addAttribute("villet",ville);
		return "confirmation";
		
	
	
	

}
	@GetMapping(path="/editVille")
	public String editVille(Model model,Long id) {
		Ville v=villeRepository.findById(id).get();
	model.addAttribute("ville",v);
	  return "formVille";
	}
	





@GetMapping(path = "/cinemas")
	public String listCinema(Model model,
			//afficher dans url
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "5")int size,
		    @RequestParam (name="keyword",defaultValue = "")String mc,
	        @RequestParam (name="idv",required = false)Long idv){
		Page<Cinema> pageCinemas;
		if(idv !=null)
			
			pageCinemas=cinemaRepository.cinemaparviles(idv, PageRequest.of(page ,size));
		else	
			pageCinemas=cinemaRepository.findByNameContains(mc, PageRequest.of(page ,size));
		model.addAttribute("cinemas",pageCinemas.getContent());
		model.addAttribute("pages",new int [pageCinemas.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "cinemas";
	}
	




@GetMapping(path="/formCinema")
public String formcinema(Model model) {
model.addAttribute("cinema",new Cinema());
  return "formCinema";
}
@PostMapping("/saveCinema")
public String savePatient(Model model ,@Valid Cinema cinema,BindingResult bindingResult) {
if( bindingResult.hasErrors()) return "formCinema";
cinemaRepository.save(cinema);
model.addAttribute("cinema",cinema);
return "confirmationC";

}


@GetMapping(path="/editCinema")
public String editCinema(Model model,Long id) {
	Cinema c=cinemaRepository.findById(id).get();
model.addAttribute("cinema",c);
  return "formCinema";
}















@GetMapping(path = "/salles")
	public String listSalle(Model model,
			//afficher dans url
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "5")int size,
		    @RequestParam (name="keyword",defaultValue = "")String mc,
	        @RequestParam (name="ids",required = false)Long ids){
		Page<Salle> pageSalles;
		if(ids !=null)
			
			pageSalles=salleRepository.Salleparcinema(ids, PageRequest.of(page ,size));
		else	
			pageSalles=salleRepository.findByNameContains(mc, PageRequest.of(page ,size));
		model.addAttribute("salles",pageSalles.getContent());
		model.addAttribute("cinemas",new int [pageSalles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "salles";
	}
	




@GetMapping(path="/formSalle")
public String formsalle(Model model) {
model.addAttribute("salle",new Salle());
  return "formSalle";
}
@PostMapping("/saveSalle")
public String saveSalle(Model model ,@Valid Salle salle,BindingResult bindingResult) {
if( bindingResult.hasErrors()) return "formSalle";
salleRepository.save(salle);
model.addAttribute("salle",salle);
return "confirmationS";

}



@GetMapping(path="/editSalle")
public String editSalle(Model model,Long id) {
	Salle s=salleRepository.findById(id).get();
model.addAttribute("salle",s);
  return "formSalle";
}










@GetMapping(path = "/films")
public String listfilms(Model model,
		//afficher dans url
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size",defaultValue = "5")int size,
	    @RequestParam (name="keyword",defaultValue = "")String kw){
	Page<Film> pageFilms= filmRepository.findBytitreContains(kw, PageRequest.of(page ,size));
	model.addAttribute("films",pageFilms.getContent());
	model.addAttribute("pages",new int [pageFilms.getTotalPages()]);
	model.addAttribute("currentPage", page);
	model.addAttribute("size", size);
	model.addAttribute("keyword", kw);
	return "films";
}




@PostMapping("/saveFilm")
public String saveFilm(Model model ,@Valid Film film,BindingResult bindingResult) {
if( bindingResult.hasErrors()) return "formfilm";
filmRepository.save( film);
model.addAttribute(" film",film);
return "confirmationF";

}








@GetMapping(path = "/getPhoto{id}", produces = MediaType.IMAGE_JPEG_VALUE)
@ResponseBody
public byte[] getPhoto(Long id) throws FileNotFoundException, IOException {
	Film f = filmRepository.findById(id).get();
	String photoName = f.getPhoto();
	File file = new File(System.getProperty("user.home") + "/cinema/images/" + photoName);
	return IOUtils.toByteArray(new FileInputStream(file));
	
}



@GetMapping(path="/formfilm")
public String formfilm(Model model) {
	model.addAttribute("film",new Film());
  return "formfilm";
}


@GetMapping(path="/editFilm")
public String editFilm(Model model,Long id) {
	Film f=filmRepository.findById(id).get();
model.addAttribute("film",f);
  return "formFilm";
}






@GetMapping(path = "/projections")
	public String listProjections(Model model,
			//afficher dans url
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "5")int size,
		    @RequestParam (name="keyword",defaultValue = "")String mc,
	        @RequestParam (name="idf",required = false)Long idf){
		Page<ProjectionFilm> pageProjections;
		if(idf !=null)
			
			pageProjections=projectionFilmRepository.Projectionparfilm(idf, PageRequest.of(page ,size));
		else	
			pageProjections=projectionFilmRepository.findByprixContains(mc, PageRequest.of(page ,size));
		model.addAttribute("projections",pageProjections.getContent());
		model.addAttribute("pages",new int [pageProjections.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "projections";
	}
	




@GetMapping(path="/formpojection")
public String formprojection(Model model) {
model.addAttribute("projectionFilm",new ProjectionFilm());
  return "formprojection";
}
@PostMapping("/saveProjection")
public String saveProjection(Model model ,@Valid ProjectionFilm projectionFilm,BindingResult bindingResult) {
if( bindingResult.hasErrors()) return "formProjection";
projectionFilmRepository.save( projectionFilm);
model.addAttribute(" projectionFilm", projectionFilm);
return "confirmationP";

}

@GetMapping(path="/editProjection")
public String editProjection(Model model,Long id) {
ProjectionFilm  f=projectionFilmRepository.findById(id).get();
model.addAttribute("projectionFilm",f);
  return "formprojection";
}








@GetMapping(path = "/tickets")
	public String listtickets(Model model,
			//afficher dans url
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "5")int size,
		    @RequestParam (name="keyword",defaultValue = "")String mc,
	        @RequestParam (name="idp",required = false)Long idp){
		Page<Ticket> pageTickets;
		if(idp !=null)
			
			 pageTickets=tickeRepository. Ticketsparprojection(idp, PageRequest.of(page ,size));
		else	
			 pageTickets=tickeRepository. findBynomClientContains(mc, PageRequest.of(page ,size));
		model.addAttribute("tickets", pageTickets.getContent());
		model.addAttribute("pages",new int [ pageTickets.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", mc);
		return "tickets";
	}
	







@GetMapping(path="/formticket")
public String formticket(Model model) {
model.addAttribute("ticket",new Ticket());
  return "formticket";
}
@PostMapping("/saveTicket")
public String saveTicket(Model model ,@Valid Ticket ticket,BindingResult bindingResult) {
if( bindingResult.hasErrors()) return "formticket";
tickeRepository.save( ticket);
model.addAttribute(" ticket",ticket);
return "confirmationT";

}











}







