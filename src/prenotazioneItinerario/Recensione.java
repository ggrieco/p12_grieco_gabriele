/*Class Recensione
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe contenente i metodi necessari
 * alla gestione dei commenti lasciati dagli
 * utenti.
 * 
 * @author Gabriele Grieco
 */
public class Recensione {
	private String titolo, ambito, testo, strvalutazione;
	private Integer valutazione;

	public void setTitolo(String s) {
		this.titolo = s;
	}

	public void setAmbito(String s) {
		this.ambito = s;
	}

	public void setTesto(String s) {
		this.testo = s;
	}

	public void setValutazione(Integer i) {
		this.valutazione = i;
	}
	
	public void setStrvalutazione (String s) {
		this.strvalutazione = s;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAmbito() {
		return ambito;
	}

	public String getTesto() {
		return testo;
	}

	public Integer getValutazione() {
		return valutazione;
	}
	
	public String getStrvalutazione() {
		return strvalutazione;
	}
}