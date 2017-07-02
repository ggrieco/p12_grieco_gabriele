/*
 * Class Ora
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe contenente i metodi necessari
 * alla gestione degli orari nel programma.
 * 
 * @author Gabriele Grieco
 */
public class Ora {
	private Integer hh, mm;

	public void setOra(Integer i, Integer j) {
		this.hh=i;
		this.mm=j;
	}
	
	public Integer gethh() {
		return this.hh;	
	}
	
	public Integer getmm() {
		return this.mm;	
	}
}
