/*
 * Class Window
 * 
 * Version 1.0
 */
package prenotazioneItinerario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;

/**
 * E' la classe contenente le funzioni necessarie alla realizzazione del-
 * l'interfaccia, ed i relativi controlli sui dati di input inseriti.
 * In questa classe è contenuto il main, ed è quindi la classe tramite
 * la quale avviare l'intero programma.
 * In questa versione del programma non è stato inserito il commento
 * descrittivo delle singole funzioni, poichè la parte di interfaccia non
 * rientrava nelle specifiche della consegna.
 * 
 * @author Gabriele Grieco
 */	
public class Window {	
	private static Prenotazione pr;
	private static Persona dati=new Persona();
	static JFrame frame, frame2, frame3, frame5, frame6, frame7, frame8, frame9,
				  frame10;	
	static JLabel lblusername, lblpassword, lbldataritorno, lblgiornoritorno,
				  lblmeseritorno, lblannoritorno, lblnomepp, lblcognomepp,
				  lblnumero, lblscadenza, lblcodice, lblmailpp, lblpasswordpp,
				  lbltot, lblprezzo;
	static JTextField txtusername, txtorigine, txtdestinazione, txtgiornopartenza,
	  				  txtmesepartenza, txtannopartenza, txtgiornoritorno,
	  				  txtmeseritorno, txtannoritorno, txtnumadulti, txtnumbambini,
	  				  txtnome, txtcognome, txtgiornonascita, txtmesenascita,
	  				  txtannonascita, txteta, txtnazionalita, txtdomicilio,
	  				  txttitolo, txtambito, txtvalutazione, txtusr, txtemail,
	  				  txtdomanda, txtrisposta, txtnomepp, txtcognomepp, txtnumero,
					  txtscadenza, txtcodice, txtmailpp,txtstiva, txtspeciali;					  
	static JPasswordField txtpassword, txtpwd1, txtpwd2, txtpasswordpp;
	static JTextArea txttesto, txtrichieste;
	static JTable table3;
	static DefaultTableModel model3;
	static JCheckBox check1, check2, check3, check4, check5, check9, check10,
					 check11, check12, check13, check14;
	static JButton button2, button3, button6, button7, button13;
	static JButton button = new JButton("Cerca Voli");
	static JButton button9=new JButton("Prenota Itinerario");
	static JButton button10= new JButton("Prosegui Prenotazione");
	static JButton button11= new JButton("Prosegui Prenotazione");
	static JButton button12= new JButton("PAGA e PRENOTA");
	
	static class Maschio implements ActionListener {     		
		public void actionPerformed (ActionEvent e) {     
		 
		  if (check4.isSelected()==true) {
			  check5.setSelected(false);
			  dati.setSesso("M");
		  } else {
			  check5.setSelected(true);		
			  dati.setSesso("F");
		  }
	   }
	}  

	static class Femmina implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
		 
		  if (check5.isSelected()==true) {
			  check4.setSelected(false);
			  dati.setSesso("F");
		  } else {
			  check4.setSelected(true);		
			  dati.setSesso("M");
		  }
		}
	}

	static class Economy implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
		 
		  if (check2.isSelected()==true)
			  check2.setSelected(false);
		  else
			  check2.setSelected(true);
	  	}
	}  

	static class Business implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
		 
		  if (check1.isSelected()==true)
			  check1.setSelected(false);
		  else
			  check1.setSelected(true);
	  }
	}

	static class Andata implements ActionListener {
		public void actionPerformed (ActionEvent e) {     
		 
		  if (check3.isSelected()==true) {			  
			  lbldataritorno.setForeground(Color.GRAY);
			  lblgiornoritorno.setForeground(Color.GRAY);
			  lblmeseritorno.setForeground(Color.GRAY);
			  lblannoritorno.setForeground(Color.GRAY);
			  txtgiornoritorno.setText("");
			  txtmeseritorno.setText("");
			  txtannoritorno.setText("");
			  txtgiornoritorno.setEditable(false);
			  txtmeseritorno.setEditable(false);
			  txtannoritorno.setEditable(false);
		  } else {			  
			  lbldataritorno.setForeground(Color.BLACK);
			  lblgiornoritorno.setForeground(Color.BLACK);
			  lblmeseritorno.setForeground(Color.BLACK);
			  lblannoritorno.setForeground(Color.BLACK);
			  txtgiornoritorno.setText("");
			  txtmeseritorno.setText("");
			  txtannoritorno.setText("");
			  txtgiornoritorno.setEditable(true);
			  txtmeseritorno.setEditable(true);
			  txtannoritorno.setEditable(true);
		  }
		}
	}

	static class Full implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check9.isSelected()==true) {
				  check10.setSelected(false);
				  check11.setSelected(false);
				  check12.setSelected(false);
			  }
		  	}
		}

	static class Complete implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check10.isSelected()==true) {
				  check9.setSelected(false);
				  check11.setSelected(false);
				  check12.setSelected(false);
			  }
		  	}
		}

	static class Mini implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check11.isSelected()==true) {
				  check9.setSelected(false);
				  check10.setSelected(false);
				  check12.setSelected(false);
			  }
		  	}
		}

	static class None implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check12.isSelected()==true) {
				  check9.setSelected(false);
				  check10.setSelected(false);
				  check11.setSelected(false);
			  }
		  	}
		}
		
	static class Carta implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check13.isSelected()==true) {
				  check14.setSelected(false);
				  lblmailpp.setVisible(false);
				  txtmailpp.setVisible(false);
				  lblpasswordpp.setVisible(false);
				  txtpasswordpp.setVisible(false);
				  lblnomepp.setVisible(true);
				  txtnomepp.setVisible(true);
				  lblcognomepp.setVisible(true);
				  txtcognomepp.setVisible(true);
				  lblnumero.setVisible(true);
				  txtnumero.setVisible(true);
				  lblscadenza.setVisible(true);
				  txtscadenza.setVisible(true);
				  lblcodice.setVisible(true);
				  txtcodice.setVisible(true);
				  Sistema.setCarta(true);
			  } else {
				  check13.setSelected(false);
				  lblnomepp.setVisible(false);
				  txtnomepp.setVisible(false);
				  lblcognomepp.setVisible(false);
				  txtcognomepp.setVisible(false);
				  lblnumero.setVisible(false);
				  txtnumero.setVisible(false);
				  lblscadenza.setVisible(false);
				  txtscadenza.setVisible(false);
				  lblcodice.setVisible(false);
				  txtcodice.setVisible(false);
				  lblmailpp.setVisible(true);
				  txtmailpp.setVisible(true);
				  lblpasswordpp.setVisible(true);
				  txtpasswordpp.setVisible(true);
				  Sistema.setCarta(false);
			  }
		  	}
		}

	static class Pay_pal implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
			 
			  if (check14.isSelected()==true) {
				  check13.setSelected(false);
				  lblnomepp.setVisible(false);
				  txtnomepp.setVisible(false);
				  lblcognomepp.setVisible(false);
				  txtcognomepp.setVisible(false);
				  lblnumero.setVisible(false);
				  txtnumero.setVisible(false);
				  lblscadenza.setVisible(false);
				  txtscadenza.setVisible(false);
				  lblcodice.setVisible(false);
				  txtcodice.setVisible(false);
				  lblmailpp.setVisible(true);
				  txtmailpp.setVisible(true);
				  lblpasswordpp.setVisible(true);
				  txtpasswordpp.setVisible(true);
				  Sistema.setCarta(false);
			  } else {
				  check14.setSelected(false);
				  lblmailpp.setVisible(false);
				  txtmailpp.setVisible(false);
				  lblpasswordpp.setVisible(false);
				  txtpasswordpp.setVisible(false);
				  lblnomepp.setVisible(true);
				  txtnomepp.setVisible(true);
				  lblcognomepp.setVisible(true);
				  txtcognomepp.setVisible(true);
				  lblnumero.setVisible(true);
				  txtnumero.setVisible(true);
				  lblscadenza.setVisible(true);
				  txtscadenza.setVisible(true);
				  lblcodice.setVisible(true);
				  txtcodice.setVisible(true);
				  Sistema.setCarta(true);
			  }
		  	}
		  }
	  
	static class creaFrame2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JPanel panel2 = new JPanel();
		    panel2.setLayout(null);
		    frame2 = new JFrame("Registrazione");
		    frame2.add(panel2);
		    frame2.setSize(400,335);
		    frame2.setVisible(true);
		   
		    JLabel lblnome=new JLabel("Nome");
		    panel2.add(lblnome);
		    txtnome=new JTextField();
		    panel2.add(txtnome);
		    JLabel lblcognome=new JLabel("Cognome");
		    panel2.add(lblcognome);		
		    txtcognome=new JTextField();
		    panel2.add(txtcognome);
		    JLabel lbldata=new JLabel("Data Nascita");
		    panel2.add(lbldata);
		    JLabel lblgg=new JLabel("gg");
		    panel2.add(lblgg);
		    JLabel lblmm=new JLabel("mm");
		    panel2.add(lblmm);
		    JLabel lblaaaa=new JLabel("aaaa");
		    panel2.add(lblaaaa);
		    txtgiornonascita=new JTextField();
		    panel2.add(txtgiornonascita);
		    txtmesenascita=new JTextField();
		    panel2.add(txtmesenascita);
		    txtannonascita=new JTextField();
		    panel2.add(txtannonascita);
		    txteta=new JTextField();
		    panel2.add(txteta);
		    JLabel lbleta=new JLabel("Età");
		    panel2.add(lbleta);
		    check4 = new JCheckBox("M",true);
		    panel2.add(check4);
		    JLabel lblsesso=new JLabel("Sesso");
		    panel2.add(lblsesso);
			check4.addActionListener (new Maschio());
			check5 = new JCheckBox("F",false);
			panel2.add(check5);
			check5.addActionListener (new Femmina());
		    JLabel lblnazionalita=new JLabel("Nazionalità");
		    panel2.add(lblnazionalita);
		    txtnazionalita=new JTextField();
		    panel2.add(txtnazionalita);
		    JLabel lbldomicilio=new JLabel("Domicilio");
		    panel2.add(lbldomicilio);
		    txtdomicilio=new JTextField();
		    panel2.add(txtdomicilio); 		    
		    JButton button4 = new JButton("Conferma Dati");
		    panel2.add(button4);
			button4.addActionListener (new Procedi());		  

			lblnome.setBounds(10, 5, 50, 15);
			txtnome.setBounds(10 ,25,185,20);
			lblcognome.setBounds(205, 5, 70, 15);
			txtcognome.setBounds(205 ,25,185,20);
			lbldata.setBounds(10, 60, 120, 15);
			lblgg.setBounds(10, 80, 30, 15);
			lblmm.setBounds(40, 80, 30, 15);
			lblaaaa.setBounds(70, 80, 50, 15);
			txtgiornonascita.setBounds(10 ,100,22,20);
			txtmesenascita.setBounds(40,100,22,20);
			txtannonascita.setBounds(70,100,40,20);
			lbleta.setBounds(140, 80, 50, 15);
			txteta.setBounds(140, 100, 22, 20);
			lblsesso.setBounds(210, 80, 50, 15);
			check4.setBounds(210, 100, 50, 20);
			check5.setBounds(260, 100, 50, 20);
			lbldomicilio.setBounds(10, 150, 120, 15);
			txtdomicilio.setBounds(10, 170, 380, 20);
			lblnazionalita.setBounds(10, 205, 150, 15);
			txtnazionalita.setBounds(10, 225, 120, 20);			  
			button4.setBounds(100 ,275,220,25);	  
		}
	}
	
	static class Procedi implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			  String domicilio;
			  dati.inizializzaDataNascita();		  
			  dati.setNome(txtnome.getText());
			  dati.setCognome(txtcognome.getText());
			  dati.setStrgg(txtgiornonascita.getText());
			  dati.setStrmm(txtmesenascita.getText());
			  dati.setStraaaa(txtannonascita.getText());
			  dati.setStreta(txteta.getText());
			  dati.setNazionalita(txtnazionalita.getText());
			  domicilio=txtdomicilio.getText();
			  
			  if (check4.isSelected()==true) {  		  
				  dati.setSesso("M");
				} else {
				  dati.setSesso("F");
				}
			  
			  Integer lg=Sistema.datiAnagrafica(dati, domicilio);
			  
			  switch (lg) {
			  case-1:
				  JOptionPane.showMessageDialog(null,"Inserire correttamente tutti i "
	  						+ "dati per la registrazione"+'\n'
	  						+"- Nome, Cognome, Nazionalità, "
	  						+ "Domicilio deve essere una stringa "
	  						+ "di caratteri"+'\n'+"- Il Giorno di "
	  						+ "nascita deve essere un nimero compreso "
	  						+"tra 1 e 31"+'\n'+"- Il Mese di nascita "
	  						+ "deve essere un numero compreso tra 1 e 12"
	  						+'\n'+"- L'Anno di nascita deve essere"
	  						+"un numero compreso tra 1917 e 1999"+'\n'
	  						+"- La Data di Nascita"
	  						+"deve essere una data valida"+'\n'
	  						+"- l'età deve essere compresa tra "
	  						+ "18 e 100","Inserimento dati non corretto",
	  						JOptionPane.WARNING_MESSAGE);
				  break;
			  case 0:
				  JOptionPane.showMessageDialog(null,"Inserire correttamente tutti i "
						  + "dati per la registrazione"+'\n'
						  +"- Nome, Cognome, Nazionalità, "
						  + "Domicilio e E-mail devono essere "
						  
						  + "stringhe di caratteri"+'\n'
						  +"- Il Giorno di nascita deve essere "
						  + "un nimero compreso tra 1 e 31"+'\n'
						  +"- Il Mese di nascita deve essere un numero"
						  +"compreso tra 1 e 12"+'\n'+"- L'Anno di "
						  + "nascita deve essere un numero compreso tra "
						  + "1917 e 1999"+'\n'+"- La Data di Nascita"
						  +"deve essere una data valida"+'\n'
						  +"- l'età deve essere compresa tra "
						  + "18 e 100","Inserimento dati non corretto",
						  JOptionPane.WARNING_MESSAGE);
				  break;
			  case 1:
				  frame2.dispose();
					
					frame3 = new JFrame("Registrazione");
					frame3.setVisible(true);
					frame3.setSize(570,550);
					JPanel panel3 = new JPanel();
					panel3.setLayout(null);
					 
					frame3.add(panel3);
					
					JLabel lblemail=new JLabel("Indirizzo e-mail");
					panel3.add(lblemail);
					txtemail=new JTextField();
					panel3.add(txtemail);
					JLabel lblusr=new JLabel("Username");
					panel3.add(lblusr);
					txtusr=new JTextField();
					panel3.add(txtusr);
					JLabel lblpwd1=new JLabel("Password");
					panel3.add(lblpwd1);
					txtpwd1=new JPasswordField();
					panel3.add(txtpwd1);
					JLabel lblpwd2=new JLabel("Ripeti Password");
					panel3.add(lblpwd2);
					txtpwd2=new JPasswordField();
					panel3.add(txtpwd2);
					JLabel lbldomanda=new JLabel("Domanda di Ripristino");
					panel3.add(lbldomanda);
					txtdomanda=new JTextField();
					panel3.add(txtdomanda);
					JLabel lblrisposta=new JLabel("Risposta");
					panel3.add(lblrisposta);
					txtrisposta=new JTextField();
					panel3.add(txtrisposta);
					 
					JTextArea txtistruzioni=new JTextArea();
					panel3.add(txtistruzioni);
					txtistruzioni.setText("Istruzioni scelta credenziali:"
										  +'\n'+"- Username:"+'\n'+"  deve avere lunghezza compresa "
										  +"tra 5 e 10 caratteri"+'\n'+"  non deve contenere spazi, "
										  + "caratteri "+"speciali e non deve iniziare con un numero"
										  +'\n'+'\n'+"- Password"+'\n'+"  deve avere lunghezza compresa tra "
										  + "8 e 12 caratteri"+'\n'+"  non deve contenere spazi"+'\n'
										  +"  deve contenere almeno una lettera "+"maiuscola e un "
										  + "carattere speciale (@ / | * ? < > :"+'\n'+'\n'
										  +"- L'E-mail "+"inserita deve essere un'indirizzo mail valido");
					 
					JButton button5 = new JButton("Conferma");
					panel3.add(button5);
					button5.addActionListener (new Conferma());	
						  
					lblemail.setBounds(10, 5, 150, 15);
					txtemail.setBounds(10, 25, 250, 20);
					lblusr.setBounds(10, 60, 100, 15);
					txtusr.setBounds(10, 80, 150, 20);
					lblpwd1.setBounds(10, 115, 100, 15);
					txtpwd1.setBounds(10, 135, 180, 20);
					lblpwd2.setBounds(220, 115, 150, 15);
					txtpwd2.setBounds(220, 135, 180, 20);
					lbldomanda.setBounds(10, 170, 250, 15);
					txtdomanda.setBounds(10, 190, 550, 20);
					lblrisposta.setBounds(10, 225, 100, 15);
					txtrisposta.setBounds(10, 245, 550, 20);
					button5.setBounds(150,295,200,25);
					txtistruzioni.setBounds(10,350,550,170);
				  break;
			  }
		}
	}
	
	static class Conferma implements ActionListener {//apr    
		  @SuppressWarnings("deprecation")
		public void actionPerformed (ActionEvent e) {
			  UtenteRegistrato u=new UtenteRegistrato();
			  Persona p=new Persona();
			  
			  p.setEmail(txtemail.getText());
			  u.setUsername(txtusr.getText());						  								  			
			  u.setPwd1(txtpwd1.getText());
			  u.setPwd2(txtpwd2.getText());			
			  u.setDomanda(txtdomanda.getText());
			  u.setRisposta(txtrisposta.getText());
			  u.setAnagrafica(p);			  		  
			  
			  Integer lg;
			  lg = Sistema.registrazioneAccount(u);
						  
			  switch (lg) {
			  case-1:
				  JOptionPane.showMessageDialog(null,"Inserire le credenziali secondo "
						  						+"le specifiche"+'\n'+"- Username:"+'\n'
						  						+"  deve avere lunghezza compresa "
						  						+"tra 5 e 10 caratteri"+'\n'+"  non deve "
						  						+ "contenere spazi, caratteri "
						  						+"speciali e non deve iniziare con un numero"
						  						+'\n'+"- Password"+'\n'+"  deve avere "
						  						+ "lunghezza compresa tra 8 e 12 caratteri"+'\n'
						  						+"  non deve contenere spazi"+'\n'+"  deve "
						  						+ "contenere almeno una lettera maiuscola e "
						  						+ "un carattere speciale (@ / | * ? < > :"+'\n'
						  						+"- L'E-mail inserita deve essere un'indirizzo "
						  						+ "mail valido","Credenziali non corrette",
						  						JOptionPane.WARNING_MESSAGE);
				  break;
			  case 0:
				  JOptionPane.showMessageDialog(null,"Lo Username inserito è già in uso."
		  				  						+'\n'+" Scegliere un nuovo Username",
		  				  						"Username non disponibile",JOptionPane.WARNING_MESSAGE);
				  break;
			  case 1:
				  JOptionPane.showMessageDialog(null,"I due campi Password non "
  						  						+ "coincidono","Errore Password",
  						  						JOptionPane.WARNING_MESSAGE);
				  break;
			  case 2:
				  JOptionPane.showMessageDialog(null,"L'indirizzo mail inserito "
  						  						+ "è già in uso."+'\n'+"Scegliere un nuovo indirizzo",
  						  						"E-mail già presente nel sistema",
  						  						JOptionPane.WARNING_MESSAGE);
				  break;
			  case 3:					
					frame3.dispose();
					JOptionPane.showMessageDialog(null,"Il nuovo Account è stato salvato."
							+'\n'+ "Validare l'indirizzo e-mail "
							+ "tramite il link ricevuto "
							+ "via posta "+ "elettronica entro 6 ore."+'\n'
							+"Se la validazione non viene effettuata "
							+ "in tempo l'account verra rimosso dal "
							+ "sistema e sarà necessario ripetere "
							+ "la registrazione","Registrazione avvenuta "
							+ "con successo",JOptionPane.INFORMATION_MESSAGE);
					break;
			  }			
		  }
		}
	
	static class Login implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed (ActionEvent e) {     
			String usr;
			String pwd;	  
			usr=txtusername.getText();
			pwd=txtpassword.getText();
			
					if (Sistema.autenticazione(usr, pwd)==false){
						JOptionPane.showMessageDialog(null,"Inserire nuovamente utente e password ",
								  					  "Login: username e password",JOptionPane.WARNING_MESSAGE);
						txtpassword.setText("");
					} else {
						Integer lg = Sistema.login(usr, pwd);
												
						switch (lg) {
						case -1:
							JOptionPane.showMessageDialog(null,"Username non riconosciuto. Inserire nuovamente "
									  					  + "le credenziali","Errore Login",
									  					  JOptionPane.WARNING_MESSAGE);
							txtpassword.setText("");
							break;
						case 0:
							JOptionPane.showMessageDialog(null,"L'account è bloccato. "
														  + "Contattare l'assistenza",
														  "Account Bloccato",
														  JOptionPane.WARNING_MESSAGE);
							txtusername.setText("");
							txtpassword.setText("");
							break;
						case 1:
							txtusername.setText("");
							txtpassword.setText("");            					
							button6.setVisible(true);
							lblusername.setVisible(false);
							txtusername.setVisible(false);
							lblpassword.setVisible(false);
							txtpassword.setVisible(false);
							button2.setVisible(false);
							button3.setVisible(false);
							button13.setText("LogOut ["+Sistema.getUser()+"]");
							button13.setVisible(true);
							Sistema.setLogged(true);
							break;
						case 2:
							JOptionPane.showMessageDialog(null,"La password inserita non è "
									  					  + "corretta","Errore Login",
									  					  JOptionPane.WARNING_MESSAGE);
							txtpassword.setText("");
							break;
						case 3:
							JOptionPane.showMessageDialog(null,"Errore autenticazione",
				  					  					  "Errore Login",JOptionPane.WARNING_MESSAGE);	
							break;
						}
					}
				}	
	}  
	
	static class Logout implements ActionListener {
		public void actionPerformed (ActionEvent e) {		  
			Window.button6.setVisible(false);
			Window.lblusername.setVisible(true);
			Window.txtusername.setVisible(true);
			Window.lblpassword.setVisible(true);
			Window.txtpassword.setVisible(true);
			Window.button2.setVisible(true);
			Window.button3.setVisible(true);
			Window.button13.setVisible(false);
			Sistema.setLogged(false);
	  }	  
	}
	
	static class Ricerca implements ActionListener {
		public void actionPerformed (ActionEvent e) {		
				Sistema.getCriteri().inizializzaDataPartenza();
				Sistema.getCriteri().inizializzaDataRitorno();		
				Sistema.getCriteri().setAeroportoPartenza(txtorigine.getText().toUpperCase());
				Sistema.getCriteri().setAeroportoDestinazione(txtdestinazione.getText().toUpperCase());
				Sistema.getCriteri().setStrggA(txtgiornopartenza.getText());
				Sistema.getCriteri().setStrmmA(txtmesepartenza.getText());
				Sistema.getCriteri().setStraaaaA(txtannopartenza.getText());	   
				Sistema.getCriteri().setStradulti(txtnumadulti.getText());
				Sistema.getCriteri().setStrbambini(txtnumbambini.getText());
	   
			  	if (check1.isSelected()==true)
			  		Sistema.getCriteri().setClasseDiViaggio("Economy");
			  	else
			  		Sistema.getCriteri().setClasseDiViaggio("Business");   
		
			  	if (check3.isSelected()==false) {			
			  		Sistema.getCriteri().setStrggR(txtgiornoritorno.getText());
					Sistema.getCriteri().setStrmmR(txtmeseritorno.getText());
					Sistema.getCriteri().setStraaaaR(txtannoritorno.getText());			  		
			  		Sistema.getCriteri().setSoloAndata(false);
			  	} else {			
			  		Sistema.getCriteri().setDataRitorno(0,0,0);
			  		Sistema.getCriteri().setSoloAndata(true);
			  	}
			  	
			  	Integer lg=Sistema.ricercaItinerario(Sistema.getCriteri());
							  	
			  	switch (lg) {
			  	case -1:
			  		JOptionPane.showMessageDialog(null,"Inserire correttamente"
			  									  + " tutti i dati per la ricerca"
			  									  +'\n'+"- Aeroporto di partenza "
			  									  + "e Aeroporto di destinazione "
			  									  + "devono essere stringhe"
			  									  + " di lettere non uguali"+'\n'
			  									  +"- Giorno di partenza e Giorno "
			  									  + "di arrivo devono essere numeri"
			  									  + " compresi tra 1 e 31 (o 30 in "
			  									  + "base al mese specificato)"+'\n'
			  									  +"- Mese di partenza e Mese di "
			  									  + "arrivo devono essere numeri "
			  									  + "compresi tra 1 e 12"+'\n'
			  									  +"- Anno di partenza e Anno di "
			  									  + "arrivo devono essere numeri uguali "
			  									  + "a 2017 o 2018"+'\n'+"- La Data "
			  									  + "di Ritorno non deve essere "
			  									  + "antecedente a quella di partenza"
			  									  +'\n'+"- Numero di passeggeri adulti "
			  									  + "e Numero di passeggeri bambini "
			  									  + "devono essere numeri","Parametri "
			  									  + "di ricerca non corretti",
			  									  JOptionPane.WARNING_MESSAGE);
			  		break;
			  	case 0:
			  		JOptionPane.showMessageDialog(null,"La località di partenza inserita "
							  					  + "non è raggiunta da nessuna compagnia aerea"
							  					  +'\n'+"oppure la località è stata inserita in "
							  					  + "modo errato","Aeroporto di Partenza non "
							  					  + "trovato",JOptionPane.WARNING_MESSAGE);
			  		break;
			  	case 1:
			  		JOptionPane.showMessageDialog(null,"La località di destinazione inserita "
			  									  + "non è raggiunta da nessuna compagnia aerea"
			  									  +'\n'+"oppure la località è stata inserita in "
			  									  + "modo errato","Aeroporto di Destinazione non trovato",
			  									  JOptionPane.WARNING_MESSAGE); 
			  		break;
			  	case 2:
			  		JOptionPane.showMessageDialog(null,"Inserire correttamente tutti i dati per la ricerca"
			  									  +'\n'+"- Aeroporto di partenza e Aeroporto di "
			  									  + "destinazione devono essere stringhe"
			  									  + " di lettere non uguali"+'\n'+"- Giorno di partenza "
			  									  + "e Giorno di arrivo devono essere numeri"
			  									  + " compresi tra 1 e 31 (o 30 in base al mese specificato)"
			  									  +'\n'+"- Mese di partenza e Mese di arrivo devono essere "
			  									  + "numeri compresi tra 1 e 12"+'\n'+"- Anno di partenza "
			  									  + "e Anno di arrivo devono essere numeri uguali a 2017 o 2018"
			  									  +'\n'+"- La Data di Ritorno non deve essere antecedente a "
			  									  + "quella di partenza"+'\n'+"- Numero di passeggeri adulti "
			  									  + "e Numero di passeggeri bambini devono essere numeri",
			  									  "Parametri di ricerca non corretti",
			  									  JOptionPane.WARNING_MESSAGE);
			  		break;
			  	case 3:
			  		frame5 = new JFrame("Ricerca Itinerari");
					frame5.setVisible(true);
					frame5.setSize(650,460);

					JPanel panel5 = new JPanel();
					frame5.add(panel5);
					  
					JTable table = new JTable(0, 0);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					JScrollPane  scrollpane = new JScrollPane(table); 
					panel5.add(scrollpane);
					   
					model.addColumn("Partenza");
					model.addColumn("Destinazione");
					model.addColumn("");
					    
					    for (Integer a=0;a<Sistema.getItinerari().size();a++ ) {
					    	model.setRowCount(model.getRowCount() + 1);
					    	model.setValueAt("Itinerario", model.getRowCount() - 1, 0);
					    	model.setValueAt((a+1), model.getRowCount() - 1, 1);
					    	model.setValueAt("Dettagli", model.getRowCount() - 1, 2);
					    	
					    	for (Integer b=0;b<Sistema.getItinerari().get(a).size();b++) {
					    		model.setRowCount(model.getRowCount() + 1);
					    		model.setValueAt(Sistema.getItinerari().get(a).get(b).getAeroportoPartenza(),
					    				model.getRowCount() - 1, 0);
					    		model.setValueAt(Sistema.getItinerari().get(a).get(b).getAeroportoDestinazione(),
					    				model.getRowCount() - 1, 1);
					    	}
					    	model.setRowCount(model.getRowCount() + 1);
					    }
					  
					    table.addMouseListener(new java.awt.event.MouseAdapter() {
					        @Override
					        public void mouseClicked(java.awt.event.MouseEvent evt) {
					            int row = table.rowAtPoint(evt.getPoint());
					            int col = table.columnAtPoint(evt.getPoint());
					            Integer it;
					            
					            if (model.getValueAt(row, 0).equals("Itinerario")&&col==2) {
				            		
				            		  it=((Integer) model.getValueAt(row, 1)-1);
				            		
				            		  frame6 = new JFrame("Itinerario "+(it+1)+" - Dettagli");
				            		  frame6.setVisible(true);
				            		  frame6.setSize(1000,240);

				            		  JPanel panel6 = new JPanel();
				            		  panel6.setLayout(null);
				            		  frame6.add(panel6);	  
				            		  
				            		  
				            		  
				            		  panel6.add(button9);
				            		  button9.addActionListener (new Prenota1());
				            		  button9.setEnabled(false);
				            		              			
				            		  Sistema.table2 = new JTable(0, 0);
				            		  Sistema.model2 = (DefaultTableModel) Sistema.table2.getModel();
				            			
				            		  JScrollPane  scrollpane2 = new JScrollPane(Sistema.table2); 
				            		  panel6.add(scrollpane2);
				            		  
				            		  scrollpane2.setBounds(5, 5, 990, 150);
				            		  button9.setBounds(400, 180, 200, 25);
				            		  
				            		  Sistema.model2.addColumn("N° Volo");
				            		  Sistema.model2.addColumn("Partenza");
				            		  Sistema.model2.addColumn("Destinazione");
				            		  Sistema.model2.addColumn("Data Partenza");
				            		  Sistema.model2.addColumn("Durata");
				            		  Sistema.model2.addColumn("Orario Partenza");
				            		  Sistema.model2.addColumn("Orario Arrivo");
				            		  Sistema.model2.addColumn("Prezzo Economy");
				            		  Sistema.model2.addColumn("Prezzo Business");
				            		  
				            		  Integer lg= Sistema.dettagliVoli(Sistema.getItinerari(),Sistema.getCriteri(),it);
				            		  
				            		  switch (lg) {
				            		  case -1:
				            				  JOptionPane.showMessageDialog(null,"Uno o più voli dell'itinerario non "
					  					    								+"hanno posti liberi sufficienti nella "
					  					    								+ "classe selezionata."+'\n'+"Tornare nella "
					  					    								+ "schermata precedente e scegliere un "
					  					    								+"altro itinerario oppure effettuare una "
					  					    								+ "nuova ricerca nella homepage",
					  					    								"Posti non Disponibili",
					  					    								JOptionPane.INFORMATION_MESSAGE);
				            			  break;
				            		  case 0:
				            				  JOptionPane.showMessageDialog(null,"Uno o più voli dell'itinerario non "
					  														+ "hanno posti liberi sufficienti nella "
					  														+ "classe selezionata."+'\n'+"Tornare nella "
					  														+ "homepage, ripetere la ricerca e scegliere "
					  														+ "un altro itinerario, oppure effettuare "
					  														+ "una nuova ricerca.",
					  														"Posti non Disponibili",
					  														JOptionPane.INFORMATION_MESSAGE);
				            			  break;
				            		  case 1:
				            			  button9.setEnabled(true);
				            			  break;
				            		  case 2:
				  			  			JOptionPane.showMessageDialog(null,"Errore tecnico, ripetere le oerazioni",
				  												  "ERRORE DI SISTEMA",JOptionPane.WARNING_MESSAGE);
				  			  			break;
				            		  }
					            }
					        }
					    });
					    break;
			  		case 4:
			  			JOptionPane.showMessageDialog(null,"Errore tecnico, ripetere le oerazioni",
												  "ERRORE DI SISTEMA",JOptionPane.WARNING_MESSAGE);
			  			break;
			  		}
			}
	}  

	static class Prenota1 implements ActionListener {  
		  public void actionPerformed (ActionEvent e) { 
			 
			  if (Sistema.getLogged()==false) {
				  JOptionPane.showMessageDialog(null,"Per procedere con la prenotazione "
						  						+"è necessario essere utenti registrati "
						  						+ "ed effeuuare il Login."+'\n'+"Eseguire "
						  						+ "l'autenticazione nella homepage."+'\n'
						  						+"Se non si è ancora iscritti è possibile "
						  						+ "effettuare la registrazione nella homepage."
						  						,"Autenticazione Necessaria",
						  						JOptionPane.INFORMATION_MESSAGE);
				  
			  } else {			  			 		
				  
				 		frame7 = new JFrame("Dati Passeggeri");
				 		frame7.setVisible(true);
				 		frame7.setSize(550,290);

				 		JPanel panel7 = new JPanel();
				 		panel7.setLayout(null);
				 		frame7.add(panel7);
				 		table3 = new JTable(0, 0);//tabella vuota
				 		model3 = (DefaultTableModel) table3.getModel(); 
				 						 		
				 		JScrollPane  scrollpane3 = new JScrollPane(table3); 
				 		panel7.add(scrollpane3);
				 		
				 		scrollpane3.setBounds(5, 5, 540, 250);
				 		
				 		model3.addColumn("DATI");
				 		model3.addColumn("PASSEGGERI");
				 		
				 		for (Integer i=0;i<Sistema.getAdulti()+Sistema.getBambini();i++) {
				 			model3.setRowCount(model3.getRowCount() + 1);
					    	model3.setValueAt("Passeggero "+(i+1), model3.getRowCount() - 1, 1);
					    	model3.setRowCount(model3.getRowCount() + 1);
					    	model3.setValueAt("Nome*", model3.getRowCount() - 1, 0);
					    	model3.setRowCount(model3.getRowCount() + 1);
					    	model3.setValueAt("Cognome*", model3.getRowCount() - 1, 0);
					    	model3.setRowCount(model3.getRowCount() + 1);
					    	model3.setValueAt("Età*", model3.getRowCount() - 1, 0);
					    	model3.setRowCount(model3.getRowCount() + 1);
					    	model3.setValueAt("Numero Frequent Flyer", model3.getRowCount() - 1, 0);
					    	model3.setRowCount(model3.getRowCount() + 1);
				 		}
				 		model3.setRowCount(model3.getRowCount() + 1);
				 		model3.setValueAt("PRENOTA - (Confermo veridicità dei dati)", model3.getRowCount() - 1, 1);
				 		Sistema.setRighe(model3.getRowCount()); 
				 		
				 		table3.addMouseListener(new java.awt.event.MouseAdapter() {
					        @Override
					        public void mouseClicked(java.awt.event.MouseEvent evt) {
					            int row = table3.rowAtPoint(evt.getPoint());
					            int col = table3.columnAtPoint(evt.getPoint());
					        
					            if (row==Sistema.getRighe()-1&&col==1) {
					            	Integer lg=Sistema.callPrenota1(table3, model3);
					            	
					            	switch (lg) {
					            	case-1:
					            		JOptionPane.showMessageDialog(null,"Compilare correttamente tutti i campi "
					            									  +"obbligatori (*)","Errore Inserimento Dati",
					            									  JOptionPane.WARNING_MESSAGE);
					            		break;
					            	case 0:
					            		JOptionPane.showMessageDialog(null,"Compilare correttamente i campi "
					            									  +"età con valori numerici","Errore "
					            									  + "Inserimento Dati",
					            									  JOptionPane.WARNING_MESSAGE);
					            		break;
					            	case 1:
					            		JOptionPane.showMessageDialog(null,"Il numero di passeggeri bambini "
						  						  					  +"(max 11 anni) non coincide con il numero"
						  						  					  + " indicato nei parametri di ricerca."
						  						  					  +'\n'+"Verificare i dati inseriti o "
						  						  					  + "ripetere la ricerca con nuovi Sistema.getCriteri().",
						  						  					  "Errore Inserimento Dati",
						  						  					  JOptionPane.INFORMATION_MESSAGE);
					            		break;
					            	case 2:
					            		frame7.dispose();
					            		frame8 = new JFrame("Bagagli & Richieste");
					            		frame8.setVisible(true);
					            		frame8.setSize(410,385);
					 					  
					 					JPanel panel8 = new JPanel();
					 					panel8.setLayout(null);
					 					frame8.add(panel8);
					 					  
					 					JLabel lblstiva=new JLabel("Bagagli in Stiva");
					 					panel8.add(lblstiva);
					 					txtstiva=new JTextField();
					 					panel8.add(txtstiva);
					 					txtstiva.setText("0");
					 					JLabel lblspeciali=new JLabel("Bagagli Speciali");
					 					panel8.add(lblspeciali);
					 					txtspeciali=new JTextField();
					 					panel8.add(txtspeciali);
					 					txtspeciali.setText("0");
					 					JCheckBox check6 = new JCheckBox("Notifica Check-in disponibile",true);
					 					panel8.add(check6);
					 					JCheckBox check7 = new JCheckBox("Notifica variazioni voli",true);
					 					panel8.add(check7);
					 					JCheckBox check8 = new JCheckBox("Ricevi info sulla destinazione",true);
					 					panel8.add(check8);
					 					JLabel lblrichieste=new JLabel("Richieste Aggiuntive");
					 					panel8.add(lblrichieste);
					 					txtrichieste=new JTextArea();
					 					panel8.add(txtrichieste);
					 					txtrichieste.setLineWrap(true);
					 					txtrichieste.setBackground(Color.CYAN);
					 					 							 					  				 					
					 					panel8.add(button10);
					 					button10.addActionListener (new Prenota2());
					 					  
					 					lblstiva.setBounds(10,10,150,15);
					 					txtstiva.setBounds(10,30,25,20);
					 					lblspeciali.setBounds(200,10,150,15);
					 					txtspeciali.setBounds(200,30,25,20);
					 					check6.setBounds(10, 85, 300, 20);
					 					check7.setBounds(10, 120, 300, 20);
					 					check8.setBounds(10, 155, 300, 20);
					 					lblrichieste.setBounds(10,210,150,15);
					 					txtrichieste.setBounds(10,230,390,70);							 					  
					 					button10.setBounds(105,325,200,25);
					 					break;
					            	}

					            }
					        
					        }
				 		});
					        
			  }
		  	}
		}
	
	static class Prenota2 implements ActionListener {      
		  public void actionPerformed (ActionEvent e) {
			  
			  if (Sistema.getLogged()==false) {
				  JOptionPane.showMessageDialog(null,"Per procedere con la prenotazione "
						  						+"è necessario essere utenti registrati "
						  						+ "ed effeuuare il Login."+'\n'+"Eseguire "
						  						+ "l'autenticazione nella homepage."+'\n'
						  						+"Se non si è ancora iscritti è possibile "
						  						+ "effettuare la registrazione nella homepage."
						  						,"Autenticazione Necessaria",
						  						JOptionPane.INFORMATION_MESSAGE);
			  } else {
				  pr=new Prenotazione();
				  pr.setStrstiva(txtstiva.getText());
				  pr.setStrspeciali(txtspeciali.getText());
				  pr.setRichieste(txtrichieste.getText());
				  
				  Integer lg=Sistema.callPrenota2(pr);
				  
				  switch (lg) {
				  case -1:
					  JOptionPane.showMessageDialog(null,"Compilare correttamente i campi "
		  					  						+"dei bagagli da acquistare con valori "
		  					  						+ "numerici","Errore Inserimento Dati",
		  					  						JOptionPane.WARNING_MESSAGE);
					  break;
				  case 0:
					  JOptionPane.showMessageDialog(null,"E' consentito il trasporto "
	  						  						+"da 0 a 2 bagali in stiva per "
	  						  						+ "passeggero e da 0 a 2 "
	  						  						+"bagagli speciali per passeggero."
	  						  						+'\n'+"Correggere le quantità dei "
	  						  						+ "bagagli da acquistare",
	  						  						"Errore Inserimento Dati",
	  						  						JOptionPane.WARNING_MESSAGE);
					  break;
				  case 1:
					  	frame8.dispose();
						frame9 = new JFrame("Assicurazione di Viaggio");
						frame9.setVisible(true);
						frame9.setSize(530,505);
					  
						JPanel panel9 = new JPanel();
						panel9.setLayout(null);
						frame9.add(panel9);	 	
					
						ImageIcon img3=new ImageIcon("src/prenotazioneItinerario/full.jpg");
						JLabel lblimg3=new JLabel(img3);
						panel9.add(lblimg3);
						check9 = new JCheckBox("Assicurazione Full-Cover (40 €)",true);
						panel9.add(check9);
						check9.addActionListener (new Full());
						ImageIcon img4=new ImageIcon("src/prenotazioneItinerario/compl.jpg");
						JLabel lblimg4=new JLabel(img4);
						panel9.add(lblimg4);
						check10 = new JCheckBox("Assicurazione Completly-Safe (30 €)",false);
						panel9.add(check10);	
						check10.addActionListener (new Complete());
						ImageIcon img5=new ImageIcon("src/prenotazioneItinerario/mini.jpg");
						JLabel lblimg5=new JLabel(img5);
						panel9.add(lblimg5);
						check11 = new JCheckBox("Assicurazione Mini (20 €)",false);
						panel9.add(check11);
						check11.addActionListener (new Mini());
						ImageIcon img6=new ImageIcon("src/prenotazioneItinerario/none.jpg");
						JLabel lblimg6=new JLabel(img6);
						panel9.add(lblimg6);
						check12 = new JCheckBox("Nessuna Assicurazione (0 €)",false);
						panel9.add(check12);
						check12.addActionListener (new None());
						
						panel9.add(button11);		 					
						button11.addActionListener (new Prenota3());
						
						lblimg3.setBounds(80, 20, 70, 70);
						check9.setBounds(170, 45, 300, 20);
						lblimg4.setBounds(80, 125, 70, 70);
						check10.setBounds(170, 150, 300, 20);
						lblimg5.setBounds(80, 230, 70, 70);
						check11.setBounds(170, 255, 300, 20);
						lblimg6.setBounds(80, 335, 70, 70);
						check12.setBounds(170, 360, 300, 20);
						button11.setBounds(150, 440, 200, 25);
						break;
				  }
			  }
			  
		  }
		}
	
	static class Prenota3 implements ActionListener {      
		  public void actionPerformed (ActionEvent e) { 
			
			  if (Sistema.getLogged()==false) {
				  JOptionPane.showMessageDialog(null,"Per procedere con la prenotazione "
						  						+"è necessario essere utenti registrati "
						  						+ "ed effeuuare il Login."+'\n'+"Eseguire "
						  						+ "l'autenticazione nella homepage."+'\n'
						  						+"Se non si è ancora iscritti è possibile "
						  						+ "effettuare la registrazione nella homepage."
						  						,"Autenticazione Necessaria",
						  						JOptionPane.INFORMATION_MESSAGE);
			  } else {
				  if (check9.isSelected()==true) {
					  Sistema.callPrenota3("Full-Covered");
			 		} else if (check10.isSelected()==true) {
			 			Sistema.callPrenota3("Completely-Safe");
			 		} else if (check11.isSelected()==true) {
			 			Sistema.callPrenota3("Mini");
			 		} else {
			 			Sistema.callPrenota3("Nessuna Assicurazione");
			 		}

				  	frame9.dispose();
				  	frame10 = new JFrame("Pagamento");
				  	frame10.setVisible(true);
				  	frame10.setSize(555,350);
					JPanel panel10 = new JPanel();
					panel10.setLayout(null);
					 
					frame10.add(panel10);
					
					JLabel lbltotale=new JLabel("Importo complessivo da pagare");
					panel10.add(lbltotale);
					JLabel lblprezzo=new JLabel("€ "+Sistema.getPrezzo());
					panel10.add(lblprezzo);
					 
					ImageIcon img7=new ImageIcon("src/prenotazioneItinerario/cc.jpg");
					JLabel lblimg7=new JLabel(img7);
					panel10.add(lblimg7);
					check13 = new JCheckBox("Carta di Credito",true);
					panel10.add(check13);			
					check13.addActionListener (new Window.Carta());
					ImageIcon img8=new ImageIcon("src/prenotazioneItinerario/pp.jpg");
					JLabel lblimg8=new JLabel(img8);
					panel10.add(lblimg8);
					check14 = new JCheckBox("PayPal",false);
					panel10.add(check14);
					check14.addActionListener (new Window.Pay_pal());
					lbltot=new JLabel("Importo totale prenotazione €");
					panel10.add(lbltot);
					lblprezzo=new JLabel(String.valueOf(Sistema.getPrezzo()));
					panel10.add(lblprezzo);
					lblnomepp=new JLabel("Nome Titolare");
					panel10.add(lblnomepp);
					txtnomepp=new JTextField();
					panel10.add(txtnomepp);
					lblcognomepp=new JLabel("Cognome Titolare");
					panel10.add(lblcognomepp);
					txtcognomepp=new JTextField();
					panel10.add(txtcognomepp);
					lblnumero=new JLabel("Numero Carta di Credito");
					panel10.add(lblnumero);
					txtnumero=new JTextField();
					panel10.add(txtnumero);
					lblscadenza=new JLabel("Data Scadenza (MM/AA)");
					panel10.add(lblscadenza);
					txtscadenza=new JTextField();
					panel10.add(txtscadenza);
					lblcodice=new JLabel("Codice di Sicurezza");
					panel10.add(lblcodice);
					txtcodice=new JTextField();
					panel10.add(txtcodice);
					lblmailpp=new JLabel("Indirizzo E-mail");
					panel10.add(lblmailpp);
					txtmailpp=new JTextField();
					panel10.add(txtmailpp);	
					lblpasswordpp=new JLabel("Password Account PayPal");
					panel10.add(lblpasswordpp);
					txtpasswordpp=new JPasswordField();
					panel10.add(txtpasswordpp);					 
					
					panel10.add(button12);		 					
					button12.addActionListener (new Prenota4());
	 				
					lblmailpp.setVisible(false);
					txtmailpp.setVisible(false);
					lblpasswordpp.setVisible(false);
					txtpasswordpp.setVisible(false);
					 
					lblimg7.setBounds(10,10,100,70);
					check13.setBounds(130,35,150,20);
					lblimg8.setBounds(350,10,100,70);
					check14.setBounds(470,35,150,20);
					lbltot.setBounds(140, 90, 250, 20);
					lblprezzo.setBounds(370, 90, 100, 20);
					lblnomepp.setBounds(40, 115, 200, 15);
					txtnomepp.setBounds(40, 135, 200,20);
					lblcognomepp.setBounds(320, 115, 200, 15);
					txtcognomepp.setBounds(320, 135, 200,20);
					lblnumero.setBounds(191, 170, 200, 15);
					txtnumero.setBounds(191, 190, 171,20);
					lblscadenza.setBounds(55, 225, 200,15);
					txtscadenza.setBounds(55, 245, 50, 20);
					lblcodice.setBounds(362, 225, 150,15);
					txtcodice.setBounds(362, 245, 40, 20);
					lblmailpp.setBounds(40, 170, 200, 15);
					txtmailpp.setBounds(40, 190, 200,20);
					lblpasswordpp.setBounds(320, 170, 200, 15);
					txtpasswordpp.setBounds(320, 190, 200, 20);
					button12.setBounds(177, 290, 200, 20);
			  }
		  }
		}
	
	static class Prenota4 implements ActionListener {    
		  @SuppressWarnings("deprecation")
		public void actionPerformed (ActionEvent e) {
			 if (Sistema.getLogged()==false) {
				 JOptionPane.showMessageDialog(null,"Per procedere con la prenotazione "
	  						+"è necessario essere utenti registrati "
	  						+ "ed effeuuare il Login."+'\n'+"Eseguire "
	  						+ "l'autenticazione nella homepage."+'\n'
	  						+"Se non si è ancora iscritti è possibile "
	  						+ "effettuare la registrazione nella homepage."
	  						,"Autenticazione Necessaria",
	  						JOptionPane.INFORMATION_MESSAGE);
			 } else {
			  	if (Sistema.getCarta()) {
			  		CartaDiCredito c=new CartaDiCredito();					
			  		c.setNomeIntestatario(txtnomepp.getText());
			  		c.setCognomeIntestatario(txtcognomepp.getText());
			  		c.setStrnumero(txtnumero.getText());
			  		c.setScadenza(txtscadenza.getText());
				  	c.setStrcodice(txtcodice.getText());
					
				  	Integer lg=Sistema.callPrenota4(c);
				  	
				  	switch (lg) {
				  	case -1:
				  		JOptionPane.showMessageDialog(null,"Compilare correttamente i campi "
								  					  +"per il pagamento con carta di credito:"
								  					  +'\n'+ "- Nome e Cognome"+"del titolare "
								  					  + "della carta di credito devono essere "
								  					  + "stringhe di caratteri"+'\n'+"- Il "
								  					  + "numero della carta deve essere di almeno"
								  					  + " 14 cifre"+'\n'+"- La scadenza deve "
								  					  + "essere nel formato MM/AA"+'\n'+"- Il "
								  					  + "codice di sicurezza deve essere un "
								  					  +"numero di 3 cifre","Errore Inserimento Dati",
								  					  JOptionPane.WARNING_MESSAGE);
				  		break;
				  	case 0:
				  		JOptionPane.showMessageDialog(null,"Compilare correttamente i campi "
		  						  					  +"per il pagamento con carta di credito:"
		  						  					  +'\n'+ "- Nome e Cognome del titolare "
		  						  					  + "della carta di credito devono essere stringhe "
		  						  					  + "di caratteri"+'\n'+"- Il numero della carta "
		  						  					  + "deve essere di 14, 15 o 16 cifre"+'\n'+"- La "
		  						  					  + "scadenza deve essere nel formato "
		  						  					  +"MM/AA"+'\n'+"- Il codice di sicurezza deve essere un "
		  						  					  +"numero di 3 cifre","Errore Inserimento Dati",
		  						  					  JOptionPane.WARNING_MESSAGE);
				  		break;
				  	case 2:
				  		JOptionPane.showMessageDialog(null,"Inserire una data di scadenza "
								  					  +"valida","Errore Inserimento Dati",
								  					  JOptionPane.WARNING_MESSAGE);
				  		break;
				  	case 3:				  		
				  		if (Sistema.salvaPrenotazione(Sistema.table2, table3, Sistema.model2, model3)) {
										  		
				  		frame5.dispose();
				  	    frame6.dispose();
				  	    frame10.dispose();
				  	     
				  	    JOptionPane.showMessageDialog(null,"La prenotazione è avvenuta con "
				  			  						  +"successo!"+'\n'+ "Il "
				  			  						  + "riepilogo dell'itinerario completo "
				  			  						  + "è stato inviato al tuo indirizzo "
				  			  						  + "e-mail"+'\n'+"BUON VIAGGIO!!",
				  			  						  "Conferma Prenotazione",
				  			  						  JOptionPane.INFORMATION_MESSAGE);
				  		} else {
				  			JOptionPane.showMessageDialog(null,"Errore tecnico, ripetere le oerazioni",
													  	  "ERRORE DI SISTEMA",JOptionPane.WARNING_MESSAGE);
				  		}
				  		break;				  		
				  	}
			  	} else {
			  		Paypal p=new Paypal();					
			  		p.setEmail(txtmailpp.getText());
			  		p.setPasswordConto(txtpasswordpp.getText());
					
			  		Integer lg=Sistema.callPrenota4(p);
			  		
			  		switch (lg) {
			  		case 1:
			  			JOptionPane.showMessageDialog(null,"Compilare correttamente i campi "
								  					  +"per il pagamento con Account Paypal:"
								  					  +'\n'+ "- L'indirizza E-mail deve essere"
								  					  + " un indirizzo mail valido"+'\n'
								  					  +"- Il campo Password deve contenere la "
								  					  + "stringa di caratteri esattamente "
								  					  + "corrispondente alla password del "
								  					  + "account PayPal","Errore Inserimento "
								  					  + "Dati",JOptionPane.WARNING_MESSAGE);
			  			break;
			  		case 3:
			  				Sistema.salvaPrenotazione(Sistema.table2, table3, Sistema.model2, model3);
						
				  		frame5.dispose();
				  	    frame6.dispose();
				  	    frame10.dispose();
				  	     
				  	    JOptionPane.showMessageDialog(null,"La prenotazione è avvenuta con "
				  			  						  +"successo!"+'\n'+"Il "
				  			  						  + "riepilogo dell'itinerario completo "
				  			  						  + "è stato inviato al tuo indirizzo "
				  			  						  + "e-mail"+'\n'+"BUON VIAGGIO!!",
				  			  						  "Conferma Prenotazione",
				  			  						  JOptionPane.INFORMATION_MESSAGE);
			  			break;
			  		}
			  	}
		  	}
		}
	}
	
	static class creaFrame4 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
		  JFrame frame4 = new JFrame("Recensione");
		  frame4.setVisible(true);
		  frame4.setSize(500,450);
		  
		  JPanel panel4 = new JPanel();
		  panel4.setLayout(null);
		  frame4.add(panel4);
		  
		  JLabel lbltitolo=new JLabel("Titolo");
		  panel4.add(lbltitolo);
		  txttitolo=new JTextField();
		  panel4.add(txttitolo);
		  JLabel lblambito=new JLabel("Ambito");
		  panel4.add(lblambito);
		  txtambito=new JTextField();
		  panel4.add(txtambito);
		  JLabel lbltesto=new JLabel("Testo Recensione");
		  panel4.add(lbltesto);
		  txttesto=new JTextArea();
		  panel4.add(txttesto);
		  txttesto.setLineWrap(true);
		  txttesto.setBackground(Color.CYAN);
		  JLabel lblvalutazione=new JLabel("Valutazione [0 - 5]");
		  panel4.add(lblvalutazione);
		  txtvalutazione=new JTextField();
		  panel4.add(txtvalutazione);
		  
		  button7 = new JButton("Carica Feedback");
		  panel4.add(button7);
		  button7.addActionListener (new caricaFeedback());
		  
		  lbltitolo.setBounds(10,10,100,15);
		  txttitolo.setBounds(10,30,480,20);
		  lblambito.setBounds(10,65,100,15);
		  txtambito.setBounds(10,85,400,20);
		  lblvalutazione.setBounds(10,120,150,15);
		  txtvalutazione.setBounds(10,140,25,20);
		  lbltesto.setBounds(10,175,150,15);
		  txttesto.setBounds(10,195,480,160);
		  button7.setBounds(150,380,200,25);	  
	  	}
	 }

	static class caricaFeedback implements ActionListener {
		public void actionPerformed (ActionEvent e) {
		  Recensione feedback=new Recensione();
		  
			  feedback.setTitolo(txttitolo.getText());
			  feedback.setAmbito(txtambito.getText());
			  feedback.setTesto(txttesto.getText());
			  feedback.setStrvalutazione(txtvalutazione.getText());
		  	  
			  Integer lg=Sistema.scriviRecensione(feedback);			
			  
			  switch (lg) {
			  case -2:
				  JOptionPane.showMessageDialog(null,"Compilare correttamente "
						  						+"tutti i campi"+'\n'+"- Titolo, "
						  						+ "Ambito e testo non devono "
						  						+ "essere lasciati vuoti."+'\n'
						  						+"- La Valutazione deve essere "
						  						+ "indicata con un numero compreso "
						  						+ "tra 0 e 5","Inserimento dati "
						  						+ "non corretto",JOptionPane.WARNING_MESSAGE);
				  break;
			  case -1:
				  JOptionPane.showMessageDialog(null,"La valutazionen deve essere un numero compreso "
						  						+"tra 0 e 5","Inserimento dati non corretto1",
						  						JOptionPane.WARNING_MESSAGE);
				  break;
			  default:
				  feedback.setValutazione(lg);
				  
					if (Sistema.salvaRecensione(feedback)) {
					  
					  JOptionPane.showMessageDialog(null,"Feedback inserito "
							  						+"correttamente","Feedback Salvato",
							  						JOptionPane.INFORMATION_MESSAGE);
					  } else {
						  JOptionPane.showMessageDialog(null,"Errore tecnico, ripetere le oerazioni",
									  					"ERRORE DI SISTEMA",JOptionPane.WARNING_MESSAGE); 
					  }				
				  break;
			  }	 
		}		  
	}

	
	public static void main (String[] args) {   
	  Sistema.getCriteri().setSoloAndata(true);
	  
	  frame = new JFrame("GG Fly&Dream");
	  frame.setVisible(true);
	  frame.setSize(740,625);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  JPanel panel = new JPanel();
	  panel.setLayout(null);
	  frame.add(panel);
	  
	  ImageIcon img1=new ImageIcon("src/prenotazioneItinerario/img1.jpg");
	  JLabel lblimg1=new JLabel(img1);
	  panel.add(lblimg1);	  
	  ImageIcon img2=new ImageIcon("src/prenotazioneItinerario/img2.jpg");
	  JLabel lblimg2=new JLabel(img2);
	  panel.add(lblimg2);  
	  lblusername=new JLabel("Username");
	  panel.add(lblusername);
	  txtusername=new JTextField();
	  panel.add(txtusername);
	  lblpassword=new JLabel("Password");
	  panel.add(lblpassword);
	  txtpassword=new JPasswordField();
	  panel.add(txtpassword);
	  JLabel lblorigine=new JLabel("Aeroporto Partrenza");
	  panel.add(lblorigine);
	  txtorigine=new JTextField();
	  panel.add(txtorigine);
	  JLabel lbldestinazione=new JLabel("Aeroporto Destinazione");
	  panel.add(lbldestinazione);
	  txtdestinazione=new JTextField();
	  panel.add(txtdestinazione);
	  JLabel lbldatapartenza=new JLabel("Data Partenza");
	  panel.add(lbldatapartenza);
	  JLabel lblgiornopartenza=new JLabel("gg");
	  panel.add(lblgiornopartenza);
	  txtgiornopartenza=new JTextField();
	  panel.add(txtgiornopartenza);
	  txtgiornopartenza.setText("10");
	  JLabel lblmesepartenza=new JLabel("mm");
	  panel.add(lblmesepartenza);
	  txtmesepartenza=new JTextField();
	  panel.add(txtmesepartenza);
	  txtmesepartenza.setText("11");
	  JLabel lblannopartenza=new JLabel("aaaa");
	  panel.add(lblannopartenza);
	  txtannopartenza=new JTextField();
	  panel.add(txtannopartenza);
	  txtannopartenza.setText("2017");
	  lbldataritorno=new JLabel("Data Ritorno");
	  panel.add(lbldataritorno);
	  lblgiornoritorno=new JLabel("gg");
	  panel.add(lblgiornoritorno);
	  txtgiornoritorno=new JTextField();
	  panel.add(txtgiornoritorno);
	  lblmeseritorno=new JLabel("mm");
	  panel.add(lblmeseritorno);
	  txtmeseritorno=new JTextField();
	  panel.add(txtmeseritorno);
	  lblannoritorno=new JLabel("aaaa");
	  panel.add(lblannoritorno);
	  txtannoritorno=new JTextField();
	  panel.add(txtannoritorno);
	  JLabel lblnadulti=new JLabel("N° Adulti");
	  panel.add(lblnadulti);
	  txtnumadulti=new JTextField();
	  panel.add(txtnumadulti);
	  txtnumadulti.setText("1");
	  JLabel lblnbambini=new JLabel("N° Bambini");
	  panel.add(lblnbambini);
	  txtnumbambini=new JTextField();
	  panel.add(txtnumbambini);
	  txtnumbambini.setText("0");	  
	  check1 = new JCheckBox("Economy",true);
	  panel.add(check1);
	  check1.addActionListener (new Economy()); 
	  check2 = new JCheckBox("Business",false);
	  panel.add(check2);
	  check2.addActionListener (new Business()); 
	  check3 = new JCheckBox("Solo Andata",true);
	  panel.add(check3);
	  check3.addActionListener (new Andata());	  
	  
	  panel.add(button);
	  button.addActionListener (new Ricerca());
	  button2 = new JButton("Login");
	  panel.add(button2);
	  button2.addActionListener (new Login());	  
	  button3 = new JButton("Registrati");
	  panel.add(button3);
	  button3.addActionListener (new creaFrame2());	  
	  button6 = new JButton("Scrivi Commento");
	  panel.add(button6);
	  button6.addActionListener (new creaFrame4());
	  button13 =new JButton();
	  panel.add(button13);
	  button13.addActionListener (new Logout());	  
	  	  
	  lblimg1.setBounds(10,5,720,160);
	  
	  lblimg2.setBounds(256,200,258,315);	    
	  lblorigine.setBounds(10,180,200,15);
	  txtorigine.setBounds(10,200,200,20);
	  lbldestinazione.setBounds(10,235,200,15);
	  txtdestinazione.setBounds(10,255,200,20);
	  check3.setBounds(10,290,150,20);
	  lbldatapartenza.setBounds(10,325,150,15);
	  lblgiornopartenza.setBounds(10,345,50,15);
	  lblmesepartenza.setBounds(40,345,50,15);
	  lblannopartenza.setBounds(70,345,50,15);
	  txtgiornopartenza.setBounds(10,365,22,20);
	  txtmesepartenza.setBounds(40,365,22,20);
	  txtannopartenza.setBounds(70,365,40,20);	  
	  lbldataritorno.setBounds(10,400,150,15);
	  lblgiornoritorno.setBounds(10,420,50,15);
	  lblmeseritorno.setBounds(40,420,50,15);
	  lblannoritorno.setBounds(70,420,50,15);
	  txtgiornoritorno.setBounds(10,440,22,20);
	  txtmeseritorno.setBounds(40,440,22,20);
	  txtannoritorno.setBounds(70,440,40,20);
	  lblnadulti.setBounds(10,475,70,15);
	  txtnumadulti.setBounds(10,495,30,20);
	  lblnbambini.setBounds(90,475,100,15);
	  txtnumbambini.setBounds(90,495,30,20);
	  check1.setBounds(10,530,100,20);
	  check2.setBounds(110,530,100,20);
	  button.setBounds(10,560,200,25);
	  
	  lbldataritorno.setForeground(Color.GRAY);
	  lblgiornoritorno.setForeground(Color.GRAY);
	  lblmeseritorno.setForeground(Color.GRAY);
	  lblannoritorno.setForeground(Color.GRAY);
	  txtgiornoritorno.setText("");
	  txtmeseritorno.setText("");
	  txtannoritorno.setText("");
	  txtgiornoritorno.setEditable(false);
	  txtmeseritorno.setEditable(false);
	  txtannoritorno.setEditable(false);
	  
	  lblusername.setBounds(580,280,100,15);
	  txtusername.setBounds(580,300,150,20);
	  lblpassword.setBounds(580,335,100,15);
	  txtpassword.setBounds(580,355,150,20);
	  button2.setBounds(580,390,150,25);
	  button3.setBounds(580,425,150,25);
	  button6.setBounds(560,368,170,25);
	  button13.setBounds(560,200,170,20);
	  button6.setVisible(false);
	  button13.setVisible(false);	  
	}
  }