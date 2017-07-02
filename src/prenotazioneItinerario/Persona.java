/*
 * Class Persona
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe contenente i metodi necessari
 * alla gestione dei dati anagrafici degli
 * utenti.
 * 
 * @author Gabriele Grieco
 */
public class Persona {
	private String nome, cognome, sesso, nazionalita, email, strgg, strmm, straaaa, streta;
	private Data dataNascita;
	private Integer eta;
	
	public void setNome(String s) {
		this.nome=s;		
	}
	
	public void setCognome(String s) {
		this.cognome=s;		
	}
	
	public void setSesso(String s) {
		this.sesso=s;		
	}
	
	public void setNazionalita(String s) {
		this.nazionalita=s;		
	}
	
	public void setEta(Integer i) {
		this.eta=i;		
	}
	
	public void setEmail(String s) {
		this.email=s;		
	}
		
	public void setGiornoNascita(Integer i) {
		this.dataNascita.setGiorno(i);
	}
	
	public void setMeseNascita(Integer i) {
		this.dataNascita.setMese(i);
	}
	
	public void setAnnoNascita(Integer i) {
		this.dataNascita.setAnno(i);
	}
	
	public void setStrgg(String s) {
		this.strgg=s;		
	}
	
	public void setStrmm(String s) {
		this.strmm=s;		
	}
	
	public void setStraaaa(String s) {
		this.straaaa=s;		
	}
	
	public void setStreta(String s) {
		this.streta=s;		
	}

	public void inizializzaDataNascita() {
		this.dataNascita=new Data();		
	}
		
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Integer getGiornoNascita() {
		return this.dataNascita.getGiorno();
	}
	
	public Integer getMeseNascita() {
		return this.dataNascita.getMese();
	}
	
	public Integer getAnnoNascita() {
		return this.dataNascita.getAnno();
	}

	public String getSesso() {
		return sesso;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public Integer getEta() {
		return eta;
	}

	public String getEmail() {
		return email;
	}
	
	public String getStrgg() {
		return strgg;		
	}
	
	public String getStrmm() {
		return strmm;		
	}
	
	public String getStraaaa() {
		return straaaa;		
	}
	
	public String getStreta() {
		return streta;		
	}
}
