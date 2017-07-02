/*
 * Class UtenteRegistrato
 * 
 * Version 1.0
 */
package prenotazioneItinerario;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * E' la classe che racchiude le funzioni relative
 * alla realizzazione delle operazioni svolte dall'utente
 * utilizzando il programma.
 * 
 * @author Gabriele Grieco
 */
@SuppressWarnings("unused")
public class UtenteRegistrato {
	private String username, pwd1, pwd2, codiceFrequentFlyer, domicilio, domanda, risposta;
	private Persona anagrafica;

	public void setUsername(String s) {
		this.username=s;	
	}

	public void setPwd1(String s) {
		this.pwd1=s;	
	}

	public void setPwd2(String s) {
		this.pwd2=s;	
	}

	public void setCodiceFrequentFlyer(String s) {
		this.codiceFrequentFlyer=s;	
	}

	public void setDomicilio(String s) {
		this.domicilio=s;	
	}

	public void setDomanda(String s) {
		this.domanda=s;	
	}

	public void setRisposta(String s) {
		this.risposta=s;
		
	}

	public void setAnagrafica(Persona p) {
		this.anagrafica=p;
	}

	public void setAnagraficaEmail(String s) {
		this.anagrafica.setEmail(s);
	}

	public String getUsername() {
		return username;
	}

	public String getPwd1() {
		return pwd1;
	}

	public String getPwd2() {
		return pwd2;
	}

	public String getCodiceFrequentFlyer() {
		return codiceFrequentFlyer;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getDomanda() {
		return domanda;
	}

	public String getRisposta() {
		return risposta;
	}
	
	public String getAnagraficaNome() {
		return this.anagrafica.getNome();
	}

	public String getAnagraficaCognome() {
		return this.anagrafica.getCognome();
	}

	public String getAnagraficaEmail() {
		return this.anagrafica.getEmail();
	}

	public String getAnagraficaSesso() {
		return this.anagrafica.getSesso();	
		
	}

	public String getAnagraficaNazionalita() {
		return this.anagrafica.getNazionalita();
	}

	public Integer getAnagraficaEta() {
		return this.anagrafica.getEta();
	}

	public Integer getAnagraficaGiornoNascita() {
		return this.anagrafica.getGiornoNascita();
	}
	public Integer getAnagraficaMeseNascita() {
		return this.anagrafica.getMeseNascita();
	}

	public Integer getAnagraficaAnnoNascita() {
		return this.anagrafica.getAnnoNascita();
	}		
}
