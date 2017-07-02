/*
 * Class Prenotazione
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

import java.util.ArrayList;

/**
 * E' la classe contenente i metodi relativi
 * alla gestione dei dati delle prenotazioni.
 * 
 * @author Gabriele Grieco
 */
public class Prenotazione {
	private String codiceIdentificativo, richieste, strstiva, strspeciali;
	private Integer bagagliStiva, bagagliSpeciali;
	private ArrayList<Persona> passeggeri=new ArrayList<Persona>();
	private ArrayList<String> ticketNumber=new ArrayList<String>();

	public String getCodiceIdentificativo() {
		return codiceIdentificativo;
	}

	public void setCodiceIdentificativo(String s) {
		this.codiceIdentificativo = s;
	}
	
	public ArrayList<Persona> getPasseggeri() {
		return passeggeri;
	}

	public ArrayList<String> getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber.add(ticketNumber);
	}

	public void setPasseggeri(Persona passeggero) {
		this.passeggeri.add(passeggero);
	}

	public Integer getBagagliStiva() {
		return bagagliStiva;
	}
	
	public void setBagagliStiva(Integer i) {
		this.bagagliStiva = i;
	}
	
	public Integer getBagagliSpeciali() {
		return bagagliSpeciali;
	}
	
	public void setBagagliSpeciali(Integer i) {
		this.bagagliSpeciali = i;
	}
	
	public String getRichieste() {
		return richieste;
	}
	
	public void setRichieste(String s) {
		this.richieste = s;
	}
	
	public String getStrstiva() {
		return strstiva;
	}
	
	public void setStrstiva(String s) {
		this.strstiva = s;
	}
	
	public String getStrspeciali() {
		return strspeciali;
	}
	
	public void setStrspeciali(String s) {
		this.strspeciali = s;
	}
}
