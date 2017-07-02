/*
 * Class Volo
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe contenente i metodi necessari
 * alla gestione dei dati relativi ai voli
 * nelle diverse fasi del programma.
 * 
 * @author Gabriele Grieco
 */
public class Volo {
	private String numeroVolo, aeroportoPartenza, aeroportoDestinazione;
	private Ora orarioPartenza, orarioArrivo, durata;
	private Data dataPartenza, dataArrivo;
	private Integer postiLiberiEconomy, postiLiberiBusiness, prezzoEconomy, prezzoBusiness;

	public void setNumeroVolo(String s) {
		this.numeroVolo=s;
	}

	public void setOrarioPartenza(Integer i, Integer j) {
		this.orarioPartenza.setOra(i,j);
	}

	public void setOrarioArrivo(Integer i, Integer j) {
		this.orarioArrivo.setOra(i,j);
	}

	public void setAeroportoPartenza(String s) {
		this.aeroportoPartenza=s;
	}

	public void setAeroportoDestinazione(String s) {
		this.aeroportoDestinazione=s;
	}

	public void setDataPartenza(Integer i, Integer j, Integer k) {
		this.dataPartenza.setData(i, j, k);
	}

	public void setDataArrivo(Integer i, Integer j, Integer k) {
		this.dataArrivo.setData(i, j, k);
	}

	public void setPostiLiberiEconomy(Integer i) {
		this.postiLiberiEconomy=i;
	}

	public void setPostiLiberiBusiness(Integer i) {
		this.postiLiberiBusiness=i;
	}

	public void setPrezzoEconomy(Integer i) {
		this.prezzoEconomy=i;
	}

	public void setPrezzoBusiness(Integer i) {
		this.prezzoBusiness=i;
	}

	public void setDurata(Integer i, Integer j) {
		this.durata.setOra(i,j);
	}

	public void inizializzaDataPartenza() {
		this.dataPartenza=new Data();
	}

	public void inizializzaDataArrivo() {
		this.dataArrivo=new Data();
	}

	public void inizializzaOrarioPartenza() {
		this.orarioPartenza=new Ora();
	}

	public void inizializzaOrarioArrivo() {
		this.orarioArrivo=new Ora();
	}

	public void inizializzaDurata() {
		this.durata=new Ora();
	}

	public String getNumeroVolo() {
		return numeroVolo;
	}

	public Ora getOrarioPartenza() {
		return orarioPartenza;
	}

	public Ora getOrarioArrivo() {
		return orarioArrivo;
	}

	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}

	public String getAeroportoDestinazione() {
		return aeroportoDestinazione;
	}

	public Data getDataPartenza() {
		return dataPartenza;
	}

	public Data getDataArrivo() {
		return dataArrivo;
	}

	public Integer getPostiLiberiEconomy() {
		return postiLiberiEconomy;
	}

	public Integer getPostiLiberiBusiness() {
		return postiLiberiBusiness;
	}

	public Integer getPrezzoEconomy() {
		return prezzoEconomy;
	}

	public Integer getPrezzoBusiness() {
		return prezzoBusiness;
	}

	public Ora getDurata() {
		return durata;
	}
}
