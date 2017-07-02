package prenotazioneItinerario;

import static org.junit.Assert.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.Before;
import org.junit.Test;

public class SistemaCallPrenota1Test {
	Sistema s=new Sistema();
	JTable table = new JTable(0, 0);
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	
	@Before
	public void setUp() {
		model.addColumn("DATI");
 		model.addColumn("PASSEGGERI");
	}

	@SuppressWarnings("static-access")
	@Test
	public void testLoginNonEffettuato() {	
 		
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
		s.setLogged(false);
		
		Integer exp=3;
		assertEquals("login non effettuato",exp,s.callPrenota1(table, model));
	}
	
	@Before
	@SuppressWarnings("static-access")
	public void setUp2() {
		s.setLogged(true);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatException() {	
 		
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
		
		Integer exp=0;
		assertEquals("NumberFormatException età",exp,s.callPrenota1(table, model));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNomeVuoto() {	
 		
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);;
		model.setValueAt("Grieco", 2,1);
		model.setValueAt("26", 3,1);
		
		Integer exp=-1;
		assertEquals("nome vuoto",exp,s.callPrenota1(table, model));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCognomeVuoto() {	
 		
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("26", 3,1);
		
		Integer exp=-1;
		assertEquals("cognome vuoto",exp,s.callPrenota1(table, model));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEtaVuota() {	
 		
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);
		
		Integer exp=-1;
		assertEquals("età vuota",exp,s.callPrenota1(table, model));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumeroBambiniErrato() {	
 		
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("10", 3,1);
		
		Integer exp=1;
		assertEquals("numero bambini errato",exp,s.callPrenota1(table, model));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumeroBambiniCorretto() {	
 		
		model.setRowCount(7);
		model.setValueAt("Passeggero 1", 0,1);
		model.setValueAt("Nome*", 1,0);
		model.setValueAt("Cognome*", 2,0);
		model.setValueAt("Età*", 3,0);
		model.setValueAt("Numero Frequent Flyer", 4,0);
		model.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model.setValueAt("Gabriele", 1,1);
		model.setValueAt("Grieco", 2,1);		
		model.setValueAt("18", 3,1);
		
		Integer exp=2;
		assertEquals("numero bambini corretto",exp,s.callPrenota1(table, model));
	}
}