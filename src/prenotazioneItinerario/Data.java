/*
 * Class Data
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe che contiene i metodi necessari
 * per gestire le date al interno di tutto il
 * programma.
 * 
 * @author Gabriele Grieco
 */
public class Data {
	private Integer giorno, mese, anno;
	
	public void setData(Integer i,Integer j,Integer k) {
		this.giorno=i;
		this.mese=j;
		this.anno=k;		
	}
	
	public void setGiorno(Integer i) {
		this.giorno=i;
	}
	
	public void setMese(Integer i) {
		this.mese=i;
	}
	
	public void setAnno(Integer i) {
		this.anno=i;
	}
	
	public Integer getGiorno() {
		return giorno;
	}
	
	public Integer getMese() {
		return mese;
	}
	
	public Integer getAnno() {
		return anno;
	}
}
