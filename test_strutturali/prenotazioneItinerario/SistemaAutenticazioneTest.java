package prenotazioneItinerario;

import static org.junit.Assert.*;
import org.junit.Test;

public class SistemaAutenticazioneTest {
	Sistema s=new Sistema();
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameVuoto() {
		String usr="";
		String pwd="Pass@word";
		
		assertFalse("username vuoto",s.autenticazione(usr, pwd));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPasswordVuota() {
		String usr="gabry91";
		String pwd="";
		
		assertFalse("password vuota",s.autenticazione(usr, pwd));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testOk() {
		String usr="gabry91";
		String pwd="Pass@word";
		
		assertTrue("dati corretti",s.autenticazione(usr, pwd));
	}
}
