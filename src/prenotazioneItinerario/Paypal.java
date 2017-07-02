/*
 * Class Paypal
 * 
 * Version 1.0
 */
package prenotazioneItinerario;

/**
 * E' la classe che contiene i metodi get e
 * set per gestire i dati del account PayPal
 * durante la fase di pagamento.
 * 
 * @author Gabriele Grieco
 */
public class Paypal extends Pagamento{
	private String passwordConto;

	public String getPasswordConto() {
		return passwordConto;
	}

	public void setEmail(String s) {
		this.indirizzoEmail = s;
	}
	
	public String getEmail() {
		return indirizzoEmail;
	}

	public void setPasswordConto(String s) {
		this.passwordConto = s;
	}
}
