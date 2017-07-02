package prenotazioneItinerario;

import static org.junit.Assert.*;
import org.junit.Test;

public class SistemaCallPrenota2Test {
	Sistema s=new Sistema();
	Prenotazione p=new Prenotazione();

	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatException() {
		p.setStrstiva("");
		p.setStrspeciali("1");
		p.setRichieste("pasto a base di pesce");
		
		Integer exp=-1;
		assertEquals("NumberFormatException",exp,s.callPrenota2(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreStivaEccesso() {
		p.setStrstiva("3");
		p.setStrspeciali("2");
		p.setRichieste("pasto a base di pesce");
		s.setPrezzo(0.0);
		
		Integer exp=0;
		assertEquals("errore bagagli stiva in eccesso",exp,s.callPrenota2(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreSpecialiEccesso() {
		p.setStrstiva("2");
		p.setStrspeciali("3");
		p.setRichieste("pasto a base di pesce");
		s.setPrezzo(0.0);
		
		Integer exp=0;
		assertEquals("errore bagagli speciali in eccesso",exp,s.callPrenota2(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreStivaDifetto() {
		p.setStrstiva("-1");
		p.setStrspeciali("0");
		p.setRichieste("pasto a base di pesce");
		s.setPrezzo(0.0);
		
		Integer exp=0;
		assertEquals("errore bagagli stiva in difetto",exp,s.callPrenota2(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreSpecialiDifetto() {
		p.setStrstiva("0");
		p.setStrspeciali("-1");
		p.setRichieste("pasto a base di pesce");
		s.setPrezzo(0.0);
		
		Integer exp=0;
		assertEquals("errore bagagli speciali in difetto",exp,s.callPrenota2(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDatiOk() {
		p.setStrstiva("2");
		p.setStrspeciali("0");
		p.setRichieste("pasto a base di pesce");
		s.setPrezzo(0.0);
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.callPrenota2(p));
	}
}
