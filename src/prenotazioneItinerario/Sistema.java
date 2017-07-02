/*
 * Class Sistema
 * 
 * Version 1.0
 */
package prenotazioneItinerario;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * E' la classe che racchiude tutte le funzioni necessarie
 * al sistema principale per gestire le diverse operazioni
 * del programma.
 * 
 * @author Gabriele Grieco
 */
public class Sistema {
	private static UtenteRegistrato utente=new UtenteRegistrato();
	private static Boolean logged=false;
	@SuppressWarnings("unused")
	private static Persona persona=new Persona();
	private static RicercaVoli criteri=new RicercaVoli();
	private static ArrayList<ArrayList<Volo>> itinerari= new ArrayList<ArrayList<Volo>>();
	private static Prenotazione prenotazione=new Prenotazione();
	private static String ind1="src/prenotazioneItinerario/UtentiRegistrati.txt";
	private static String ind2="src/prenotazioneItinerario/Prenotazioni.txt";
	private static String ind3="src/prenotazioneItinerario/Recensioni.txt";
	private static String ind4="src/prenotazioneItinerario/Voli.txt";
	private static String ind5="src/prenotazioneItinerario/tmpVoli.txt";
	private static String ind6="src/prenotazioneItinerario/Connessioni.txt";
	private static String ind7="src/prenotazioneItinerario/tmpUtentiRegistrati.txt";
	private static Integer adulti=1, bambini=0, righe=0, x=100, y=100, z=100;
	private static Double prezzo=0.0;
	private static String user="", classe="", assicurazione="";
	private static Boolean carta=true;
	
	static JTable table2= new JTable(0, 0);
	static DefaultTableModel model2= (DefaultTableModel) table2.getModel();;
	
	/**
	 * E' la funzione che acquisisce i dati anagrafifi durante la registrazione
	 * di un nuovo account. La funzione ha il compito di verificare che i dati
	 * inseriti siano completi e che siano rispettati i formati numerici
	 * dell'età e della data di nascita, la quale deve essere una data valida.
	 * Verifica inoltre che l'utente che si vuole registrare sia maggiorenne.
	 *  
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione 
	 * 			Output della funzione:
	 * 			-1	errore inserimento dati
	 *  		 0	NumberFormatException
	 *  		 1	OK
	 * @param	Persona dati, String domicilio
	 * @exception	NumberFormatException f
	 */
	public static Integer datiAnagrafica(Persona dati, String domicilio) {
		Integer rt=0;
		try {
			dati.inizializzaDataNascita();
			dati.setGiornoNascita(Integer.parseInt(dati.getStrgg()));
			dati.setMeseNascita(Integer.parseInt(dati.getStrmm()));
			dati.setAnnoNascita(Integer.parseInt(dati.getStraaaa()));
			dati.setEta(Integer.parseInt(dati.getStreta()));
			
			if (dati.getNome().equals("")||dati.getCognome().equals("")
					  ||dati.getGiornoNascita()<1
					  ||dati.getGiornoNascita()>31||dati.getMeseNascita()<1
					  ||dati.getMeseNascita()>12||dati.getAnnoNascita()<1917
					  ||dati.getAnnoNascita()>1999||((dati.getMeseNascita()==4
					  ||dati.getMeseNascita()==6||dati.getMeseNascita()==9
					  ||dati.getMeseNascita()==11)&&dati.getGiornoNascita()==31)
					  ||dati.getAnnoNascita()%4!=0
					  &&dati.getMeseNascita()==2&&dati.getGiornoNascita()>28
					  ||dati.getAnnoNascita()%4==0&&dati.getMeseNascita()==2
					  &&dati.getGiornoNascita()>29
					  ||dati.getNazionalita().equals("")||dati.getSesso().equals("")
					  ||dati.getEta()<18||dati.getEta()>100||domicilio.equals("")) {
							  			
				  rt=-1;
			} else {			
				utente.setAnagrafica(dati);
				utente.setDomicilio(domicilio);
				
				rt=1;
			}
		} catch (NumberFormatException f) {			
				rt=0;
				return rt;
		}
		
	return rt;
	}
	
	/**
	 * E' la funzione che acquisisce le credenziali scelte per la
	 * registtrazione di un nuovo account. Verifica che tutti i campi
	 * siano stati compilati correttamente e che siano state
	 * rispettate le specifiche per la scelta di username e password.
	 * Inoltre chiama le funzioni che verificano che lo username e
	 * l'indirizzo email scelti non siano già presenti nel sistema.
	 *  
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 * 			-1	errore inserimento dati
	 * 			 0	username già presente nel sistema
	 *  		 1	campi password non coincidenti
	 * 			 2	indirizzo e-mail già utilizzato
	 *		     3	OK
	 *  		 4	IOException
	 * @param	UtenteRegistrato u
	 * @exception IOException 
	 */
	public static Integer registrazioneAccount(UtenteRegistrato u) {
		Integer rt=0;		
		try {
			FileOutputStream pw;			
			pw = new FileOutputStream(ind1,true);
			
			if (u.getUsername().length()<5
					||u.getUsername().length()>10
					||u.getPwd1().length()<8
					||u.getPwd1().length()>12
					||u.getUsername().charAt(0)=='0'
					||u.getUsername().charAt(0)=='1'
					||u.getUsername().charAt(0)=='2'
					||u.getUsername().charAt(0)=='3'
					||u.getUsername().charAt(0)=='4'
					||u.getUsername().charAt(0)=='5'
					||u.getUsername().charAt(0)=='6'
					||u.getUsername().charAt(0)=='7'
					||u.getUsername().charAt(0)=='8'
					||u.getUsername().charAt(0)=='9'
					||u.getUsername().contains(" ")==true
					||u.getUsername().contains("@")==true
					||u.getUsername().contains("/")==true
					||u.getUsername().contains("|")==true
					||u.getUsername().contains("*")==true
					||u.getUsername().contains("?")==true
					||u.getUsername().contains("<")==true
					||u.getUsername().contains(">")==true
					||u.getUsername().contains(":")==true
					||u.getPwd1().contains(" ")==true
					||(u.getPwd1().contains("@")==false
					&&u.getPwd1().contains("/")==false
					&&u.getPwd1().contains("|")==false
					&&u.getPwd1().contains("*")==false
					&&u.getPwd1().contains("?")==false
					&&u.getPwd1().contains("<")==false
					&&u.getPwd1().contains(">")==false
					&&u.getPwd1().contains(":")==false)
					||(u.getPwd1().contains("A")==false
					&&u.getPwd1().contains("B")==false
					&&u.getPwd1().contains("C")==false
					&&u.getPwd1().contains("D")==false
					&&u.getPwd1().contains("E")==false
					&&u.getPwd1().contains("F")==false
					&&u.getPwd1().contains("G")==false
					&&u.getPwd1().contains("H")==false
					&&u.getPwd1().contains("I")==false
					&&u.getPwd1().contains("J")==false
					&&u.getPwd1().contains("K")==false
					&&u.getPwd1().contains("L")==false
					&&u.getPwd1().contains("M")==false
					&&u.getPwd1().contains("N")==false
					&&u.getPwd1().contains("O")==false
					&&u.getPwd1().contains("P")==false
					&&u.getPwd1().contains("Q")==false
					&&u.getPwd1().contains("R")==false
					&&u.getPwd1().contains("S")==false
					&&u.getPwd1().contains("T")==false
					&&u.getPwd1().contains("U")==false
					&&u.getPwd1().contains("V")==false
					&&u.getPwd1().contains("W")==false
					&&u.getPwd1().contains("X")==false
					&&u.getPwd1().contains("Y")==false
					&&u.getPwd1().contains("Z")==false)
					||u.getAnagraficaEmail().contains("@")==false
					||u.getAnagraficaEmail().contains(".")==false
					||u.getAnagraficaEmail().contains(" ")
					||u.getDomanda().equals("")
					||u.getRisposta().equals("")) {			  
				
				rt=-1;
			  } else if (userUnivoco(u.getUsername())==false) {			
				rt=0;
			  } else if (u.getPwd1().equals(u.getPwd2())==false) {			
				rt=1;
			  } else if (emailUnivoca(u.getAnagraficaEmail())==false) {			
				rt=2;
			  } else {
				utente.setAnagraficaEmail(u.getAnagraficaEmail());
				utente.setUsername(u.getUsername());
				utente.setPwd1(u.getPwd1());
				utente.setDomanda(u.getDomanda());
				utente.setRisposta(u.getRisposta());			
				
				
				PrintWriter fos = new PrintWriter(pw);
			
				fos.println(getUtente().getUsername());
				fos.println(getUtente().getPwd1());
				fos.println("0");
				fos.println(getUtente().getAnagraficaEmail());
				fos.println(getUtente().getDomanda());
				fos.println(getUtente().getRisposta());
				fos.println(assegnaFF());
				fos.println(getUtente().getDomicilio());
				fos.println(getUtente().getAnagraficaNome());
				fos.println(getUtente().getAnagraficaCognome());
				fos.println(Integer.toString(getUtente().getAnagraficaGiornoNascita())
							+"/"+Integer.toString (getUtente().getAnagraficaMeseNascita())
							+"/"+Integer.toString (getUtente().getAnagraficaAnnoNascita()));
				fos.println(getUtente().getAnagraficaSesso());
				fos.println(getUtente().getAnagraficaNazionalita());
				fos.println(Integer.toString (getUtente().getAnagraficaEta()));
			
				fos.close();
				
				rt=3;
			  }
		} catch (IOException e) {
			rt=4;
			return rt;
		}
	return rt;
	}
	
	/**
	 * E' la funzione che acquisisce username e password durante la fase di
	 * autenticazione e verifica che siano stati inseriti correttamente.
	 * 
	 * @return	Boolean 
	 * 			assume il valore true se i campi sono stati
	 * 			compilati correttamente e false altrimenti
	 * @param	String usr, String pwd
	 */
	public  static Boolean autenticazione(String usr, String pwd) {
	    Boolean ok=true;   
		if (usr.equals("")||pwd.equals(""))
			ok=false;
			
		return ok;		
	}
	
	/**
	 * E' la funzione che verifica se le credenziali inserite per
	 * effetture il login corrispondano ad un'utente registrato.
	 * Effettua il controllo leggendo un file di testo contenente
	 * tutti gli utenti registrati, per verificare se lo username
	 * sia presente e di conseguenza se l'account è a posto oppure 
	 * è stato precedentemente bloccato; se lo username viene trovato, 
	 * l'account non è bloccato (tentativi errati < 3)e la password 
	 * inserita è corretta il login viene effettuato con successo, 
	 * mentre se lo username viene trovato ma la password è errata viene
	 * incrementato il numero di tentativi non corretti.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 *		 	-1	username non presente nel sistema
	 * 			 0	account bloccato
	 *  		 1	OK
	 *  		 2	password errata
	 *  		 3	IOException
	 * @param	String usr, String pwd
	 * @exception	IOException e
	 */
	public  static Integer login(String usr, String pwd) {
			Integer rt=0;
			try {
			Boolean find=false;
		    user=usr;
		    FileWriter w= new FileWriter(ind7);			
		    PrintWriter out = new PrintWriter(w);
		    
			BufferedReader reader = new BufferedReader(new FileReader(ind1));
			Integer count1=14;
		    String tmppwd=null;
			String line = reader.readLine();
			out.println(line);
			
		    while (line!=null) {
		    	
		        if (count1==14) {	
		        	
		        	if (line.equals(usr)) {
		        		find=true;
		        		line = reader.readLine();
		        		out.println(line);
		        		tmppwd=line;
		        		line = reader.readLine();	            		
		        		
		        			if (line.equals("3")) {
		        				rt=0;		        				
		        				out.println(line);
		        			} else if (tmppwd.equals(pwd)) {           			            					            				
		        				rt=1;
		        				logged=true;
		        				out.println("0");      					            					
		        			} else {
		        				rt=2;		        				
		        				
		        				switch (line) {
		        				case "0":
		        					out.println("1");
		        					break;
		        					
		        				case "1":
		        					out.println("2");
		        					break;
		        					
		        				case "2":
		        					out.println("3");
		        					rt=0;           					
		        					break;
		        				}	            					            			
		        			}
		        	} else {/*username non corrisponde*/
		        			line = reader.readLine();
		        			out.println(line);
		    	            count1=1;	            			
		        	}
		        } else {/*count non è 14*/
		        	line = reader.readLine();
		        	
		        	if (line!=null)
		        		out.println(line);
		        	
		        	count1+=1;
		        }
		   }
		    out.close();
			reader.close();			
			File file1 = new File(ind7);
			File file2 = new File(ind1);
			file1.renameTo(file2);
			
			if (find==false) {				
				rt=-1;
			}
		} catch (IOException e) {
			rt=3;
			return rt;
		}
	return rt;
}
	
	/**
	 * E' la funzione che prende come parametro i criteri di ricerca
	 * dei voli inseriti dall'utente e, dopo aver controllato che i 
	 * campi relativi ai parametri di ricerca siano stati compilati
	 * correttamente con dati validi (per esempio le date devono essere
	 * in formato numerico e realmente esistenti),verifica che
	 * le località di partenza e destinazione siano raggiunte dai voli
	 * gestiti dalla piattaforma prorpietaria del programma.
	 * Se le località sono raggiunte entrambe viene letto il
	 * file contenente tutte le possibili connessioni, e vengono
	 * generati tutti i possibili itinerari tra le due località
	 * inserite; in caso di volo andata e ritorno viene generaato
	 * anche il percorso inverso tra le due località, per fornire
	 * gli itinerari possibili per il ritorno.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione 
	 * 			Output della funzione:
	 * 			-1	errore inserimento dati
	 *  		 0	località partenza non riconosciuta
	 *  		 1	località destinazione non riconosciuta
	 *  		 2	NumberFormatException
	 *  		 3	OK
	 *  		 4	IOException
	 * @param	RicercaVoli c
	 * @exception	IOException e, NumberFormatException f
	 */
	public static Integer ricercaItinerario(RicercaVoli c) {		
	  Integer rt=0;
	  try {			
		c.setDataPartenza(Integer.parseInt(c.getStrggA()), 
						  Integer.parseInt(c.getStrmmA()),
						  Integer.parseInt(c.getStraaaaA()));
		c.setNumeroAdulti(Integer.parseInt(c.getStradulti()));
		c.setNumeroBambini(Integer.parseInt(c.getStrbambini()));
			
		if (c.getSoloAndata()==false) {
			c.setDataRitorno(Integer.parseInt(c.getStrggR()), 
					  Integer.parseInt(c.getStrmmR()),
					  Integer.parseInt(c.getStraaaaR()));
		}		
		
		if (c.getAeroportoPartenza().equals("")
	  			||c.getAeroportoDestinazione().equals("")
	  			||c.getAeroportoDestinazione().equals(c.getAeroportoPartenza())
	  			||c.getNumeroAdulti()<0||c.getNumeroBambini()<0
	  			||(c.getNumeroAdulti()==0&c.getNumeroBambini()==0)
	  			||c.getDataPartenza().getGiorno()<1
	  			||c.getDataPartenza().getGiorno()>31||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getGiorno()<1)||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getGiorno()>31)||c.getDataPartenza().getMese()<1
	  			||c.getDataPartenza().getMese()>12||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getMese()<1)||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getMese()>12)||c.getDataPartenza().getAnno()<2017
	  			||c.getDataPartenza().getAnno()>2020||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getAnno()<2017)||(c.getSoloAndata()==false
	  			&&c.getDataRitorno().getAnno()>2020)||((c.getDataPartenza().getMese()==4
	  			||c.getDataPartenza().getMese()==6||c.getDataPartenza().getMese()==9
	  			||c.getDataPartenza().getMese()==11)&&c.getDataPartenza().getGiorno()==31)
	  			||(c.getSoloAndata()==false&&(c.getDataRitorno().getMese()==4
	  			||c.getDataRitorno().getMese()==6
	  			||c.getDataRitorno().getMese()==9||c.getDataRitorno().getMese()==11)
	  			&&c.getDataRitorno().getGiorno()==31)
	  			||(c.getDataPartenza().getAnno()%4!=0&&c.getDataPartenza().getMese()==2
	  			&&c.getDataPartenza().getGiorno()>28)||(c.getDataPartenza().getAnno()%4==0
	  			&&c.getDataPartenza().getMese()==2&&c.getDataPartenza().getGiorno()>29)
	  			||(c.getSoloAndata()==false&&c.getDataRitorno().getAnno()%4!=0
	  			&&c.getDataRitorno().getMese()==2&&c.getDataRitorno().getGiorno()>28)
	  			||c.getSoloAndata()==false&&c.getDataRitorno().getAnno()%4==0
	  			&&c.getDataRitorno().getMese()==2&&c.getDataRitorno().getGiorno()>29		
	  			||c.getSoloAndata()==false&&c.getDataRitorno().getAnno()<c.getDataPartenza().getAnno()			
	  			||c.getSoloAndata()==false&&(c.getDataPartenza().getAnno()-c.getDataRitorno().getAnno())==0
	  			&&(c.getDataRitorno().getMese()-c.getDataPartenza().getMese())<0
	  			||c.getSoloAndata()==false&&(c.getDataRitorno().getAnno()-c.getDataPartenza().getAnno())==0
	  			&&(c.getDataRitorno().getMese()-c.getDataPartenza().getMese())==0
	  			&&(c.getDataRitorno().getGiorno()-c.getDataPartenza().getGiorno())<0) {	  		
			
			rt=-1;
	  	} else {	  			
			if (c.getSoloAndata()==true) {			
					BufferedReader reader = new BufferedReader(new FileReader(ind6));
					String line=reader.readLine();
					String word;
					Integer i=1;
					
					ArrayList<Integer> from = new ArrayList<Integer>();
					ArrayList<Integer> to = new ArrayList<Integer>();
					
					while (line!=null) {				
						StringTokenizer st = new StringTokenizer(line, ",");
						
						while (st.hasMoreTokens()) {
							word=st.nextToken();
							
							if (word.equals(c.getAeroportoPartenza())) {
								from.add(i);
							}
							if (word.equals(c.getAeroportoDestinazione())) {
								to.add(i);
							}
						}				
						i+=1;
						line=reader.readLine();
					}
					
					if (from.size()==0) {					
						rt=0;
					} else if (to.size()==0) {						
						rt=1;
					} else {/*trovo entrambe gli aeroporti*/
						itinerari = new ArrayList<ArrayList<Volo>>();
						Volo tmpvolo=new Volo();
						Integer k=-1;
						
						tmpvolo.inizializzaOrarioPartenza();
						tmpvolo.inizializzaOrarioArrivo();
						tmpvolo.inizializzaDataPartenza();
						tmpvolo.inizializzaDataArrivo();
						
						for (Integer f=0;f<from.size();f++) {
							for (Integer t=0;t<to.size();t++) {
								ArrayList<Volo> voli = new ArrayList<Volo>();
								
								  	switch (from.get(f)) {
									case 1:										
										if (c.getAeroportoPartenza().equals("ROMA")==false) {
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
											voli.get(k).setAeroportoDestinazione("ROMA");
										}
										
										switch (to.get(t)) {
										case 1:
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("PARIGI");

											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										}
										break;
									case 2:
										if (c.getAeroportoPartenza().equals("MONACO")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
										voli.get(k).setAeroportoDestinazione("MONACO");
										}
										
										switch (to.get(t)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 2:
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("PARIGI");
											
											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											} 
											break;
										}
										break;
									case 3:
										if (c.getAeroportoPartenza().equals("PARIGI")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
										voli.get(k).setAeroportoDestinazione("PARIGI");
										}
										
										switch (to.get(t)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											} 
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										}
										break;
									}
									itinerari.add(voli);
									rt=3;
									k=-1;																								    		    
							}
						}
						reader.close();
					}
				} else {/*andata e ritorno*/
					BufferedReader reader = new BufferedReader(new FileReader(ind6));
					String line=reader.readLine();
					String word;
					Integer i=1;
					
					ArrayList<Integer> from = new ArrayList<Integer>();
					ArrayList<Integer> to = new ArrayList<Integer>();
					
					while (line!=null) {				
						StringTokenizer st = new StringTokenizer(line, ",");
						
						while (st.hasMoreTokens()) {
							word=st.nextToken();
							
							if (word.equals(c.getAeroportoPartenza())) {
								from.add(i);
							}
							if (word.equals(c.getAeroportoDestinazione())) {
								to.add(i);
							}
						}				
						i+=1;
						line=reader.readLine();
					}
					
					if (from.size()==0) {
						rt=0; 	
					} else if (to.size()==0) {
						rt=1;
					} else {/*trovo entrambe gli aeroporti*/
				
						itinerari = new ArrayList<ArrayList<Volo>>();
						Volo tmpvolo=new Volo();
						Integer k=-1;
						
						tmpvolo.inizializzaOrarioPartenza();
						tmpvolo.inizializzaOrarioArrivo();
						tmpvolo.inizializzaDataPartenza();
						tmpvolo.inizializzaDataArrivo();
						
						for (Integer f=0;f<from.size();f++) {
							for (Integer t=0;t<to.size();t++) {
								ArrayList<Volo> voli = new ArrayList<Volo>();
								
									switch (from.get(f)) {
									case 1:										
										if (c.getAeroportoPartenza().equals("ROMA")==false) {
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
											voli.get(k).setAeroportoDestinazione("ROMA");
										} 
										
										switch (to.get(t)) {
										case 1:
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("PARIGI");

											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										}
										break;
									case 2:
										if (c.getAeroportoPartenza().equals("MONACO")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
										voli.get(k).setAeroportoDestinazione("MONACO");
										}
										
										switch (to.get(t)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 2:
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("PARIGI");
											
											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										}
										break;
									case 3:
										if (c.getAeroportoPartenza().equals("PARIGI")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoPartenza());
										voli.get(k).setAeroportoDestinazione("PARIGI");
										}
										
										switch (to.get(t)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoDestinazione().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoDestinazione().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										case 3:
											if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoDestinazione());
											}
											break;
										}
										break;
									}
									itinerari.add(voli);									
									k=-1;																						    		    
							}
						}
						reader.close();
						k=-1;

						for (Integer t=0;t<to.size();t++) {
							for (Integer f=0;f<from.size();f++) {						
								ArrayList<Volo> voli = new ArrayList<Volo>();
								
									switch (to.get(t)) {
									case 1:										
										if (c.getAeroportoDestinazione().equals("ROMA")==false) {
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza(c.getAeroportoDestinazione());
											voli.get(k).setAeroportoDestinazione("ROMA");
										}
										
										switch (from.get(f)) {
										case 1:
											if (c.getAeroportoPartenza().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoPartenza().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("ROMA");
											voli.get(k).setAeroportoDestinazione("PARIGI");

											if (c.getAeroportoPartenza().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										}
										break;
									case 2:
										if (c.getAeroportoDestinazione().equals("MONACO")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoDestinazione());
										voli.get(k).setAeroportoDestinazione("MONACO");
										}
										
										switch (from.get(f)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoPartenza().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 2:
											if (c.getAeroportoPartenza().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 3:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("MONACO");
											voli.get(k).setAeroportoDestinazione("PARIGI");
											
											if (c.getAeroportoPartenza().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										}
										break;
									case 3:
										if (c.getAeroportoDestinazione().equals("PARIGI")==false) {
										voli.add(new Volo());
										k+=1;
										voli.get(k).setAeroportoPartenza(c.getAeroportoDestinazione());
										voli.get(k).setAeroportoDestinazione("PARIGI");
										}
										
										switch (from.get(f)) {
										case 1:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("ROMA");
											
											if (c.getAeroportoPartenza().equals("ROMA")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("ROMA");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 2:
											voli.add(new Volo());
											k+=1;
											voli.get(k).setAeroportoPartenza("PARIGI");
											voli.get(k).setAeroportoDestinazione("MONACO");
											
											if (c.getAeroportoPartenza().equals("MONACO")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("MONACO");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										case 3:
											if (c.getAeroportoPartenza().equals("PARIGI")==false) {
												voli.add(new Volo());
												k+=1;
												voli.get(k).setAeroportoPartenza("PARIGI");
												voli.get(k).setAeroportoDestinazione(c.getAeroportoPartenza());
											}
											break;
										}
										break;
									}
									itinerari.get(f).addAll(voli);
									rt=3;
									k=-1;																								    		    
							}
						}
						setCriteri(c);						
					}
				}
	  		}  
 
		} catch (NumberFormatException f) {			
			rt=2;
		}  catch (IOException e) {
			rt=4;
		}
		return rt;
	}
	
	/**
	 * E' la funzione che fornisce i dettagli dell'itinerario di viaggio
	 * selezionato. Effettua inoltre il controllo dell'effettiva disponibilità 
	 * della quantità di posti necessari per la prenotazione e controlla il
	 * formato delle date, affinchè siano tutte espresse come GG/MM/AAAA e
	 * degli orari affinchè siano nel formato HH:MM. Inoltre verifica che gli
	 * orari dei voli in coincidenza siano compatibili, altrimenti se lo
	 * non fosse possibile lo stesso giorno, aumenta la data di un giorno ed
	 * effettua la ricerca sul volo corrispondente (sono gestiti tutti i casi
	 * nei quali i cambiamenti di data comportino il cambio di mese o di anno).
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 *			 -1	no posti liberi in economy
	 * 			  0	no posti liberi in business
	 * 			  1	OK
	 * 			  2	IOException
	 * @param 	ArrayList<ArrayList<Volo>> v,RicercaVoli r, Integer it
	 * 			it consente di apprendere quale itinerario è stato selezionato
	 * @exception	IOException e
	 */
	public static Integer dettagliVoli(ArrayList<ArrayList<Volo>> v,RicercaVoli r, 
									   Integer it) {
		Integer rt=1;
		try {
			  prezzo=0.0;
    		  Volo tmpvolo=new Volo();  		  	            			            		  
    		  tmpvolo.inizializzaOrarioPartenza();
    		  tmpvolo.inizializzaOrarioArrivo();
    		  tmpvolo.inizializzaDurata();	
    		  tmpvolo.inizializzaDataPartenza();
    		  tmpvolo.inizializzaDataArrivo();
    		  
    		  @SuppressWarnings("unused")
    		  Ora tmpora =new Ora();
    		  Data tmpdata=new Data();
    		  Boolean[] ins;
    		  ins=new Boolean[v.get(it).size()];
    	
    		for (Integer j=0;j<v.get(it).size();j++) {
    			BufferedReader reader= new BufferedReader(new FileReader(ind4));
				
    			String line=reader.readLine();
    			ins[j]=false;
    			
    			while (line!=null) {	            				
    				
    				for (Integer i=1;i<13;i++) {
    					
    					switch (i) {
    					case 1:
    						tmpvolo.setNumeroVolo(line);
    						break;
    					case 2:
    						line = reader.readLine();
    						tmpvolo.setOrarioPartenza(Integer.parseInt(line.substring(0,2)),
    								Integer.parseInt(line.substring(2,4)));
    						break;
    					case 3:
    						line = reader.readLine();
    						tmpvolo.setOrarioArrivo(Integer.parseInt(line.substring(0,2)),
    								Integer.parseInt(line.substring(2,4)));
    						break;
    					case 4:
    						line = reader.readLine();
    						tmpvolo.setAeroportoPartenza(line);
    						break;
    					case 5:
    						line = reader.readLine();
    						tmpvolo.setAeroportoDestinazione(line);
    						break;
    					case 6:
    						line = reader.readLine();
    						tmpvolo.setDataPartenza(Integer.parseInt(line.substring(0, 2)), 
    								Integer.parseInt(line.substring(3,5)),
    								Integer.parseInt(line.substring(6,10)));
    						break;
    					case 7:
    						line = reader.readLine();
    						tmpvolo.setDataArrivo(Integer.parseInt(line.substring(0, 2)),
    								Integer.parseInt(line.substring(3,5)),
    								Integer.parseInt(line.substring(6,10)));
    						break;
    					case 8:
    						line = reader.readLine();
    						tmpvolo.setPostiLiberiEconomy(Integer.parseInt(line));
    						break;
    					case 9:
    						line = reader.readLine();
    						tmpvolo.setPostiLiberiBusiness(Integer.parseInt(line));
    						break;
    					case 10:
    						line = reader.readLine();
    						tmpvolo.setPrezzoEconomy(Integer.parseInt(line));
    						break;
    					case 11:
    						line = reader.readLine();
    						tmpvolo.setPrezzoBusiness(Integer.parseInt(line));
    						break;
    					case 12:
    						line = reader.readLine();
    						tmpvolo.setDurata(Integer.parseInt(line.substring(0,2)),
    								Integer.parseInt(line.substring(2,4)));
    						break;
    					}
    					
    				}/*leggo tutto un volo*/
    				
    			if (r.getSoloAndata()==true||(r.getSoloAndata()==false&&j<(v.get(it).size()/2))) {
    				if (tmpvolo.getAeroportoPartenza().equals
    						(v.get(it).get(j).getAeroportoPartenza())
    						&&tmpvolo.getAeroportoDestinazione().equals
    						(v.get(it).get(j).getAeroportoDestinazione())&&ins[j]==false) {
    					
    					ins[j]=true;
    			    	model2.setRowCount(model2.getRowCount() + 1);
    			    	model2.setValueAt(tmpvolo.getNumeroVolo(), 
    			    					  model2.getRowCount() - 1, 0);
    			    	model2.setValueAt(tmpvolo.getAeroportoPartenza(), 
    			    					  model2.getRowCount() - 1, 1);
    			    	model2.setValueAt(tmpvolo.getAeroportoDestinazione(), 
    			    					  model2.getRowCount() - 1, 2);
    			    	model2.setValueAt(tmpvolo.getDurata().gethh()+"h "+
    			    					  tmpvolo.getDurata().getmm()+"min", 
    			    					  model2.getRowCount() - 1, 4);
    			    	
    			    	if (tmpvolo.getOrarioPartenza().gethh()>=0
    			    		&&tmpvolo.getOrarioPartenza().gethh()<=9) {
    			    	model2.setValueAt("0"+tmpvolo.getOrarioPartenza().gethh()+
    			    					  ":",model2.getRowCount() - 1, 5);
    			    	} else {
    			    		model2.setValueAt(tmpvolo.getOrarioPartenza().gethh()+
    			    						  ":",model2.getRowCount() - 1, 5);
    			    	}
    			    	if (tmpvolo.getOrarioPartenza().getmm()>=0
    			    		&&tmpvolo.getOrarioPartenza().getmm()<=9) {
        			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 5)+
        			    					  "0"+tmpvolo.getOrarioPartenza().getmm(),
        			    					  model2.getRowCount() - 1, 5);
        			    } else {
        			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 5)+
        			    					  ""+tmpvolo.getOrarioPartenza().getmm(),
        			    					  model2.getRowCount() - 1, 5);
        			   	}
    			    	if (tmpvolo.getOrarioArrivo().gethh()>=0&&tmpvolo.getOrarioArrivo().gethh()<=9) {
        			    	model2.setValueAt("0"+tmpvolo.getOrarioArrivo().gethh()+
        			    					  ":",model2.getRowCount() - 1, 6);
        			    } else {
        			    	model2.setValueAt(tmpvolo.getOrarioArrivo().gethh()+
        			    					  ":",model2.getRowCount() - 1, 6);
        			    }
        			    if (tmpvolo.getOrarioArrivo().getmm()>=0&&tmpvolo.getOrarioArrivo().getmm()<=9) {
            			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 6)+
            			    					  "0"+tmpvolo.getOrarioArrivo().getmm(),
            			    					  model2.getRowCount() - 1, 6);
            			} else {
            			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 6)+
            			    					  ""+tmpvolo.getOrarioArrivo().getmm(),
            			    					  model2.getRowCount() - 1, 6);
            			}
    			    	model2.setValueAt(tmpvolo.getPrezzoEconomy(), 
    			    			model2.getRowCount() - 1, 7);
    			    	model2.setValueAt(tmpvolo.getPrezzoBusiness(), 
    			    			model2.getRowCount() - 1, 8);
    			    	
    			    	
						if (j==0) {/*primo volo dell'itinerario*/
							if (r.getDataPartenza().getGiorno()>=1&&r.getDataPartenza().getGiorno()<=9) {
								model2.setValueAt("0"+r.getDataPartenza().getGiorno()+"/",
												  model2.getRowCount() - 1, 3);
						} else {
							model2.setValueAt(r.getDataPartenza().getGiorno()+"/",
											  model2.getRowCount() - 1, 3);
						} 
						if (r.getDataPartenza().getMese()>=1&&r.getDataPartenza().getMese()<=9) {
           			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+"0"+
           			    					  r.getDataPartenza().getMese()+"/"+r.getDataPartenza().getAnno(),
           			    					  model2.getRowCount() - 1, 3);
     					} else {
     						model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+""+
     										  r.getDataPartenza().getMese()+"/"+r.getDataPartenza().getAnno(),
     										  model2.getRowCount() - 1, 3);
   						}
    			    	
    			    	tmpora=tmpvolo.getOrarioArrivo();            			    	
						tmpdata=r.getDataPartenza();
						            						
    			    	} else if (tmpvolo.getOrarioPartenza().gethh()>
    			    			   Integer.parseInt(String.valueOf(((String) model2.getValueAt
    			    			   (model2.getRowCount()-2 , 6)).substring(0,2)))) {
			    	            			    	
    			    		if (tmpdata.getGiorno()>=1&&tmpdata.getGiorno()<=9) {
    			    			model2.setValueAt("0"+tmpdata.getGiorno()+"/",
        			    					  model2.getRowCount() - 1, 3);
    			    		} else {
    			    			model2.setValueAt(tmpdata.getGiorno()+"/",
    										  model2.getRowCount() - 1, 3);
    			    		}
    			    			if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
    			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+"0"+
	           			    					  tmpdata.getMese()+"/"+tmpdata.getAnno(),
	           			    					  model2.getRowCount() - 1, 3);
    			    			} else {
    			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+""+
        	           			    			  tmpdata.getMese()+"/"+tmpdata.getAnno(),
        	           			    			  model2.getRowCount() - 1, 3);
    			    			}            			    	
    			    	
    			    	tmpora=tmpvolo.getOrarioArrivo();
    					
    			    	} else {/*orario partenza volo successivo precedente all'arrivo 
    			    			 *del successivo, quindi la dataPartenza+1
    			    			 */
    			    		switch (tmpdata.getGiorno()) {
    			    		case 30:
    			    			if (tmpdata.getMese()==1||tmpdata.getMese()==3
    			    				||tmpdata.getMese()==5||tmpdata.getMese()==7
    			    				||tmpdata.getMese()==8||tmpdata.getMese()==10
    			    				||tmpdata.getMese()==12) {
    			    			
    			    				if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
    			    					model2.setValueAt(31+"/"+"0"+
    			    									  tmpdata.getMese()+"/"+tmpdata.getAnno(), 
    			    									  model2.getRowCount() - 1, 3);
    			    				} else {
    			    					model2.setValueAt(31+"/"+
    			    									  tmpdata.getMese()+"/"+tmpdata.getAnno(), 
    			    									  model2.getRowCount() - 1, 3);
    			    				}
    	            			tmpora=tmpvolo.getOrarioArrivo();
    	            			tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
    		            							  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
    	            								  Integer.parseInt(String.valueOf(model2.getValueAt
    	            								  (model2.getRowCount() - 1, 3)).substring(3,5)),
    	            								  Integer.parseInt(String.valueOf(model2.getValueAt(
    	            								  model2.getRowCount() - 1, 3)).substring(6,10)));
    	            			tmpdata=tmpvolo.getDataArrivo();
    			    			} else if ((tmpdata.getMese()+1)>=1&&(tmpdata.getMese()+1)<=9) {	            			    				
    			    				model2.setValueAt("01/"+"0"+
    			    								  ((tmpdata.getMese()+1)+"/"+tmpdata.getAnno()), 
    			    								  model2.getRowCount() - 1, 3);
    			    				} else {
    			    				model2.setValueAt("01/"+
    			    								  ((tmpdata.getMese()+1)+"/"+tmpdata.getAnno()), 
    			    								  model2.getRowCount() - 1, 3);
    			    				}
	            	            tmpora=tmpvolo.getOrarioArrivo();     	        						
	            	            tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
	            	            					  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt
	            	            					  (model2.getRowCount() - 1, 3)).substring(3,5)),
	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt(
	            	            					  model2.getRowCount() - 1, 3)).substring(6,10)));
	            	            tmpdata=tmpvolo.getDataArrivo();
    			    			break;
    			    		case 31:
    			    			if (tmpdata.getMese()==12) {
    			    				model2.setValueAt("01/01/"+(tmpdata.getAnno()+1), 
	            	            					  model2.getRowCount() - 1, 3);
	            	            	tmpora=tmpvolo.getOrarioArrivo();
	            	           		tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
	            		            					  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
	            	           							  Integer.parseInt(String.valueOf(model2.getValueAt
	            	           							  (model2.getRowCount() - 1, 3)).substring(3,5)),
	            	           							  Integer.parseInt(String.valueOf(model2.getValueAt(
	            	           							  model2.getRowCount() - 1, 3)).substring(6,10)));
	            	            	tmpdata=tmpvolo.getDataArrivo();
    			    			} else if ((tmpdata.getMese()+1)>=1&&(tmpdata.getMese()+1)<=9) {	            			    				
    			    				model2.setValueAt("01/"+"0"+(tmpdata.getMese()+1)+"/"+
    			    								  tmpdata.getAnno(),model2.getRowCount() - 1, 3);
    			    			  } else {
    			    				model2.setValueAt("01/"+(tmpdata.getMese()+1)+"/"+
    			    								  tmpdata.getAnno(),model2.getRowCount() - 1, 3);
    			    				}
	            	            tmpora=tmpvolo.getOrarioArrivo();
	            	            tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
	            	            					  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt
	            	            					  (model2.getRowCount() - 1, 3)).substring(3,5)),
	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt(
	            	            					  model2.getRowCount() - 1, 3)).substring(6,10)));
	            	            tmpdata=tmpvolo.getDataArrivo();
    			    			break;
    			    		default:
    			    			if ((tmpdata.getGiorno()+1)>=1&&(tmpdata.getGiorno()+1)<=9) {
    			    				model2.setValueAt("0"+(tmpdata.getGiorno()+1)+"/", 
    			    								  model2.getRowCount() - 1, 3);
    			    			} else {
    			    				model2.setValueAt((tmpdata.getGiorno()+1)+"/", 
    			    								  model2.getRowCount() - 1, 3);
    			    			}
    			    			
    			    			if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
    			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+
    			    								  "0"+tmpdata.getMese()+"/"+tmpdata.getAnno(), 
    			    								  model2.getRowCount() - 1, 3);
    			    			} else {
    			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+
    			    								  ""+tmpdata.getMese()+"/"+tmpdata.getAnno(), 
    			    								  model2.getRowCount() - 1, 3);
    			    			}
    	            			tmpora=tmpvolo.getOrarioArrivo();
    	            			tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
    		            							  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
    	            								  Integer.parseInt(String.valueOf(model2.getValueAt
    	            								  (model2.getRowCount() - 1, 3)).substring(3,5)),
    	            								  Integer.parseInt(String.valueOf(model2.getValueAt(
    	            								  model2.getRowCount() - 1, 3)).substring(6,10)));
    	            			tmpdata=tmpvolo.getDataArrivo();
    	            			break;	            			    			
    			    		}           			    				            			    	 
    			    	}
    				}    	
    			} else {/*ritorno*/
    				
    				if (tmpvolo.getAeroportoPartenza().equals(v.get(it).get(j).getAeroportoPartenza())
    				   &&tmpvolo.getAeroportoDestinazione().equals(v.get(it).get(j).getAeroportoDestinazione())
    				   &&ins[j]==false)	{
        					
        					ins[j]=true;
        			    	model2.setRowCount(model2.getRowCount() + 1);
        			    	model2.setValueAt(tmpvolo.getNumeroVolo(), 
        			    					  model2.getRowCount() - 1, 0);
        			    	model2.setValueAt(tmpvolo.getAeroportoPartenza(), 
        			    					  model2.getRowCount() - 1, 1);
        			    	model2.setValueAt(tmpvolo.getAeroportoDestinazione(), 
        			    					  model2.getRowCount() - 1, 2);
        			    	model2.setValueAt(tmpvolo.getDurata().gethh()+"h "+
        			    					  tmpvolo.getDurata().getmm()+"min", 
        			    					  model2.getRowCount() - 1, 4);
        			    	if (tmpvolo.getOrarioPartenza().gethh()>=0&&tmpvolo.getOrarioPartenza().gethh()<=9) {
        			    	model2.setValueAt("0"+tmpvolo.getOrarioPartenza().gethh()+
        			    					  ":",model2.getRowCount() - 1, 5);
        			    	} else {
        			    		model2.setValueAt(tmpvolo.getOrarioPartenza().gethh()+
        			    						  ":",model2.getRowCount() - 1, 5);
        			    	}
        			    	if (tmpvolo.getOrarioPartenza().getmm()>=0&&tmpvolo.getOrarioPartenza().getmm()<=9) {
            			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 5)+
            			    					  "0"+tmpvolo.getOrarioPartenza().getmm(),
            			    					  model2.getRowCount() - 1, 5);
            			    } else {
            			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 5)+
            			    					  ""+tmpvolo.getOrarioPartenza().getmm(),
            			    					  model2.getRowCount() - 1, 5);
            			   	}
        			    	if (tmpvolo.getOrarioArrivo().gethh()>=0&&tmpvolo.getOrarioArrivo().gethh()<=9) {
            			    	model2.setValueAt("0"+tmpvolo.getOrarioArrivo().gethh()+
            			    					  ":",model2.getRowCount() - 1, 6);
            			    } else {
            			    	model2.setValueAt(tmpvolo.getOrarioArrivo().gethh()+
	            			    				  ":",model2.getRowCount() - 1, 6);
            			    }
            			    if (tmpvolo.getOrarioArrivo().getmm()>=0&&tmpvolo.getOrarioArrivo().getmm()<=9) {
	            			    model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 6)
	            			    				  +"0"+tmpvolo.getOrarioArrivo().getmm(),
	            			    				  model2.getRowCount() - 1, 6);
	            			} else {
	            			    model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 6)
	            			    				  +""+tmpvolo.getOrarioArrivo().getmm(),
	            			    				  model2.getRowCount() - 1, 6);
	            			   	}
        			    	model2.setValueAt(tmpvolo.getPrezzoEconomy(), 
        			    					  model2.getRowCount() - 1, 7);
        			    	model2.setValueAt(tmpvolo.getPrezzoBusiness(), 
        			    					  model2.getRowCount() - 1, 8);
        			    	
        			    	
    						if (j==v.get(it).size()/2) {/*primo volo del ritorno*/
    							if (r.getDataRitorno().getGiorno()>=1&&r.getDataRitorno().getGiorno()<=9) {
    								model2.setValueAt("0"+r.getDataRitorno().getGiorno()+"/",
    												  model2.getRowCount() - 1, 3);
    						} else {
    							model2.setValueAt(r.getDataRitorno().getGiorno()+"/",
    											  model2.getRowCount() - 1, 3);
    						}
    						if (r.getDataRitorno().getMese()>=1&&r.getDataRitorno().getMese()<=9) {
	           			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+"0"
	           			    					  +r.getDataRitorno().getMese()+"/"+r.getDataRitorno().getAnno(),
	           			    					  model2.getRowCount() - 1, 3);
         					} else {
         						model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+""
         										  +r.getDataRitorno().getMese()+"/"+r.getDataRitorno().getAnno(),
         										  model2.getRowCount() - 1, 3);
       							}        			    	
        			    	tmpora=tmpvolo.getOrarioArrivo();            			    	
    						tmpdata=r.getDataRitorno();
    						            						
        			    	} else if (tmpvolo.getOrarioPartenza().gethh()>
        			    			   Integer.parseInt(String.valueOf(((String) model2.getValueAt
        			    			   (model2.getRowCount()-2 , 6)).substring(0,2)))) {
    			    	            			    	
        			    	if (tmpdata.getGiorno()>=1&&tmpdata.getGiorno()<=9) {
            			    	model2.setValueAt("0"+tmpdata.getGiorno()+"/",
            			    					  model2.getRowCount() - 1, 3);
        					} else {
        						model2.setValueAt(tmpdata.getGiorno()+"/",
        										  model2.getRowCount() - 1, 3);
        					}
        					if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
    	           			    	model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+"0"+
    	           			    					  tmpdata.getMese()+"/"+tmpdata.getAnno(),
    	           			    					  model2.getRowCount() - 1, 3);
             				} else {
             						model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)+""+
	        	           			    			  tmpdata.getMese()+"/"+tmpdata.getAnno(),
	        	           			    			  model2.getRowCount() - 1, 3);
           					}            			    	
        			    	
        			    	tmpora=tmpvolo.getOrarioArrivo();
        					
        			    	} else {/*aumentare la data di un giorno*/
        			    		 switch (tmpdata.getGiorno()) {
        			    		 case 30:
        			    			if (tmpdata.getMese()==1||tmpdata.getMese()==3
        			    			   	||tmpdata.getMese()==5||tmpdata.getMese()==7
        			    			   	||tmpdata.getMese()==8||tmpdata.getMese()==10
        			    			   	||tmpdata.getMese()==12) {
        			    			
        			    				if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
        			    					model2.setValueAt(31+"/"+"0"
        			    									  +tmpdata.getMese()+"/"+tmpdata.getAnno(), 
        			    									  model2.getRowCount() - 1, 3);
        			    				} else {
        			    					model2.setValueAt(31+"/"
        			    									  +tmpdata.getMese()+"/"+tmpdata.getAnno(), 
        			    									  model2.getRowCount() - 1, 3);
        			    				}
        	            			tmpora=tmpvolo.getOrarioArrivo();
        	            			tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
        		            							  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
        	            								  Integer.parseInt(String.valueOf(model2.getValueAt
        	            								  (model2.getRowCount() - 1, 3)).substring(3,5)),
        	            								  Integer.parseInt(String.valueOf(model2.getValueAt(
        	            								  model2.getRowCount() - 1, 3)).substring(6,10)));
        	            			tmpdata=tmpvolo.getDataArrivo();
        			    			} else if ((tmpdata.getMese()+1)>=1&&(tmpdata.getMese()+1)<=9) {		            			    				
        			    					model2.setValueAt("01/"+"0"+
        			    									  ((tmpdata.getMese()+1)+"/"+tmpdata.getAnno()), 
        			    									  model2.getRowCount() - 1, 3);
        			    				} else {
        			    					model2.setValueAt("01/"+
        			    									  ((tmpdata.getMese()+1)+"/"+tmpdata.getAnno()), 
        			    									  model2.getRowCount() - 1, 3);
        			    				}
    	            	            tmpora=tmpvolo.getOrarioArrivo();     	        						
    	            	            tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
    	            	            					  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt
    	            	            					  (model2.getRowCount() - 1, 3)).substring(3,5)),
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt(
    	            	            					  model2.getRowCount() - 1, 3)).substring(6,10)));
    	            	            tmpdata=tmpvolo.getDataArrivo();		            			    			
        			    			break;
        			    		case 31:
        			    			if (tmpdata.getMese()==12) {
        			    				model2.setValueAt("01/01/"+(tmpdata.getAnno()+1), 
    	            	            					  model2.getRowCount() - 1, 3);
    	            	            					  tmpora=tmpvolo.getOrarioArrivo();
    	            	            					  tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
    	            		            				  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt
    	            	            					  (model2.getRowCount() - 1, 3)).substring(3,5)),
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt(
    	            	            					  model2.getRowCount() - 1, 3)).substring(6,10)));
    	            	            	tmpdata=tmpvolo.getDataArrivo();
        			    			} else if ((tmpdata.getMese()+1)>=1&&(tmpdata.getMese()+1)<=9) {		            			    				
        			    				model2.setValueAt("01/"+"0"+(tmpdata.getMese()+1)+"/"+
        			    								  tmpdata.getAnno(),model2.getRowCount() - 1, 3);
        			    			} else {
        			    				model2.setValueAt("01/"+(tmpdata.getMese()+1)+"/"
        			    								  +tmpdata.getAnno(),model2.getRowCount() - 1, 3);
        			    			}
    	            	            tmpora=tmpvolo.getOrarioArrivo();
    	            	            tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
    	            	            					  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt
    	            	            					  (model2.getRowCount() - 1, 3)).substring(3,5)),
    	            	            					  Integer.parseInt(String.valueOf(model2.getValueAt(
    	            	            					  model2.getRowCount() - 1, 3)).substring(6,10)));
    	            	            tmpdata=tmpvolo.getDataArrivo();		            			    			
        			    			break;
        			    		default:
        			    			if ((tmpdata.getGiorno()+1)>=1&&(tmpdata.getGiorno()+1)<=9) {
        			    				model2.setValueAt("0"+(tmpdata.getGiorno()+1)+"/", 
        			    								  model2.getRowCount() - 1, 3);
        			    			} else {
        			    				model2.setValueAt((tmpdata.getGiorno()+1)+"/", 
        			    								  model2.getRowCount() - 1, 3);
        			    			}
        			    			
        			    			if (tmpdata.getMese()>=1&&tmpdata.getMese()<=9) {
        			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)
        			    								  +"0"+tmpdata.getMese()+"/"+tmpdata.getAnno(), 
        			    								  model2.getRowCount() - 1, 3);
        			    			} else {
        			    				model2.setValueAt(model2.getValueAt(model2.getRowCount() - 1, 3)
        			    								  +""+tmpdata.getMese()+"/"+tmpdata.getAnno(), 
        			    								  model2.getRowCount() - 1, 3);
        			    			}
        	            			tmpora=tmpvolo.getOrarioArrivo();
        	            			tmpvolo.setDataArrivo(Integer.parseInt(String.valueOf
        		            							  (model2.getValueAt(model2.getRowCount() - 1, 3)).substring(0, 2)), 
        	            								  Integer.parseInt(String.valueOf(model2.getValueAt
        	            								  (model2.getRowCount() - 1, 3)).substring(3,5)),
        	            								  Integer.parseInt(String.valueOf(model2.getValueAt(
        	            								  model2.getRowCount() - 1, 3)).substring(6,10)));
        	            			tmpdata=tmpvolo.getDataArrivo();
        	            			break;	            			    			
        			    		}           			    				            			    	 
        			    	}
        				}
    				}
    				line=reader.readLine();	            					
    			}
    			reader.close();
    		}
    		
		  Volo tmpvolo2=new Volo();
		  tmpvolo2.inizializzaOrarioPartenza();
		  tmpvolo2.inizializzaOrarioArrivo();
		  tmpvolo2.inizializzaDurata();	
		  tmpvolo2.inizializzaDataPartenza();
		  tmpvolo2.inizializzaDataArrivo();
    	
    	for (Integer z=0;z<model2.getRowCount();z++) {
    		tmpvolo2.setAeroportoPartenza(String.valueOf(model2.getValueAt(z, 1)));
    		tmpvolo2.setAeroportoDestinazione(String.valueOf(model2.getValueAt(z, 2)));
    		tmpvolo2.setDataPartenza(Integer.parseInt(String.valueOf
    								 (model2.getValueAt(z,3)).substring(0, 2)), 
									 Integer.parseInt(String.valueOf(model2.getValueAt(z,3)).substring(3,5)),
									 Integer.parseInt(String.valueOf(model2.getValueAt(z,3)).substring(6,10)));
    		
    		BufferedReader reader = new BufferedReader(new FileReader(ind4));
			String line=reader.readLine();
			
			while (line!=null) {	            				
				
				for (Integer i=1;i<13;i++) {
					
					switch (i) {
					case 1:
						tmpvolo.setNumeroVolo(line);
						break;
					case 2:
						line = reader.readLine();
						tmpvolo.setOrarioPartenza(Integer.parseInt(line.substring(0,2)),
								Integer.parseInt(line.substring(2,4)));
						break;
					case 3:
						line = reader.readLine();
						tmpvolo.setOrarioArrivo(Integer.parseInt(line.substring(0,2)),
								Integer.parseInt(line.substring(2,4)));
						break;
					case 4:
						line = reader.readLine();
						tmpvolo.setAeroportoPartenza(line);
						break;
					case 5:
						line = reader.readLine();
						tmpvolo.setAeroportoDestinazione(line);
						break;
					case 6:
						line = reader.readLine();
						tmpvolo.setDataPartenza(Integer.parseInt(line.substring(0, 2)), 
								Integer.parseInt(line.substring(3,5)),
								Integer.parseInt(line.substring(6,10)));
						break;
					case 7:
						line = reader.readLine();
						tmpvolo.setDataArrivo(Integer.parseInt(line.substring(0, 2)),
								Integer.parseInt(line.substring(3,5)),
								Integer.parseInt(line.substring(6,10)));
						break;
					case 8:
						line = reader.readLine();
						tmpvolo.setPostiLiberiEconomy(Integer.parseInt(line));
						break;
					case 9:
						line = reader.readLine();
						tmpvolo.setPostiLiberiBusiness(Integer.parseInt(line));
						break;
					case 10:
						line = reader.readLine();
						tmpvolo.setPrezzoEconomy(Integer.parseInt(line));
						break;
					case 11:
						line = reader.readLine();
						tmpvolo.setPrezzoBusiness(Integer.parseInt(line));
						break;
					case 12:
						line = reader.readLine();
						tmpvolo.setDurata(Integer.parseInt(line.substring(0,2)),
								Integer.parseInt(line.substring(2,4)));
						break;
					}
					
				}/*leggo tutto un volo*/            				
				
				if (tmpvolo.getAeroportoPartenza().equals(tmpvolo2.getAeroportoPartenza())
					&&tmpvolo.getAeroportoDestinazione().equals
					(tmpvolo2.getAeroportoDestinazione())&&tmpvolo.getDataPartenza().getGiorno()==
					tmpvolo2.getDataPartenza().getGiorno()&&tmpvolo.getDataPartenza().getMese()==
					tmpvolo2.getDataPartenza().getMese()) {            					
					
						  if (r.getClasseDiViaggio().equals("Economy")) {
							  if (tmpvolo.getPostiLiberiEconomy()<r.getNumeroAdulti()+r.getNumeroBambini()) {
								  rt=-1;
							  } else {
								  prezzo+=((r.getNumeroAdulti()*tmpvolo.getPrezzoEconomy())+(r.getNumeroBambini()*
										   tmpvolo.getPrezzoEconomy()-(((r.getNumeroBambini()*
										   tmpvolo.getPrezzoEconomy()*20)/100)))); 
							  }
						  } else if (tmpvolo.getPostiLiberiBusiness()<r.getNumeroAdulti()+r.getNumeroBambini()) {           							             								  
							  rt=0;								  
							  } else {
								  prezzo+=((r.getNumeroAdulti()*tmpvolo.getPrezzoBusiness())+(r.getNumeroBambini()*
										  	tmpvolo.getPrezzoBusiness()-(((r.getNumeroBambini()*
										  	tmpvolo.getPrezzoBusiness()*20)/100))));
							  }            						        					              					             					            					
						}
						line=reader.readLine();
					}
					reader.close();            			
    			}
    			
    			adulti=r.getNumeroAdulti();
    			bambini=r.getNumeroBambini();
    			classe=r.getClasseDiViaggio();	
		} catch (IOException e) {
			rt=2;
			return rt;
		}
		return rt;
	}
	
	/**
	 * E' la funzione che verifica la correttezza della compilazione dei campi
	 * relativi ai dati dei passeggeri. Verifica inoltre che l'età sia espressa
	 * come valore numerico e che il conto di passeggeri adulti e bambini
	 * coincida conquanto indicato nei parametri di ricerca.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 *		 	-1	errore inserimento dati
	 *  		 0	NumberFormatException
	 *  		 1	errore numero passeggeri sotto i 10 anni
	 *  		 2	OK
	 *  		 3	login non effettuato
	 * @param	JTable t, DefaultTableModel m
	 * @exception	NumberFormatException f
	 */
	public static Integer callPrenota1(JTable t, DefaultTableModel m) {
		Boolean ok=true;
		Integer rt=2;
 		
		if (logged==false) {
			rt=3;
		} else {
			for (Integer i=0;i<m.getRowCount();i++) {
	 			if ((m.getValueAt(i,0)=="Nome*"
	 					&&m.getValueAt(i,1)==null)
	 					||(m.getValueAt(i,0)=="Cognome*"&&(m.getValueAt(i,1)==null)
	 					||(m.getValueAt(i,0)=="Età*"&&m.getValueAt(i,1)==null))) {
	 				ok=false;				 				
	 			}
	 		}
	 		if (ok==true) {
	 			try{
	 				Integer countbambini=0;
	 				for (Integer j=0;j<m.getRowCount();j++) {
	 					if (m.getValueAt(j,0)=="Età*") {
	 						
	 							if ((Integer.parseInt(String.valueOf(m.getValueAt(j,1))))<=10) {
	 								countbambini+=1;
	 							}			 										 						
	 					}
	 				}
	 				if (countbambini!=bambini) { 					
	 					rt=1;
	 				}
	 			} catch (NumberFormatException f) {				
						rt=0;
				 		return rt;
	 			}
	 		} else { 			
	 			rt=-1;
	 			
	 		}
		}		
 		return rt;
	}
	
	/**
	 * E' la funzione che acquisisce il numero di bagagli da acquistare ed
	 * eventuali richieste speciali. Verifica che il formato delle quantità
	 * dei bagagli sia numerico e che il totale dei bagagli non sia superiore
	 * a due per passeggero (2 in stiva + 2 speciali a testa) e aggiorna il
	 * prezzo totale della prenotazione.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 * 			-1	NumberFormatException
	 *  		 0	errore quantità bagagli da acquistare
	 *  		 1 OK
	 * @param	Prenotazione p
	 * @exception	NumberFormatException f
	 */
	public static Integer callPrenota2(Prenotazione p) { 
		Integer rt=1;
 		try{
 			prenotazione.setBagagliStiva(Integer.parseInt(p.getStrstiva()));
 			prenotazione.setBagagliSpeciali(Integer.parseInt(p.getStrspeciali()));
 			prenotazione.setRichieste(p.getRichieste());

 			if (prenotazione.getBagagliStiva()<=(2*(adulti+bambini))
 				&&prenotazione.getBagagliSpeciali()<=(2*(adulti+bambini))
 				&&prenotazione.getBagagliStiva()>=0
 				&&prenotazione.getBagagliSpeciali()>=0) {
 			
 				prezzo+=((prenotazione.getBagagliStiva()*25)+(prenotazione.getBagagliSpeciali()*100));
 				rt=1;
 			} else {
 				rt=0;
 			}
 		} catch (NumberFormatException f) {					
				rt=-1;
 		}			 		
 	return rt;
	}
	
	/**
	 * E' la funzione che prende come parametro di input il tipo di
	 * assicurazione selezionata per il viaggio, e aggiorna di conseguenza
	 * il prezzo totale da pagare.
	 * 
	 * @return	Boolean che assume valore true se il tipo di assicurazione viene
	 * 			viene memorizzato correttamente e false altrimenti
	 * @param	String s che indica il tipo di assicurazione scelto
	 */
	public static Boolean callPrenota3(String s) {
		Boolean ok=false;
		switch (s) {
		case "Full-Covered":
			addPrezzo(40.0);
			assicurazione="Full-Covered";
			ok=true;
			break;
		case "Completely-Safe":
			addPrezzo(30.0);
			assicurazione="Completely-Safe";
			ok=true;
			break;
		case "Mini":
			addPrezzo(20.0);
			assicurazione="Mini";
			ok=true;
			break;
		case "Nessuna Assicurazione":
			assicurazione="Nessuna Assicurazione";
			ok=true;
			break;
		default:
			ok=false;
			break;
		}
		return ok;
	}
	
	/**
	 * E' la funzione che acquisisce i dati di pagamento, sia nel caso di
	 * pagamento con carta di credito, sia nel caso di pagamento con account
	 * PayPal. Verifica che tutti i campi siano stati compilati correttamente
	 * e che siano rispettati i formati numerici di numero, data di scadenza
	 * e codice di sicurezza della carta di credito. Inoltre verifica che la
	 * data di scadenza della carta di credito sia una data valida.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 *		 	-1	errore inserimento dati carta di credito
	 * 			 0	NumberFormatException
	 *  		 1	errore inserimento dati PayPal
	 *  		 2	errore inserimento data scadenza carta di credito
	 *  		 3	OK
	 * @param	Object o
	 * @exception	NumberFormatException f
	 */
	public static Integer callPrenota4(Object o) {
		Integer rt=3;
		if (carta==true) {/*carta di credito*/				 			
			 			
			 			if (((CartaDiCredito) o).getNomeIntestatario().equals("")
			 					||((CartaDiCredito) o).getCognomeIntestatario().equals("")
			 					||((CartaDiCredito) o).getStrnumero().equals("")
			 					||((CartaDiCredito) o).getScadenza().equals("")
			 					||((CartaDiCredito) o).getStrcodice().equals("")
			 					||((CartaDiCredito) o).getScadenza().length()!=5
			 					||String.valueOf(((CartaDiCredito) o).getScadenza().charAt(2)).equals("/")==false
			 					||((CartaDiCredito) o).getStrnumero().length()<14
			 					||((CartaDiCredito) o).getStrnumero().length()>16
			 					||((CartaDiCredito) o).getStrcodice().length()!=3) {			
			 				
			 			rt=-1;
			 			} else {
			 			
			 				try{
			 					/*
			 					 * Le variabili di seguito dichiarate non verranno mai utilizzate successivamente:
			 					 * il loro compito è quello di verificare se il numero della carta di credito,
			 					 * mese e anno di scadenza della carta di credito e codice di sicurezza della
			 					 * carta di credito siano stati correttamente indicati in formato numerico.
			 					 * Qualora non fossero in formato numerico, mediante il catch viene gestita
			 					 * l'eccezione ritornando il valore opportuno a comprendere il caso nel quale si
			 					 * trova il programma
			 					 * */
			 					@SuppressWarnings("unused")
								Integer num1=Integer.parseInt(((CartaDiCredito) o).getStrnumero().substring(0, 5));
			 					@SuppressWarnings("unused")
								Integer num2=Integer.parseInt(((CartaDiCredito) o).getStrnumero().substring(5, 10));
			 					@SuppressWarnings("unused")
								Integer num3=Integer.parseInt(((CartaDiCredito) o).getStrnumero().substring(10));
			 					Integer m=Integer.parseInt(((CartaDiCredito) o).getScadenza().substring(0, 2));
			 					Integer a=Integer.parseInt(((CartaDiCredito) o).getScadenza().substring(3, 5));
			 					@SuppressWarnings("unused")
								Integer c=Integer.parseInt(((CartaDiCredito) o).getStrcodice());

			 					if (m<1||m>12||a<17||(a==17&&m<7)) {			 						
			 					rt=2;
			 					}
			 				
			 				} catch (NumberFormatException f) {
			 					rt=0;
			 					return rt;
			 		}
			 		return rt;
			 	}
			 } else {
				 
				 if (((Paypal) o).getEmail().equals("")
							||((Paypal) o).getPasswordConto().equals("")
							||((Paypal) o).getEmail().contains("@")==false
							||((Paypal) o).getEmail().contains(".")==false) {			
						
						rt=1;		  
		  		}
			 }
		  	return rt;
	}
	
	/**
	 * E' la funzione che salva tutti i dati di una prenotazione correttamente
	 * effettuata, scrivendoli nell'apposito file di testo, che svolge il
	 * ruollo di database. Si occupa anche di aggiornare il numero dei posti
	 * disponibili residui nelle diverse classi, sui voli interessati dalla 
	 * prenotazione.
	 * 
	 * @return	Boolean che assume il valore true se il salvataggio va a
	 * 			buon fine e false altrimenti
	 * @param	JTable table2, JTable table3, DefaultTableModel model2,
	 * 			DefaultTableModel model3, Prenotazione p
	 * 			table2 contiene i dati dei voli mentre table 3 i dati dei 
	 * 			passeggeri
	 * @exception	IOException e
	 */
	public static Boolean salvaPrenotazione(JTable table2, JTable table3, 
										 DefaultTableModel model2, DefaultTableModel model3) {		
		try {
			Volo tmpvolo=new Volo();
			tmpvolo.inizializzaOrarioPartenza();
			tmpvolo.inizializzaOrarioArrivo();
			tmpvolo.inizializzaDurata();
			tmpvolo.inizializzaDataPartenza();
			tmpvolo.inizializzaDataArrivo();
		
			Volo tmpvolo2=new Volo();
			tmpvolo2.inizializzaOrarioPartenza();
			tmpvolo2.inizializzaOrarioArrivo();
			tmpvolo2.inizializzaDurata();	
			tmpvolo2.inizializzaDataPartenza();
			tmpvolo2.inizializzaDataArrivo();
			
			FileWriter v= new FileWriter(ind2,true);
			PrintWriter out2 = new PrintWriter(v);
		
			for (Integer z=0;z<model2.getRowCount();z++) {
				tmpvolo2.setAeroportoPartenza(String.valueOf(model2.getValueAt(z, 1)));
				tmpvolo2.setAeroportoDestinazione(String.valueOf(model2.getValueAt(z, 2)));
				tmpvolo2.setDataPartenza(Integer.parseInt(String.valueOf
				(model2.getValueAt(z,3)).substring(0, 2)), 
				Integer.parseInt(String.valueOf(model2.getValueAt(z,3)).substring(3,5)),
				Integer.parseInt(String.valueOf(model2.getValueAt(z,3)).substring(6,10)));
		
			FileWriter w= new FileWriter(ind5);
		    PrintWriter out = new PrintWriter(w);
			BufferedReader reader = new BufferedReader(new FileReader(ind4));
			String line=reader.readLine();
			
				while (line!=null&&line.equals("")==false) {	            				
				
					for (Integer i=1;i<13;i++) {
					
							switch (i) {
							case 1:
								tmpvolo.setNumeroVolo(line);
								break;
							case 2:
								line = reader.readLine();
								tmpvolo.setOrarioPartenza(Integer.parseInt(line.substring(0,2)),
										Integer.parseInt(line.substring(2,4)));
								break;
							case 3:
								line = reader.readLine();
								tmpvolo.setOrarioArrivo(Integer.parseInt(line.substring(0,2)),
										Integer.parseInt(line.substring(2,4)));
								break;
							case 4:
								line = reader.readLine();
								tmpvolo.setAeroportoPartenza(line);
								break;
							case 5:
								line = reader.readLine();
								tmpvolo.setAeroportoDestinazione(line);
								break;
							case 6:
								line = reader.readLine();
								tmpvolo.setDataPartenza(Integer.parseInt(line.substring(0, 2)), 
										Integer.parseInt(line.substring(3,5)),
										Integer.parseInt(line.substring(6,10)));
								break;
							case 7:
								line = reader.readLine();
								tmpvolo.setDataArrivo(Integer.parseInt(line.substring(0, 2)),
								Integer.parseInt(line.substring(3,5)),
								Integer.parseInt(line.substring(6,10)));
								break;
							case 8:
								line = reader.readLine();
								tmpvolo.setPostiLiberiEconomy(Integer.parseInt(line));
								break;
							case 9:
								line = reader.readLine();
								tmpvolo.setPostiLiberiBusiness(Integer.parseInt(line));
								break;
							case 10:
								line = reader.readLine();
								tmpvolo.setPrezzoEconomy(Integer.parseInt(line));
								break;
							case 11:
								line = reader.readLine();
								tmpvolo.setPrezzoBusiness(Integer.parseInt(line));
								break;
							case 12:
								line = reader.readLine();
								tmpvolo.setDurata(Integer.parseInt(line.substring(0,2)),
										Integer.parseInt(line.substring(2,4)));
								break;
						}
					
				}/*leggo tutto un volo*/            				
				
				if (tmpvolo.getAeroportoPartenza().equals(tmpvolo2.getAeroportoPartenza())
				   &&tmpvolo.getAeroportoDestinazione().equals(tmpvolo2.getAeroportoDestinazione())
				   &&tmpvolo.getDataPartenza().getGiorno()==tmpvolo2.getDataPartenza().
				   getGiorno()&&tmpvolo.getDataPartenza().getMese()==tmpvolo2.getDataPartenza().
				   getMese()) {            					
					
					if (classe.equals("Economy"))
						tmpvolo.setPostiLiberiEconomy(tmpvolo.getPostiLiberiEconomy()-(adulti+bambini));
					else
						tmpvolo.setPostiLiberiBusiness(tmpvolo.getPostiLiberiBusiness()-(adulti+bambini));
						
					out.println(tmpvolo.getNumeroVolo());
					out2.print(tmpvolo.getNumeroVolo()+" ");
					out.println(String.valueOf(model2.getValueAt(z, 5)).substring(0, 2)
							   +String.valueOf(model2.getValueAt(z, 5)).substring(3, 5));
					out2.print(String.valueOf(model2.getValueAt(z, 5)).substring(0, 2)
							  +String.valueOf(model2.getValueAt(z, 5)).substring(3, 5)+" ");					            				
					out.println(String.valueOf(model2.getValueAt(z, 6)).substring(0, 2)
							   +String.valueOf(model2.getValueAt(z, 6)).substring(3, 5));
					out2.print(String.valueOf(model2.getValueAt(z, 6)).substring(0, 2)
							  +String.valueOf(model2.getValueAt(z, 6)).substring(3, 5)+" ");					            				
					out.println(tmpvolo.getAeroportoPartenza());
					out2.print(tmpvolo.getAeroportoPartenza()+" ");
					out.println(tmpvolo.getAeroportoDestinazione());
					out2.print(tmpvolo.getAeroportoDestinazione()+" ");
					out.println(String.valueOf(model2.getValueAt(z, 3)));
					out2.print(String.valueOf(model2.getValueAt(z, 3))+" ");					            				
					out.println(String.valueOf(model2.getValueAt(z, 3)));
					out.println(tmpvolo.getPostiLiberiEconomy());
					out.println(tmpvolo.getPostiLiberiBusiness());
					out.println(tmpvolo.getPrezzoEconomy());
					out.println(tmpvolo.getPrezzoBusiness());				
					
					if (tmpvolo.getDurata().gethh()<=9&&tmpvolo.getDurata().getmm()<=9) {
						out.println("0"+Integer.toString(tmpvolo.getDurata().gethh())+"0"
								   +Integer.toString(tmpvolo.getDurata().getmm()));
					} else if (tmpvolo.getDurata().gethh()<=9&&tmpvolo.getDurata().getmm()>9) {
						out.println("0"+Integer.toString(tmpvolo.getDurata().gethh())
								   +Integer.toString(tmpvolo.getDurata().getmm()));
					} else if (tmpvolo.getDurata().gethh()>9&&tmpvolo.getDurata().getmm()<=9) {
						out.println(Integer.toString(tmpvolo.getDurata().gethh())+"0"
								   +Integer.toString(tmpvolo.getDurata().getmm()));						            				
					} else if (tmpvolo.getDurata().gethh()>9&&tmpvolo.getDurata().getmm()>9) {
						out.println(Integer.toString(tmpvolo.getDurata().gethh())
								   +Integer.toString(tmpvolo.getDurata().getmm()));
						}			            									            				
				} else {/*non è quello che mi interessa*/
					String strtmp;
					out.println(tmpvolo.getNumeroVolo());
					if (tmpvolo.getOrarioPartenza().gethh()>=0&&tmpvolo.getOrarioPartenza().gethh()<=9)
						strtmp="0"+Integer.toString(tmpvolo.getOrarioPartenza().gethh());
					else
						strtmp=Integer.toString(tmpvolo.getOrarioPartenza().gethh());
						
					if (tmpvolo.getOrarioPartenza().getmm()>=0&&tmpvolo.getOrarioPartenza().getmm()<=9)
							out.println(strtmp+"0"+Integer.toString(tmpvolo.getOrarioPartenza().getmm()));
					else
							out.println(strtmp+Integer.toString(tmpvolo.getOrarioPartenza().getmm()));
						
					if (tmpvolo.getOrarioArrivo().gethh()>=0&&tmpvolo.getOrarioArrivo().gethh()<=9)
						strtmp="0"+Integer.toString(tmpvolo.getOrarioArrivo().gethh());
					else
						strtmp=Integer.toString(tmpvolo.getOrarioArrivo().gethh());
						
					if (tmpvolo.getOrarioArrivo().getmm()>=0&&tmpvolo.getOrarioArrivo().getmm()<=9)
							out.println(strtmp+"0"+Integer.toString(tmpvolo.getOrarioArrivo().getmm()));
					else
							out.println(strtmp+Integer.toString(tmpvolo.getOrarioArrivo().getmm()));
					
					out.println(tmpvolo.getAeroportoPartenza());
					out.println(tmpvolo.getAeroportoDestinazione());
					out.println(Integer.toString(tmpvolo.getDataPartenza().getGiorno())+"/"
							   +Integer.toString(tmpvolo.getDataPartenza().getMese())+"/"
							   +Integer.toString(tmpvolo.getDataPartenza().getAnno()));
					out.println(Integer.toString(tmpvolo.getDataArrivo().getGiorno())+"/"
							   +Integer.toString(tmpvolo.getDataArrivo().getMese())+"/"
							   +Integer.toString(tmpvolo.getDataArrivo().getAnno()));
					out.println(tmpvolo.getPostiLiberiEconomy());
					out.println(tmpvolo.getPostiLiberiBusiness());
					out.println(tmpvolo.getPrezzoEconomy());
					out.println(tmpvolo.getPrezzoBusiness());
					
					if (tmpvolo.getDurata().gethh()<=9&&tmpvolo.getDurata().getmm()<=9) {
						out.println("0"+Integer.toString(tmpvolo.getDurata().gethh())+"0"
								   +Integer.toString(tmpvolo.getDurata().getmm()));
					} else if (tmpvolo.getDurata().gethh()<=9&&tmpvolo.getDurata().getmm()>9) {
						out.println("0"+Integer.toString(tmpvolo.getDurata().gethh())
								   +Integer.toString(tmpvolo.getDurata().getmm()));
					} else if (tmpvolo.getDurata().gethh()>9&&tmpvolo.getDurata().getmm()<=9) {
						out.println(Integer.toString(tmpvolo.getDurata().gethh())+"0"
								   +Integer.toString(tmpvolo.getDurata().getmm()));						            				
					} else if (tmpvolo.getDurata().gethh()>9&&tmpvolo.getDurata().getmm()>9) {
						out.println(Integer.toString(tmpvolo.getDurata().gethh())
								   +Integer.toString(tmpvolo.getDurata().getmm()));
					}	
				}
				
				line=reader.readLine();
			}
			reader.close();
			out.close();
			File file1 = new File(ind5);
			File file2 = new File(ind4);
			file1.renameTo(file2);
		}
			String cdp=assegnaCodicePrenotazione();
			out2.println("");				 			        
			out2.println(cdp);
	     
	     for (Integer k=1;k<model3.getRowCount()-1;k+=6) {
	     		out2.print(model3.getValueAt(k, 1)+" ");
	     		out2.print(model3.getValueAt(k+1, 1)+" ");
	     }
	     out2.println("");				 			        
	     out2.println(assicurazione);
	     out2.println(prenotazione.getBagagliStiva());
	     out2.println(prenotazione.getBagagliSpeciali());
	     out2.println(prenotazione.getRichieste());
	     for (Integer l=1;l<=(adulti+bambini);l++) {
	     	out2.print(assegnaTicketNumber()+" "+l+" ");
	     }
	     out2.println("");
	     out2.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * E' la funzione che verifica che l'indirizzo e-mail indicato durante la
	 * registrazione non sia già stato utilizzato per un altro account.
	 * 
	 * @return	Boolean
	 * 			la funzione ritorna false se l'indirizzo è già presente nel sistema
	 * 			e true altrimenti
	 * @param	String e
	 * @exception	IOException e1
	 */
	public static Boolean emailUnivoca(String e) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ind1));
			Integer count1=11;
		
			String line = reader.readLine();
		
			while (line!=null) {
        	
				if (count1==14) {
            	
					if (line.equals(e)) {
						reader.close();
						return false;
					} else {/*e-mail non corrisponde*/
						line = reader.readLine();
						count1=1;	            			
					}
				} else {/*count non è 14*/
					line = reader.readLine();
					count1+=1;
				}
			}
			reader.close();
		} catch (IOException e1) {
			return false;
		}
		return true;	
	}
	
	/**
	 * E' la funzione che verifica che lo username indicato durante la
	 * registrazione non sia già stato utilizzato per un altro account.
	 * 
	 * @return	Boolean
	 * 			la funzione ritorna false se lo username è già presente nel sistema
	 * 			e true altrimenti
	 * @param	String u
	 * @exception	IOException e
	 */
	public static Boolean userUnivoco(String u) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ind1));
			Integer count1=14;
			
			String line = reader.readLine();
			
	        while (line!=null) {
	        	
	            if (count1==14) {
	            		            	
	            	if (line.equals(u)) {
	            		reader.close();
	            		return false;
	            	} else {/*username non corrisponde*/
	            		line = reader.readLine();
	        	        count1=1;	            			
	            	}
	            } else {/*count non è 14*/
	            line = reader.readLine();
	            count1+=1;
	            }
	       }
			reader.close();	
		} catch (IOException e) {
			return false;
		}		
		return true;	
	}

	/**
	 * E' la funzione che assegna un codice Frequent Flyer all'utente
	 * a seguito della registrazione del nuovo account avvenuta con
	 * successo. Ha il compito di verificare che il codice non sia già
	 * stato assegnato ad alri utenti già registrati.
	 * 
	 * @return	String
	 * 			ritorna il codice Frequent Flyer, una volta verificato
	 * 			che sia disponibile ed univoco
	 * @exception	IOException e
	 */
	public static String assegnaFF() {
		String ff="";
		try {
			/*Integer x=(int) (Math.random() * 1000);*/	
			Boolean univoco=false;
						
			while (univoco==false) {
				ff="GG942"+String.valueOf(x);
				
				BufferedReader reader = new BufferedReader(new FileReader(ind1));
				Integer count1=8;
				
				String line = reader.readLine();
					
				while (line!=null) {
		    	
					if (count1==14) {
		        		            	
						if (line.equals(ff)) {
							x+=10;
							line=null;
							univoco=false;
						} else {/*ff non corrisponde*/
		        			line = reader.readLine();
		    	            count1=1;
		    	            univoco=true;
		        		}
		        	}	            
		        	else {/*count non è 14*/
		        		line = reader.readLine();
		        		count1+=1;
		        	}
				}
				reader.close();
			}
		} catch (IOException e) {
			return "errore";
		}
	return ff;
  }

	/**
	 * E' la funzione che assegna un codice di prenotazione 
	 * a seguito del completamento di una prenotazione avvenuta con
	 * successo. Ha il compito di verificare che il codice non sia già
	 * stato assegnato ad altre prenotazioni attive.
	 * 
	 * @return	String
	 * 			ritorna il codice Frequent Flyer, una volta verificato
	 * 			che sia disponibile
	 * @exception	IOException e
	 */
	public static String assegnaCodicePrenotazione() {
		String pnr="";
		try {
			/*Integer x=(int) (Math.random() * 1000);*/	
			Boolean univoco=false;
			
			while (univoco==false) {
				pnr="PNR"+String.valueOf(y);
				
				BufferedReader reader = new BufferedReader(new FileReader(ind2));
				Integer count1=7;
				
				String line = reader.readLine();
					
				while (line!=null) {
		    	
					if (count1==8) {
		        		            	
						if (line.equals(pnr)) {
							y+=10;
							line=null;
							univoco=false;
						} else {/*pnr non corrisponde*/
		        			line = reader.readLine();
		    	            count1=1;
		    	            univoco=true;
		        		}
		        	}	            
		        	else {/*count non è 14*/
		        		line = reader.readLine();
		        		count1+=1;
		        	}
				}
				reader.close();
			}
		} catch (IOException e) {
			return "errore";
		}
	return pnr;
  }
	
	/**
	 * E' la funzione che assegna un Ticket Number al passeggero
	 * a seguito di una prenotazione avvenuta con successo. Ha il 
	 * compito di verificare che il numero non sia già
	 * stato assegnato ad altri passeggeri di altre prenotazioni 
	 * già attive.
	 * 
	 * @return	String
	 * 			ritorna il codice Frequent Flyer, una volta verificato
	 * 			che sia disponibile
	 * @exception	IOException e
	 */
	public static String assegnaTicketNumber() {
		String tn="";
		try {
			/*Integer x=(int) (Math.random() * 1000);*/
			Boolean univoco=false;
			Boolean find=false;			
			
			while (univoco==false) {
				tn="TN021869"+String.valueOf(z);
				
				BufferedReader reader = new BufferedReader(new FileReader(ind2));
				Integer count1=1;
				
				String line = reader.readLine();
					
				while (line!=null) {
		    	
					if (count1==8) {
						StringTokenizer st = new StringTokenizer(line, " ");
						String word;
						
						while (st.hasMoreTokens()) {
							word=st.nextToken();
							
							if (word.equals(tn)) {
								find=true;
							}
						}
						
						if (find==true) {
							z+=10;
							line=null;
							univoco=false;
						} else {/*tn non corrisponde*/
		        			line = reader.readLine();
		    	            count1=1;
		    	            univoco=true;
		        		}
		        	}	            
		        	else {/*count non è 14*/
		        		line = reader.readLine();
		        		count1+=1;
		        	}
				}
				find=false;
				reader.close();
			}
		} catch (IOException e) {
			return "errore";
		}
	return tn;
  }

	/**
	 * E' la funzione che acquisisce i dati relativi ad una recensione e
	 * verifica che tutti i campi siano stati inseriti correttamente.
	 * Verifica inoltre che sia rispettato il formato numerico della
	 * valutazione.
	 * 
	 * @return	Integer che assume il valore corrispondente alla situazione
	 * 			che si è verificata durante l'esecuzione della funzione
	 * 			Output della funzione:
	 * 			-2		errore inserimento dati
	 * 			-1		NumberFormatException
	 *  		 0...5	OK
	 * @param	Recensione r
	 * @exception	NumberFormatException f
	 */
	public static Integer scriviRecensione(Recensione r) {
		Integer rt=0;
		try{
			r.setValutazione(Integer.parseInt(r.getStrvalutazione()));
			
			if (r.getTitolo().equals("")||r.getAmbito().equals("")
					  ||r.getTesto().equals("")||r.getValutazione()<0
					  ||r.getValutazione()>5) {
				
				 rt=-2; 
			} else {
				rt=r.getValutazione();
			}
			
		} catch (NumberFormatException f) {		  
			  rt=-1;
		}
		return rt;
	}
	
	/**
	 * E' la funzione che salva una recensione correttamente rilasciata,
	 * scrivendo i dati in un file di testo.
	 * 
	 * @return	Boolean
	 * 			la funzione ritorna false se il salvataggio non va a buon
	 * 			fine e true altrimenti
	 * @param	Recensione r
	 * @exception	IOException e
	 */
	public static Boolean salvaRecensione(Recensione r) {
			FileWriter pw;
			try {
				pw = new FileWriter(ind3,true);			
				PrintWriter fos = new PrintWriter(pw);
		
				fos.println(r.getTitolo());
				fos.println(r.getAmbito());
				fos.println(r.getTesto());
				fos.println(Integer.toString(r.getValutazione()));
		
				fos.close();
			} catch (IOException e) {
				return false;
			}
		
		return true;
	}
	
	/**
	 * E' la funzione che aggiorna il prezzo da pagare
	 * durante la procedura di prenotazione
	 * @param Double d
	 */
	public static void addPrezzo(Double d) {
		prezzo+=d;
	}
	
	public static Boolean getLogged() {
		return logged;
	}
	
	public static UtenteRegistrato getUtente() {
		return utente;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getInd1() {
		return ind1;
	}
	
	public static String getInd2() {
		return ind2;
	}
	
	public static String getInd3() {
		return ind3;
	}
	
	public static String getInd4() {
		return ind4;
	}
	
	public static String getInd5() {
		return ind5;
	}
	
	public static String getInd6() {
		return ind6;
	}
	
	public static String getInd7() {
		return ind7;
	}
	
	public static Integer getAdulti() {
		return adulti;
	}
	
	public static Integer getBambini() {
		return bambini;
	}
	
	public static Integer getRighe() {
		return righe;
	}
	
	public static Double getPrezzo() {
		return prezzo;
	}
	
	public static Boolean getCarta() {
		return carta;
	}
	
	public static String getAssicurazione() {
		return assicurazione;
	}
	
	public static String getClasse() {
		return classe;
	}
	
	public static Prenotazione getPrenotazione() {
		return prenotazione;
	}
	
	public static RicercaVoli getCriteri() {
		return criteri;
	}
	
	public static void setCriteri(RicercaVoli r) {
		criteri=r;
	}
	
	public static void setLogged(Boolean b) {
		logged=b;
	}
	
	public static ArrayList<ArrayList<Volo>> getItinerari() {
		return itinerari;
	}
	
	public static void setItinerari(ArrayList<ArrayList<Volo>> i) {
		itinerari=i;
	}
	
	public static void setUser(String s) {
		user=s;
	}
	
	public static void setInd1(String s) {
		ind1=s;
	}
	
	public static void setInd2(String s) {
		ind2=s;
	}
	
	public static void setInd3(String s) {
		ind3=s;
	}
	
	public static void setInd4(String s) {
		ind4=s;
	}
	
	public static void setInd5(String s) {
		ind5=s;
	}
	
	public static void setInd6(String s) {
		ind6=s;
	}
	
	public static void setInd7(String s) {
		ind7=s;
	}
	
	public static void setRighe(Integer i) {
		righe=i;
	}
	
	public static void setAssicurazione(String s) {
		assicurazione=s;
	}
	
	public static void setPrezzo(Double d) {
		prezzo=d;
	}
		
	public static void setCarta(Boolean b) {
		carta=b;
	}
	
	public static void setClasse(String s) {
		classe=s;
	}
}
