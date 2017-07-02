package prenotazioneItinerario;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaScriviRecensioneTest {
	Sistema s=new Sistema();
	Recensione r=new Recensione();
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatException() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setStrvalutazione("a");
		
		Integer exp=-1;
		assertEquals("NumberFormatException",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testTitoloVuoto() {
		r.setTitolo("");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setStrvalutazione("3");
		
		Integer exp=-2;
		assertEquals("titolo vuoto",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAmbitoVuoto() {
		r.setTitolo("Titolo");
		r.setAmbito("");
		r.setTesto("testo");
		r.setStrvalutazione("3");
		
		Integer exp=-2;
		assertEquals("ambito vuoto",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testTestoVuoto() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("");
		r.setStrvalutazione("3");
		
		Integer exp=-2;
		assertEquals("testo vuoto",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testValutazioneMinore0() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setStrvalutazione("-1");
		
		Integer exp=-2;
		assertEquals("valutazione < 0",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testValutazioneMaggiore5() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setStrvalutazione("6");
		
		Integer exp=-2;
		assertEquals("valutazione > 5",exp,s.scriviRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testOk() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setStrvalutazione("5");
		
		Integer exp=5;
		assertEquals("dati ok",exp,s.scriviRecensione(r));
	}
}
