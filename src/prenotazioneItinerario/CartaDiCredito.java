/*
 * Class CartaDiCredito
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe che contiene i metodi get e
 * set per gestire i dati della carta di
 * credito durante la fase di pagamento
 * 
 * @author Gabriele Grieco
 */
public class CartaDiCredito extends Pagamento{
	private String nomeIntestatario, cognomeIntestatario, scadenza, strcodice, strnumero;
	private Integer numeroCarta, meseScadenza, annoScadenza, codiceSicurezza;

	public String getNomeIntestatario() {
		return nomeIntestatario;
	}

	public void setNomeIntestatario(String nomeIntestatario) {
		this.nomeIntestatario = nomeIntestatario;
	}
	
	public String getScadenza() {
		return scadenza;
	}
	
	public String getStrcodice() {
		return strcodice;
	}

	public String getStrnumero() {
		return strnumero;
	}
	
	public String getCognomeIntestatario() {
		return cognomeIntestatario;
	}

	public void setCognomeIntestatario(String cognomeIntestatario) {
		this.cognomeIntestatario = cognomeIntestatario;
	}
	
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	
	public void setStrcodice(String strcodice) {
		this.strcodice = strcodice;
	}

	public void setStrnumero(String strnumero) {
		this.strnumero = strnumero;
	}
	
	public Integer getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(Integer numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public Integer getMeseScadenza() {
		return meseScadenza;
	}

	public void setMeseScadenza(Integer meseScadenza) {
		this.meseScadenza = meseScadenza;
	}

	public Integer getAnnoScadenza() {
		return annoScadenza;
	}

	public void setAnnoScadenza(Integer annoScadenza) {
		this.annoScadenza = annoScadenza;
	}

	public Integer getCodiceSicurezza() {
		return codiceSicurezza;
	}

	public void setCodiceSicurezza(Integer codiceSicurezza) {
		this.codiceSicurezza = codiceSicurezza;
	}
}
