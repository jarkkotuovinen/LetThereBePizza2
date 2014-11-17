import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.io.IOException;

public class LetThereBePizza
		extends 	JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private		JTabbedPane tabbedPane;
	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;
	public JMenuBar menuBar;
	public JMenuItem menuItem;
	public JMenuItem aboutItem;
	public JMenuItem exitItem;

	
	// lihapizzat
	private JCheckBox QuattroStaggioni = new JCheckBox("Quattro staggioni (kinkku,ananas,aurajuusto) 7€");
	private JCheckBox KebabPizza = new JCheckBox("Kebabpizza (kebab,jalapeno) 7€");
	private JCheckBox SalamiPizza = new JCheckBox("Salamipizza (salami,jalapeno) 7€");
	private JCheckBox Pollo = new JCheckBox("Pollo (kana, aurajuusto, feta) 7€");
	private JCheckBox Pekoni = new JCheckBox("Pekonipizza (pekoni, kananmuna) 7€");
	private JCheckBox TuttiFrutti = new JCheckBox("Tutti Frutti (pekoni,salami,palvikinkku) 7€");
	
	//vegepizzat
	private JCheckBox TomaattiPizza = new JCheckBox("Tomaattipizza (tomaatti,ketsuppi,chili) 7€");
	private JCheckBox JuustoPizza = new JCheckBox("Juustopizza (cheddar,edam,mozzarella) 7€");
	private JCheckBox SoijaPizza = new JCheckBox("Soijapizza (tomaatti,soija) 7€");
	private JCheckBox SalaattiPizza = new JCheckBox("Salaattipizza (tomaatti,kurkku,salaatti) 7€");
	private JCheckBox PorkkanaPizza = new JCheckBox("Porkkanapizza (tomaatti,mozzarella,porkkana) 7€");
	private JCheckBox PerunaPizza = new JCheckBox("Perunapizza(ranskalaiset,sipsi,tomaatti) 7€");

	
	JTextField textFieldSum = new JTextField(10);
	JTextField textFieldSum2 = new JTextField(10);
	JTextField textFieldSum3 = new JTextField("7");
	JTextArea pizzatSum = new JTextArea();
	JTextArea pizzatSum2 = new JTextArea();
	
    JTextField nimi = new JTextField();
    JTextField nimi2 = new JTextField();
    JTextField nimi3 = new JTextField();
    JTextField osoite = new JTextField();
    JTextField osoite2 = new JTextField();
    JTextField osoite3 = new JTextField();
    String[] juomat = { "Cola", "Fanta", "Sprite", "Jaffa", "Pepsi" };
    String[] mausteet = { "Kebab", "Jauheliha", "Ananas", "Mozzarella", "Tonnikala", "Kananmuna", "Porkkana", "Feta", "Kinkku", "Aurajuusto", "Salami" };
    JComboBox cb = new JComboBox(juomat);
    JComboBox cb2 = new JComboBox(juomat);
    JComboBox cbj = new JComboBox(juomat);
    JComboBox cb3 = new JComboBox(mausteet);
    JComboBox cb4 = new JComboBox(mausteet);
    JComboBox cb5 = new JComboBox(mausteet);
    JComboBox cb6 = new JComboBox(mausteet);

	private int sum = 0;	// sum of lihapizzas
	private int sum2 = 0;	// sum of vegepizzas
    private String quattropizza = "";
    private String kebabpizza = "";
    private String salamipizza = "";
    private String pollopizza = "";
    private String pekonipizza = "";
    private String tuttifruttipizza = "";
    private String tomaattipizza = "";
    private String juustopizza = "";
    private String soijapizza = "";
    private String salaattipizza = "";
    private String porkkanapizza = "";
    private String perunapizza = "";
    
	public LetThereBePizza()
	{
		// Splash screen
		
		setTitle("LetThereBePizza");
		setSize( 800, 600 );
		setBackground( Color.white );
		
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon ("images/PizzaMaster.gif"), SwingConstants.CENTER));
		window.setSize(800, 600 );
		window.setBackground(Color.blue);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		
		// Layout
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();

	    // Create a menu bar and give it a bevel border.
	    menuBar = new JMenuBar();
	    menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

	    // Create a menu and add it to the menu bar.
	    JMenu menu = new JMenu("LetThereBePizza");
	    menuBar.add(menu);
	    JMenu help = new JMenu("Apua");
	    menuBar.add(help);

			    
	    // A group of JMenuItems
	    menuItem = new JMenuItem("Tilausapuri");
	    help.add(menuItem);
	    aboutItem = new JMenuItem("Tietoja LetThereBePizzasta");
	    menu.add(aboutItem);
	    exitItem = new JMenuItem("Poistu");
	    menu.add(exitItem);
	    
	    menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog((Component)e.getSource(),
    		    "Näin tilaat tuotteita LetThereBePizzan avulla:" + "\n" +"1. Valitse välilehdistä (Liha Pizza, Vege Pizza, Oma Valinta) haluamasi tuotetyyppi" + "\n" +"2. Syötä yhteystietosi niille tarkoitettuihin kenttiin" +"\n" + "3. Valitse haluamasi tuotteet" + "\n" + "4. Paina Tilaa -paineketta" + "\n" + "5. Varmista tilaus" + "\n" + "6. Nauti!",
            	"Tilausapuri",
            	JOptionPane.PLAIN_MESSAGE);
            }
        });
	    
	    aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog((Component)e.getSource(),
            		    "Copyright © 2014 LetThereBePizza Oy" +"\n" + "Versio 1.0",
            		    "LetThereBePizza",
            		    JOptionPane.PLAIN_MESSAGE);
            }
        });
	    
	    exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Liha Pizza", panel1 );
		tabbedPane.addTab( "Vege Pizza", panel2 );
		tabbedPane.addTab( "Oma Valinta", panel3 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}
	
	// Page 1
	public void createPage1()
	{
		// Layout
		panel1 = new JPanel();
		panel1.setLayout( new GridLayout( 0, 2 ) );

		// Contact info
		panel1.add( new JLabel( "Nimi (etunimi, sukunimi):" ) );
		panel1.add( nimi );
		nimi.addActionListener(this);
	    nimi.getText();

		panel1.add( new JLabel( "Osoite:" ) );
		panel1.add( osoite);
		osoite.addActionListener(this);
	    osoite.getText();
		
		panel1.add( new JLabel( "Puhelinnumero:" ) );
		panel1.add( new JTextField() );

	    // Check boxes   
		panel1.add(QuattroStaggioni);
		panel1.add(KebabPizza);
		panel1.add(Pollo);
	    panel1.add(SalamiPizza);
	    panel1.add(Pekoni);
	    panel1.add(TuttiFrutti);
		panel1.add( new JLabel( "Juoma (kuuluu hintaan):" ) );
		panel1.add( cb);
		cb.addActionListener(this);
		cb.getSelectedItem(); 
		
		// Add action listener for the check boxes
		ActionListener actionListener = new ActionHandler(); 
		QuattroStaggioni.addActionListener(actionListener);
		KebabPizza.addActionListener(actionListener);
		SalamiPizza.addActionListener(actionListener);
		Pollo.addActionListener(actionListener);
		Pekoni.addActionListener(actionListener);
		TuttiFrutti.addActionListener(actionListener);
		
		// Pizza price sum
		final JLabel labelSum = new JLabel("Kokonaishinta (€): ");
		panel1.add(labelSum);
		textFieldSum.setEditable(false);
		panel1.add(textFieldSum);
		textFieldSum.getText();
		
		// Tilaa button
	      JButton TilaaButton = new JButton("Tilaa");          
	          TilaaButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  Object[] options = {"Kyllä",
                  "Ei"};
	              int result = JOptionPane.showOptionDialog(
	            		    (Component)e.getSource(),
	            		    "Arvon " + nimi.getText() + "\n" + "Haluatteko varmasti tilata seuraavat herkut?"+ "\n" + "Pizza(t):"+ pizzatSum.getText() + "\n" + "Juoma: "+ cb.getSelectedItem() + "\n" + "Osoitteeseen: " + osoite.getText() + "\n" + "Yhteishintaan: "+ textFieldSum.getText() + " €",
	            		    "Tilauksen varmistus",
	            		    JOptionPane.YES_NO_OPTION,
	            		    JOptionPane.QUESTION_MESSAGE,
	            		    null,
	              			options,
	              			options[0]);
	              if (result == JOptionPane.YES_OPTION) {
		        	  JOptionPane.showMessageDialog( (Component)e.getSource(), "Kiitos tilauksestanne! " + nimi.getText() + "\n" + "Pizzanne toimitetaan osoitteeseen: " + osoite.getText() ,"Tilausvahvistus", JOptionPane.PLAIN_MESSAGE);
	              } 
	          }          
	       });
	     
	    //Peruuta button
		      JButton PeruutaButton = new JButton("Poistu");
	          PeruutaButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {

		        	  Object[] options = {"Kyllä",
	                    "Ei"};
		              int result = JOptionPane.showOptionDialog(
		            		    (Component)e.getSource(),
		            		    "Haluatteko varmasti poistua pizzantilauksesta?",
		            		    "Poistu pizzan tilauksesta",
		            		    JOptionPane.YES_NO_OPTION,
		            		    JOptionPane.QUESTION_MESSAGE,
		            		    null,
		              			options,
		              			options[0]);
		              if (result == JOptionPane.YES_OPTION) {
		                System.exit(0);
		              } 
		        }});

	    panel1.add(TilaaButton);
	    panel1.add(PeruutaButton);
	}
	
	// Page 2

	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new GridLayout( 0, 2 ) );
		
		// Contact info
		
		panel2.add( new JLabel( "Nimi (etunimi, sukunimi):" ) );
		panel2.add( nimi2 );
		nimi2.addActionListener(this);
	    nimi2.getText();

		panel2.add( new JLabel( "Osoite:" ) );
		panel2.add( osoite2);
		osoite2.addActionListener(this);
	    osoite2.getText();
		
		panel2.add( new JLabel( "Puhelinnumero:" ) );
		panel2.add(new JTextField() );

		
		panel2.add(TomaattiPizza);
		panel2.add(JuustoPizza);
		panel2.add(SoijaPizza);
	    panel2.add(SalaattiPizza);
	    panel2.add(PorkkanaPizza);
	    panel2.add(PerunaPizza);
		panel2.add( new JLabel( "Juoma (kuuluu hintaan):" ) );
		panel2.add( cb2);
		cb2.addActionListener(this);
		cb2.getSelectedItem(); 

		// Add action listener for the check boxes
		ActionListener actionListener = new ActionHandler(); 
		TomaattiPizza.addActionListener(actionListener);
		JuustoPizza.addActionListener(actionListener);
		SoijaPizza.addActionListener(actionListener);
		SalaattiPizza.addActionListener(actionListener);
		PorkkanaPizza.addActionListener(actionListener);
		PerunaPizza.addActionListener(actionListener);
		
		// Pizza price sum
		final JLabel labelSum = new JLabel("Kokonaishinta (€): ");
		panel2.add(labelSum);
		textFieldSum2.setEditable(false);
		panel2.add(textFieldSum2);
		textFieldSum2.getText();	
		
		// Tilaa button
	      JButton TilaaButton2 = new JButton("Tilaa");          
	          TilaaButton2.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  Object[] options = {"Kyllä",
                  "Ei"};
	              int result = JOptionPane.showOptionDialog(
	            		    (Component)e.getSource(),
	            		    "Arvon " + nimi2.getText() + "\n" + "Haluatteko varmasti tilata seuraavat herkut?"+ "\n" + "Pizza(t):"+ pizzatSum2.getText() + "\n" + "Juoma: "+ cb2.getSelectedItem() + "\n" + "Osoitteeseen: " + osoite2.getText() + "\n" + "Yhteishintaan: "+ textFieldSum2.getText() + " €",
	            		    "Tilauksen varmistus",
	            		    JOptionPane.YES_NO_OPTION,
	            		    JOptionPane.QUESTION_MESSAGE,
	            		    null,
	              			options,
	              			options[0]);
	              if (result == JOptionPane.YES_OPTION) {
		        	  JOptionPane.showMessageDialog( (Component)e.getSource(), "Kiitos tilauksestanne! " + nimi2.getText() + "\n" + "Pizzanne toimitetaan osoitteeseen: " + osoite2.getText() ,"Tilausvahvistus", JOptionPane.PLAIN_MESSAGE);
	              } 
	          }          
	       });
	     
	    //Peruuta button
		      JButton PeruutaButton2 = new JButton("Poistu");
	          PeruutaButton2.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {

		        	  Object[] options = {"Kyllä",
	                    "Ei"};
		              int result = JOptionPane.showOptionDialog(
		            		    (Component)e.getSource(),
		            		    "Haluatteko varmasti poistua pizzantilauksesta?",
		            		    "Poistu pizzan tilauksesta",
		            		    JOptionPane.YES_NO_OPTION,
		            		    JOptionPane.QUESTION_MESSAGE,
		            		    null,
		              			options,
		              			options[0]);
		              if (result == JOptionPane.YES_OPTION) {
		                System.exit(0);
		              } 
		        }});

	    panel2.add(TilaaButton2);
	    panel2.add(PeruutaButton2);

	}
	
	// Page 3

	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout( new GridLayout( 0, 2 ) );

		panel3.add( new JLabel( "Nimi (etunimi, sukunimi):" ) );
		panel3.add( nimi3 );
		nimi3.addActionListener(this);
	    nimi3.getText();

		panel3.add( new JLabel( "Osoite:" ) );
		panel3.add( osoite3);
		osoite3.addActionListener(this);
		osoite3.getText();
		
	    panel3.add( new JLabel( "Puhelinnumero:" ) );
	    panel3.add(new JTextField() );
		
		panel3.add( new JLabel( "Mauste 1" ) );
		panel3.add( cb3);
		cb3.addActionListener(this);
		cb3.getSelectedItem(); 
		
		panel3.add( new JLabel( "Mauste 2" ) );
		panel3.add( cb4);
		cb4.addActionListener(this);
		cb4.getSelectedItem(); 
		
		panel3.add( new JLabel( "Mauste 3" ) );
		panel3.add( cb5);
		cb5.addActionListener(this);
		cb5.getSelectedItem(); 
		
		panel3.add( new JLabel( "Mauste 4" ) );
		panel3.add( cb6);
		cb6.addActionListener(this);
		cb6.getSelectedItem(); 
		
		panel3.add( new JLabel( "Juoma (kuuluu hintaan):" ) );
		panel3.add( cbj);
		cbj.addActionListener(this);
		cbj.getSelectedItem(); 
		
		// Pizza price sum
		final JLabel labelSum = new JLabel("Kokonaishinta (€): ");
		panel3.add(labelSum);
		textFieldSum3.setEditable(false);
		panel3.add(textFieldSum3);
		textFieldSum3.getText();	
		
	      JButton TilaaButton3 = new JButton("Tilaa");          
          TilaaButton3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  
        	  Object[] options = {"Kyllä",
              "Ei"};
              int result = JOptionPane.showOptionDialog(
            		    (Component)e.getSource(),
            		    "Arvon " + nimi3.getText() + "\n" + "Haluatteko varmasti tilata seuraavat herkut?"+ "\n" + "Pizza seuraavilla mausteilla:" + " "+ cb3.getSelectedItem() + ", " + cb4.getSelectedItem() + ", " + cb5.getSelectedItem() + ", " + cb6.getSelectedItem() + "\n" + "Juoma: "+ cbj.getSelectedItem() + "\n" + "Osoitteeseen: " + osoite3.getText() + "\n" + "Yhteishintaan: "+ textFieldSum3.getText() + " €",
            		    "Tilauksen varmistus",
            		    JOptionPane.YES_NO_OPTION,
            		    JOptionPane.QUESTION_MESSAGE,
            		    null,
              			options,
              			options[0]);
              if (result == JOptionPane.YES_OPTION) {
	        	  JOptionPane.showMessageDialog( (Component)e.getSource(), "Kiitos tilauksestanne! " + nimi3.getText() + "\n" + "Pizzanne toimitetaan osoitteeseen: " + osoite3.getText() ,"Tilausvahvistus", JOptionPane.PLAIN_MESSAGE);
              } 
          }          
       });
  	    //Peruuta button
	      JButton PeruutaButton3 = new JButton("Poistu");
          PeruutaButton3.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {

	        	  Object[] options = {"Kyllä",
                    "Ei"};
	              int result = JOptionPane.showOptionDialog(
	            		    (Component)e.getSource(),
	            		    "Haluatteko varmasti poistua pizzantilauksesta?",
	            		    "Poistu pizzan tilauksesta",
	            		    JOptionPane.YES_NO_OPTION,
	            		    JOptionPane.QUESTION_MESSAGE,
	            		    null,
	              			options,
	              			options[0]);
	              if (result == JOptionPane.YES_OPTION) {
	                System.exit(0);
	              } 
	        }});
          
          panel3.add(TilaaButton3);
          panel3.add(PeruutaButton3);

	}

    // Main method 
	public static void main( String args[] )
	{
		// Create an instance of the test application
	       //Create and set up the content pane.
		LetThereBePizza mainFrame = new LetThereBePizza();
	    // mainFrame.setJMenubar(mainFrame.createMenuBar());
	    mainFrame.setJMenuBar(mainFrame.menuBar);

		mainFrame.setVisible( true );
	}
		
	// Pizza calculator
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (checkbox.isSelected()) {
				if (checkbox == QuattroStaggioni) {
					sum += 7;
					quattropizza = "\n" + " Quattro staggioni (kinkku,ananas,aurajuusto) 7€";
				} else if (checkbox == KebabPizza) {
					sum += 7;
					kebabpizza = "\n" + " Kebabpizza (kebab,jalapeno) 7€";
				} else if (checkbox == SalamiPizza) {
					sum += 7;
					salamipizza = "\n" + " Salamipizza (salami,jalapeno) 7€";
				}
				else if (checkbox == Pollo) {
					sum += 7;
					pollopizza = "\n" + " Pollo (kana, aurajuusto, feta) 7€";
				}
				else if (checkbox == Pekoni) {
					sum += 7;
					pekonipizza = "\n" + " Pekonipizza (pekoni, kananmuna) 7€";
				}
				else if (checkbox == TuttiFrutti) {
					sum += 7;
					tuttifruttipizza = "\n" + " Tutti Frutti (pekoni,salami,palvikinkku) 7€";
				}
				else if (checkbox == TomaattiPizza) {
					sum2 += 7;
					tomaattipizza = "\n" + " Tomaattipizza (tomaatti,ketsuppi,chili) 7€";
				} else if (checkbox == JuustoPizza) {
					sum2 += 7;
					juustopizza = "\n" + " Juustopizza (cheddar,edam,mozzarella) 7€";
				} else if (checkbox == SoijaPizza) {
					sum2 += 7;
					soijapizza = "\n" + " Soijapizza (tomaatti,soija) 7€";
				}
				else if (checkbox == SalaattiPizza) {
					sum2 += 7;
					salaattipizza = "\n" + " Salaattipizza (tomaatti, kurkku, salaatti) 7€";
				}
				else if (checkbox == PorkkanaPizza) {
					sum2 += 7;
					porkkanapizza = "\n" + " Porkkanapizza (tomaatti, mozzarella, porkkana) 7€";
				}
				else if (checkbox == PerunaPizza) {
					sum2 += 7;
					perunapizza = "\n" + " Perunapizza (ranskalaiset,sipsi,tomaatti) 7€";
				}
				
			} else {
				if (checkbox == QuattroStaggioni) {
					sum -= 7;
					quattropizza = "";
				} else if (checkbox == KebabPizza) {
					sum -= 7;
					kebabpizza = "";
				} else if (checkbox == SalamiPizza) {
					sum -= 7;
					salamipizza = "";
				}
				else if (checkbox == Pollo) {
					sum -= 7;
					pollopizza = "";
				}
				else if (checkbox == Pekoni) {
					sum -= 7;
					pekonipizza = "";
				}
				else if (checkbox == TuttiFrutti) {
					sum -= 7;
					tuttifruttipizza = "";
				}
				if (checkbox == TomaattiPizza) {
					sum2 -= 7;
					tomaattipizza = "";
				} else if (checkbox == JuustoPizza) {
					sum2 -= 7;
					juustopizza = "";
				} else if (checkbox == SoijaPizza) {
					sum2 -= 7;
					soijapizza = "";
				}
				else if (checkbox == SalaattiPizza) {
					sum2 -= 7;
					salaattipizza = "";
				}
				else if (checkbox == PorkkanaPizza) {
					sum2 -= 7;
					porkkanapizza = "";
				}
				else if (checkbox == PerunaPizza) {
					sum2 -= 7;
					perunapizza = "";
				}
			}
			textFieldSum.setText(String.valueOf(sum));
			pizzatSum.setText(quattropizza + kebabpizza + salamipizza + pollopizza + pekonipizza + tuttifruttipizza);
			textFieldSum2.setText(String.valueOf(sum2));
			pizzatSum2.setText(tomaattipizza + juustopizza + soijapizza + salaattipizza + porkkanapizza + perunapizza);

		}
	}	
	
	
	
}