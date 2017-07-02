package prenotazioneItinerario;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import org.junit.Test;

/*
 * I seguenti test case si riferiscono al caso d'uso UC11 presente nel file di
 * documentazione "srs_p12_grieco_gabriele.odt"; rispetto al caso d'uso descritto
 * in tale documento, sono state operate le semplificazioni di seguito elencate,
 * dovute alla mancata implementazione di alcune funzionalità aggiuntive in questa
 * release del programma:
 * - passi 5 e 27 scenario principale
 * - possibilità di scegliere il posto al passo 11 scenario principale
 * - il pagamento non prevede la possibilità di usare un metodo precedentemente
 *   salvato e di utilizzare una gift card: la procedura di pagamento implementata
 *   in questa versione del programma unifica in una sola operazione la scelta del 
 *   tipo di pagamento e l'inserimento dei relativi dati
 * - scenari alternativi 8a, 21a, 26a
 */
public class UC11PrenotareUnViaggioTest {
	Sistema s=new Sistema();
	Volo v=new Volo();
	RicercaVoli r=new RicercaVoli();
	Prenotazione p=new Prenotazione();
	CartaDiCredito c=new CartaDiCredito();
	ArrayList<ArrayList<Volo>> andrit=new ArrayList<ArrayList<Volo>>();
	ArrayList<Volo> voli;	
	Integer it=0;
	JTable table = new JTable(0, 0);
	DefaultTableModel model = (DefaultTableModel) table.getModel();
		
	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws IOException {		
		model.addColumn("DATI");
 		model.addColumn("PASSEGGERI");
		
		s.table2 = new JTable(0, 0);
		s.model2 = (DefaultTableModel) s.table2.getModel(); 
		s.model2.addColumn("N° Volo");
		s.model2.addColumn("Partenza");
		s.model2.addColumn("Destinazione");
		s.model2.addColumn("Data Partenza");
		s.model2.addColumn("Durata");
		s.model2.addColumn("Orario Partenza");
		s.model2.addColumn("Orario Arrivo");
		s.model2.addColumn("Prezzo Economy");
		s.model2.addColumn("Prezzo Business");
		
		BufferedReader b=new BufferedReader(new FileReader("src/prenotazioneItinerario/"
														 + "VoliOriginal.txt"));
		FileWriter w= new FileWriter("src/prenotazioneItinerario/Voli.txt");			
	    PrintWriter out = new PrintWriter(w);
	    String l=b.readLine();
	    
	    while(l!=null){
	    	out.println(l);
	    	l=b.readLine();
	    }
	    b.close();
	    out.close();
	}
	
	/*
	 * Il test seguente considera lo scenario principale nel quale
	 * la procedura completa di prenotazione avviene con successo
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioPrincipale() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("JOHANNESBURG");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("GENOVA");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("dati ok e posti disponibili",exp,s.dettagliVoli(andrit, r, it));
		
		s.setLogged(true);
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("26", 3,1);
		
		exp=2;
		assertEquals("dati passeggeri ok",exp,s.callPrenota1(table, model));
		
		p.setStrstiva("2");
		p.setStrspeciali("0");
		p.setRichieste("pasto a base di pesce");
		
		exp=1;
		assertEquals("dati bagagli e richieste ok",exp,s.callPrenota2(p));
	
		String assicurazione="Full-Covered";		
		assertTrue("assicurazione scelta correttamente",s.callPrenota3(assicurazione));
	
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("07/17");
		c.setStrcodice("987");
		s.setCarta(true);
		
		exp=3;
		assertEquals("dati carta di credito ok",exp,s.callPrenota4(c));
		
		assertTrue("prenotazione salvata correttamente",s.salvaPrenotazione(s.table2, table,
					s.model2, model));
	}
	
	/*
	 * Il seguente test considera lo scenario alternativo 3a che riguarda il
	 * caso nel quale non ci sono posti liberi sufficienti per tutti i passegeri
	 * per l'opzione di viaggio desiderata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo3a() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("ROMA");	
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("ROMA");
		r.setDataPartenza(15, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=-1;
		assertEquals("non ci sono posti per i voli desiderati",exp,
					 s.dettagliVoli(andrit, r, it));
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 5a che considera il
	 * caso nel quale non sia ancora stato effettuato il login, e quindi
	 * non è proseguire con la procedura di prenotazione
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo5a() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("JOHANNESBURG");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("GENOVA");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("dati ok e posti disponibili",exp,s.dettagliVoli(andrit, r, it));
		
		s.setLogged(false);
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("26", 3,1);
		
		exp=3;
		assertEquals("login non effettuato",exp,s.callPrenota1(table, model));
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11a che considera il
	 * caso nel quale siano presenti errori di compilazione nei dati personali 
	 * dei passeggeri
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11a() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("JOHANNESBURG");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("GENOVA");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("dati ok e posti disponibili",exp,s.dettagliVoli(andrit, r, it));
		
		s.setLogged(true);
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("", 3,1);
		
		exp=0;
		assertEquals("errore compilazione dati",exp,s.callPrenota1(table, model));
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 15a che considera il
	 * caso nel quale siano presenti errori di compilazione nei dati riguardanti
	 * la quantità di bagagli che si desidera trasportare
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo15a() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("JOHANNESBURG");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("GENOVA");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("dati ok e posti disponibili",exp,s.dettagliVoli(andrit, r, it));
		
		s.setLogged(true);
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("26", 3,1);
		
		exp=2;
		assertEquals("dati passeggeri ok",exp,s.callPrenota1(table, model));
		
		p.setStrstiva("3");
		p.setStrspeciali("1");
		p.setRichieste("pasto a base di pesce");
		
		exp=0;
		assertEquals("errore numero bagagli",exp,s.callPrenota2(p));
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 25a che considera il
	 * caso nel quale siano presenti errori di compilazione nei dati relativi
	 * al tipo di pagamento selezionato
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo25a() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("JOHANNESBURG");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("GENOVA");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("dati ok e posti disponibili",exp,s.dettagliVoli(andrit, r, it));
		
		s.setLogged(true);
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("26", 3,1);
		
		exp=2;
		assertEquals("dati passeggeri ok",exp,s.callPrenota1(table, model));
		
		p.setStrstiva("2");
		p.setStrspeciali("0");
		p.setRichieste("pasto a base di pesce");
		
		exp=1;
		assertEquals("dati bagagli e richieste ok",exp,s.callPrenota2(p));
	
		String assicurazione="Full-Covered";		
		assertTrue("assicurazione scelta correttamente",s.callPrenota3(assicurazione));
	
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("07/16");
		c.setStrcodice("123");
		s.setCarta(true);
		
		exp=2;
		assertEquals("errore dati di pagamento",exp,s.callPrenota4(c));
	}
}
