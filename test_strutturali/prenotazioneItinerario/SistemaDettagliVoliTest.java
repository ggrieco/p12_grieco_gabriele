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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SistemaDettagliVoliTest {
	Sistema s=new Sistema();
	
	ArrayList<ArrayList<Volo>> andata=new ArrayList<ArrayList<Volo>>();
	ArrayList<ArrayList<Volo>> andrit=new ArrayList<ArrayList<Volo>>();
	ArrayList<Volo> voli;
	Volo v=new Volo();
	RicercaVoli r=new RicercaVoli();
	Integer it=0;
	
	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws IOException {		
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
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOException() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(10, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		s.setInd4("asd/qwe");
		
		Integer exp=2;
		assertEquals("IOEXception file Voli.txt",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd4("src/prenotazioneItinerario/Voli.txt");
	}
	
	/*
	 * Itinerari di sola andata
	 */
	
	/*
	 * test1 e test2 coprono i casi nei quali gli orari di partenza e di
	 * arrivo abbiano 1 o 2 cifre per le ore e 1 o 2 cifre per i minuti
	 * nel caso sola andata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test1() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(10, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 1",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 2",exp,s.dettagliVoli(andata, r, it));
	}
	
	/*
	 * test3 e test4 coprono i casi nei quali il giorno sia maggiore o
	 * minore di 10 e il mese sia maggiore o minore di 10 nel caso sola
	 * andata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test3() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(9, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 3",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test4() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 9, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 4",exp,s.dettagliVoli(andata, r, it));
	}
	
	/*
	 * test5 e test6 coprono i casi nei quali il volo successivo nell'itinerario
	 * abbia orario di partenza compatibile con l'orario di arrivo del volo precedente,
	 * quindi i due voli possono essere presi lo stesso giorno senza necessità
	 * di cambiare la data
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test5() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();		
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(9, 10, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		System.out.println(andata.get(0).size());
		Integer exp=1;
		assertEquals("test 5",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test6() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		r.setDataPartenza(10, 9, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 6",exp,s.dettagliVoli(andata, r, it));
	}
	/*
	 * i test da test7 a test20 coprono i casi nei quali è necessario
	 * l'aumento di un giorno della data, quando durante un'itinerario
	 * il volo precedente ha orario di arrivo non compatibile con l'orario
	 * di partenza del volo successivo nello stesso giorno, nel caso sola
	 * andata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test7() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 1, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 7",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test8() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 3, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 8",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test9() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 5, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 9",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test10() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 7, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 10",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test11() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 8, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 11",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test12() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 10, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 12",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test13() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 12, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 13",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test14() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 4, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 14",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test15() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(30, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 15",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test16() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(31, 12, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 16",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test17() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(31, 5, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 17",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test18() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(31, 10, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 18",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test19() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(4, 5, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 19",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test20() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);		
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(4, 10, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 20",exp,s.dettagliVoli(andata, r, it));
	}
	
	/*
	 * Itinerari di andata e ritorno
	 */
	
	/*
	 *test21 e test 22 coprono i casi nei quali gli orari
	 *di partenza e di arrivo abbiano 1 o 2 cifre per l'ora
	 *e 1 o 2 cifre per i minuti nel caso di andata e ritorno
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test21() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("NIZZA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);		
		andrit.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 21",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test22() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
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
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 11, 2017);
		r.setDataRitorno(15, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 22",exp,s.dettagliVoli(andrit, r, it));
	}
	
	/*
	 * test23, test24 e test 25 coprono i casi nei quali la data del ritorno sia
	 * nel formato a 1 o 2 cifre per il giorno e 1 o 2 cifre per il mese
	 * nel caso andata eritorno
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test23() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
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
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(29, 11, 2017);
		r.setDataRitorno(1, 12, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 23",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test24() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
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
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 1, 2017);
		r.setDataRitorno(12, 1, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 24",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test25() {
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
		assertEquals("test 25",exp,s.dettagliVoli(andrit, r, it));
	}
	
	/*
	 * i test da test26 a test41 coprono i casi nei quali è necessario
	 * l'aumento di un giorno della data, quando durante un'itinerario di ritorno
	 * il volo precedente ha orario di arrivo non compatibile con l'orario
	 * di partenza del volo successivo nello stesso giorno, nel caso di
	 * andata e ritorno
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test26() {
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
		r.setDataPartenza(27, 1, 2017);
		r.setDataRitorno(30, 1, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 26",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test27() {
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
		r.setDataPartenza(27, 3, 2017);
		r.setDataRitorno(30, 3, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 27",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test28() {
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
		r.setDataPartenza(27, 5, 2017);
		r.setDataRitorno(30, 5, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 28",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test29() {
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
		r.setDataPartenza(27, 7, 2017);
		r.setDataRitorno(30, 7, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 29",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test30() {
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
		r.setDataPartenza(27, 8, 2017);
		r.setDataRitorno(30, 8, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 30",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test31() {
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
		r.setDataPartenza(27, 10, 2017);
		r.setDataRitorno(30, 10, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 31",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test32() {
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
		r.setDataPartenza(27, 12, 2017);
		r.setDataRitorno(30, 12, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 32",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test33() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("JOHANNESBURG");
		voli.add(v);		
		andrit.add(voli);
		
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
		r.setDataPartenza(27, 4, 2017);
		r.setDataRitorno(30, 4, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 33",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test34() {
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
		r.setDataPartenza(27, 11, 2017);
		r.setDataRitorno(30, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 34",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test35() {
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
		r.setDataPartenza(27, 12, 2017);
		r.setDataRitorno(31, 12, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 35",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test36() {
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
		r.setDataPartenza(27, 5, 2017);
		r.setDataRitorno(31, 5, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 36",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test37() {
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
		r.setDataPartenza(27, 10, 2017);
		r.setDataRitorno(31, 10, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 37",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test38() {
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
		r.setDataPartenza(10, 5, 2017);
		r.setDataRitorno(12, 5, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 38",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test39() {
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
		r.setDataPartenza(5, 11, 2017);
		r.setDataRitorno(8, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 39",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test40() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("NIZZA");
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
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(5, 11, 2017);
		r.setDataRitorno(8, 11, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 40",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test41() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
		
		v=new Volo();
			
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("NIZZA");
		voli.add(v);
		
		v=new Volo();
		
		v.setAeroportoPartenza("NIZZA");
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
		r.setAeroportoDestinazione("NIZZA");
		r.setDataPartenza(5, 8, 2017);
		r.setDataRitorno(11, 8, 2017);
		r.setSoloAndata(false);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);
		
		Integer exp=1;
		assertEquals("test 41",exp,s.dettagliVoli(andrit, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNoPostiEconomy() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("PARIGI");
		v.setAeroportoDestinazione("ROMA");
		voli.add(v);
				
		andata.add(voli);
		
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
		assertEquals("no posti economy",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNoPostiBusiness() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("ROMA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
				
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(15, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Business");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);		
		
		Integer exp=0;
		assertEquals("no posti business",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testOkPostiEconomy() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
				
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Economy");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);		
		
		Integer exp=1;
		assertEquals("posti disponibili economy",exp,s.dettagliVoli(andata, r, it));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testOkPostiBusiness() {
		voli=new ArrayList<Volo>();
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		voli.add(v);
				
		andata.add(voli);
		
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("PARIGI");
		r.setDataPartenza(10, 11, 2017);
		r.setSoloAndata(true);
		r.setClasseDiViaggio("Business");
		r.setNumeroAdulti(1);
		r.setNumeroBambini(0);		
		
		Integer exp=1;
		assertEquals("posti disponibili business",exp,s.dettagliVoli(andata, r, it));
	}
}
