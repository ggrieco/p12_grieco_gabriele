package prenotazioneItinerario;

import static org.junit.Assert.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SistemaSalvaPrenotazioneTest {
	Sistema s=new Sistema();
	JTable table2, table3;
	DefaultTableModel model2, model3;
	
	@Before
	public void setUp() {
		table2 = new JTable(0, 0);
		model2 = (DefaultTableModel) table2.getModel();
		
		table3 = new JTable(0, 0);
		model3 = (DefaultTableModel) table3.getModel();
			
		model2.addColumn("N° Volo");
		model2.addColumn("Partenza");
		model2.addColumn("Destinazione");
		model2.addColumn("Data Partenza");
		model2.addColumn("Durata");
		model2.addColumn("Orario Partenza");
		model2.addColumn("Orario Arrivo");
		model2.addColumn("Prezzo Economy");
		model2.addColumn("Prezzo Business");
		
		model3.addColumn("DATI");
 		model3.addColumn("PASSEGGERI");
 		
		model3.setRowCount(7);
		model3.setValueAt("Passeggero 1", 0,1);
		model3.setValueAt("Nome*", 1,0);
		model3.setValueAt("Cognome*", 2,0);
		model3.setValueAt("Età*", 3,0);
		model3.setValueAt("Numero Frequent Flyer", 4,0);
		model3.setValueAt("PRENOTA - (Confermo veridicità dei dati)", 6,1);
		model3.setValueAt("Gabriele", 1,1);
		model3.setValueAt("Grieco", 2,1);
		model3.setValueAt("26", 3,1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOExceptionFileInput() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1317",0,0);
		model2.setValueAt("GENOVA",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("1h 35min",0,4);
		model2.setValueAt("10:50",0,5);
		model2.setValueAt("12:25",0,6);
		model2.setValueAt("70",0,7);
		model2.setValueAt("130",0,8);
		
		s.setInd4("");
		assertFalse("IOException file Voli.txt",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd4("src/prenotazioneItinerario/Voli.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOExceptionFileOutput() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1317",0,0);
		model2.setValueAt("GENOVA",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("1h 35min",0,4);
		model2.setValueAt("10:50",0,5);
		model2.setValueAt("12:25",0,6);
		model2.setValueAt("70",0,7);
		model2.setValueAt("130",0,8);
		
		s.setInd2("asd/qwe");
		assertFalse("IOException file Prenotazioni.txt",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown2() {
		s.setInd2("src/prenotazioneItinerario/Prenotazioni.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrenotazioneEconomy() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1317",0,0);
		model2.setValueAt("GENOVA",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("1h 35min",0,4);
		model2.setValueAt("10:50",0,5);
		model2.setValueAt("12:25",0,6);
		model2.setValueAt("70",0,7);
		model2.setValueAt("130",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Economy");
		
		assertTrue("prenotazione ok in economy",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrenotazioneBusiness() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1317",0,0);
		model2.setValueAt("GENOVA",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("1h 35min",0,4);
		model2.setValueAt("10:50",0,5);
		model2.setValueAt("12:25",0,6);
		model2.setValueAt("70",0,7);
		model2.setValueAt("130",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Business");
		
		assertTrue("prenotazione ok in business",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDurataOreMinore9MinutiMinore9() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1521",0,0);
		model2.setValueAt("PARIGI",0,1);
		model2.setValueAt("NIZZA",0,2);
		model2.setValueAt("11/11/2017",0,3);
		model2.setValueAt("2h 0min",0,4);
		model2.setValueAt("07:00",0,5);
		model2.setValueAt("09:00",0,6);
		model2.setValueAt("50",0,7);
		model2.setValueAt("100",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Business");
		
		assertTrue("ore < 9 minuti < 9",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDurataOreMinore9MinutiMaggiore9() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF1317",0,0);
		model2.setValueAt("GENOVA",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("1h 35min",0,4);
		model2.setValueAt("10:50",0,5);
		model2.setValueAt("12:25",0,6);
		model2.setValueAt("70",0,7);
		model2.setValueAt("130",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Business");
		
		assertTrue("ore < 9 minuti > 9",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}	

	@SuppressWarnings("static-access")
	@Test
	public void testDurataOreMaggiore9MinutiMinore9() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF990",0,0);
		model2.setValueAt("PARIGI",0,1);
		model2.setValueAt("JOHANNESBURG",0,2);
		model2.setValueAt("10/11/2017",0,3);
		model2.setValueAt("10h 0min",0,4);
		model2.setValueAt("13:30",0,5);
		model2.setValueAt("23:30",0,6);
		model2.setValueAt("400",0,7);
		model2.setValueAt("700",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Business");
		
		assertTrue("ore > 9 minuti < 9",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDurataOreMaggiore9MinutiMaggiore9() {
		model2.setRowCount(model2.getRowCount() + 1);
		model2.setValueAt("AF995",0,0);
		model2.setValueAt("JOHANNESBURG",0,1);
		model2.setValueAt("PARIGI",0,2);
		model2.setValueAt("15/11/2017",0,3);
		model2.setValueAt("10h 30min",0,4);
		model2.setValueAt("03:30",0,5);
		model2.setValueAt("14:00",0,6);
		model2.setValueAt("700",0,7);
		model2.setValueAt("1030",0,8);
		
		s.getPrenotazione().setRichieste("");
		s.getPrenotazione().setBagagliStiva(1);
		s.getPrenotazione().setBagagliSpeciali(0);
		s.setAssicurazione("Mini");
		s.setClasse("Business");
		
		assertTrue("ore > 9 minuti > 9",
					s.salvaPrenotazione(table2, table3, model2, model3));
	}	
}