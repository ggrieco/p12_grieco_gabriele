package prenotazioneItinerario;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaCallPrenota3Test {
	Sistema s=new Sistema();
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreValore() {
		String assicurazione="";
		
		assertFalse("errore valore parametro",s.callPrenota3(assicurazione));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFullCovered() {
		String assicurazione="Full-Covered";
		
		assertTrue("Full-Covered",s.callPrenota3(assicurazione));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCompletelySafe() {
		String assicurazione="Completely-Safe";
		
		assertTrue("Completely-Safe",s.callPrenota3(assicurazione));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMini() {
		String assicurazione="Mini";
		
		assertTrue("Mini",s.callPrenota3(assicurazione));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNoAssicurazione() {
		String assicurazione="Nessuna Assicurazione";
		
		assertTrue("Nessuna Assicurazione",s.callPrenota3(assicurazione));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testValoreErrato() {
		String assicurazione="";
		
		assertFalse("errore",s.callPrenota3(assicurazione));
	}
}
