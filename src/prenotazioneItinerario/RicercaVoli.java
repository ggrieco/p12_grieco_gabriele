/*
 * Class RicercaVoli
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe contenente i metodi necessari
 * alla gestione dei criteri di ricerca dei
 * voli inseriti dall'utente.
 * 
 * @author Gabriele Grieco
 */
public class RicercaVoli {
	private String aeroportoPartenza, aeroportoDestinazione, classeDiViaggio, strggA, strmmA, straaaaA, strggR, strmmR, straaaaR, stradulti, strbambini;
	private Data dataPartenza, dataRitorno;
	private Boolean soloAndata;
	private Integer numeroAdulti, numeroBambini;

	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}
	
	public String getAeroportoDestinazione() {
		return aeroportoDestinazione;
	}
	
	public Data getDataPartenza() {
		return dataPartenza;
	}

	public Data getDataRitorno() {
		return dataRitorno;
	}
	
	public Boolean getSoloAndata() {
		return soloAndata;
	}
	
	public Integer getNumeroAdulti() {
		return numeroAdulti;
	}

	public Integer getNumeroBambini() {
		return numeroBambini;
	}

	public String getClasseDiViaggio() {
		return classeDiViaggio;
	}

	public String getStrggA() {
		return strggA;		
	}
	
	public String getStrmmA() {
		return strmmA;		
	}
	
	public String getStraaaaA() {
		return straaaaA;		
	}
	
	public String getStrggR() {
		return strggR;		
	}
	
	public String getStrmmR() {
		return strmmR;		
	}
	
	public String getStraaaaR() {
		return straaaaR;		
	}
	
	public String getStradulti() {
		return stradulti;		
	}
	
	public String getStrbambini() {
		return strbambini;		
	}
	
	public void setAeroportoPartenza(String aeroportoPartenza) {
		this.aeroportoPartenza = aeroportoPartenza;
	}

	public void setAeroportoDestinazione(String aeroportoDestinazione) {
		this.aeroportoDestinazione = aeroportoDestinazione;
	}

	public void setDataPartenza(Integer i, Integer j, Integer k) {
		this.dataPartenza.setData(i, j, k);
	}
	
	public void setDataRitorno(Integer i, Integer j, Integer k) {
		this.dataRitorno.setData(i, j, k);
	}

	public void setSoloAndata(Boolean soloAndata) {
		this.soloAndata = soloAndata;
	}

	public void setNumeroAdulti(Integer numeroAdulti) {
		this.numeroAdulti = numeroAdulti;
	}

	public void setNumeroBambini(Integer numeroBambini) {
		this.numeroBambini = numeroBambini;
	}
	
	public void setClasseDiViaggio(String classeDiViaggio) {
		this.classeDiViaggio = classeDiViaggio;
	}
	
	public void setStrggR(String s) {
		this.strggR=s;		
	}
	
	public void setStrmmR(String s) {
		this.strmmR=s;		
	}
	
	public void setStraaaaR(String s) {
		this.straaaaR=s;		
	}
	
	public void setStrggA(String s) {
		this.strggA=s;		
	}
	
	public void setStrmmA(String s) {
		this.strmmA=s;		
	}
	
	public void setStraaaaA(String s) {
		this.straaaaA=s;		
	}
	
	public void setStradulti(String s) {
		this.stradulti=s;		
	}
	
	public void setStrbambini(String s) {
		this.strbambini=s;		
	}
	
	public void inizializzaDataPartenza() {
		this.dataPartenza=new Data();
	}

	public void inizializzaDataRitorno() {
		this.dataRitorno=new Data();
	}
}