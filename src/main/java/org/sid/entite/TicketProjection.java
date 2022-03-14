package org.sid.entite;




//@Projection(name="ticketProj",types= Ticket.class)
public interface TicketProjection {

	
	public Long getId();
	public String getnomClient();
	public double getPrix();
	public Integer getCodePayement();
	public boolean getReservee();
	public Place getPlace();
	
}
 
