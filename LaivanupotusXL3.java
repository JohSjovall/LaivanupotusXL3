package Peli;

import java.awt.*;
import java.awt.event.*;
/**
 * 
 * Kyseisessä pelissä on tarkoitus löytää koneen piilottamia laivoja pelikentästä.
 * Kentä koostuu 4x4 olevasta nappula alueesta.
 * Peliä voi pelata etsimällä 1-3 laivaa.
 * @author Johan Sjövall
 *
 */
public class LaivanupotusXL3{
/**
 * Luodaan tarvittavat elemneit
 */
private Frame f;
private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, bR; //Pelialueen painikkeet
private Panel p1, p2, p3, p4, p5, p6; //Panelialueet joihin painikkeet asetetaan
private Label l1, l2, l3, l4, l5, l6, l7, l8, l9; //Labelit joihin asetetaan kirjaimet pelealueen ympärille
private int find, numero, yritys; //find = löydettyjen alusten määrä, numero = alusten määrä, yritykset = etsintä yritykset
private  TextField tull; // Neuvojen ja tilastojen kertomista varten
int laiva, laiva2, laiva3; // Laivojen sijainti 1-16 alueella

//MenBaarin toiminnalliset painikkeet
MenuBar mb = new MenuBar();
Menu m1 = new Menu("Peli");
Menu m2 = new Menu("Ohjeet");
Menu m3 = new Menu("Uusipeli");
MenuItem mi1 = new MenuItem("1 laiva");
MenuItem mi4 = new MenuItem("2 laiva");
MenuItem mi5 = new MenuItem("3 laiva");
MenuItem mi2 = new MenuItem("Lopeta");
MenuItem mi3 = new MenuItem("Valitse laivojen määrä 1-3 väliltä.");
MenuItem mi6 = new MenuItem("Peli loppuu kun olet löytänyt kaikki laivat.");
/**
 * Määritetään elementit loppuun ja kootaan pelikentä kasaan
 */
public void upotus(){
	//Määritetään
	tull = new TextField("Valitse Uusipeli ja laivojen määrä");
	p1 = new Panel();
	p2 = new Panel();
	p3 = new Panel();
	p4 = new Panel();
	p5 = new Panel();
	p6 = new Panel();
	f = new Frame("LaivanupotusXL3");
	b1 = new Button("  ");
	b2 = new Button("  ");
	b3 = new Button("  ");
	b4 = new Button("  ");
	b5 = new Button("  ");
	b6 = new Button("  ");
	b7 = new Button("  ");
	b8 = new Button("  ");
	b9 = new Button("  ");
	b10 = new Button("  ");
	b11 = new Button("  ");
	b12 = new Button("  ");
	b13 = new Button("  ");
	b14 = new Button("  ");
	b15 = new Button("  ");
	b16 = new Button("  ");
	bR = new Button("B)");
	l1 = new Label ("A");
	l2 = new Label ("B");
	l3 = new Label ("C");
	l4 = new Label ("D");
	l5 = new Label ("1");
	l6 = new Label ("2");
	l7 = new Label ("3");
	l8 = new Label ("4");
	//l9 = new Label (" ");


	//rekisteröidään tapahtumakäsittelijä
	b1.addActionListener(new OwnHandler());
	b2.addActionListener(new OwnHandler());
	b3.addActionListener(new OwnHandler());
	b4.addActionListener(new OwnHandler());
	b5.addActionListener(new OwnHandler());
	b6.addActionListener(new OwnHandler());
	b7.addActionListener(new OwnHandler());
	b8.addActionListener(new OwnHandler());
	b9.addActionListener(new OwnHandler());
	b10.addActionListener(new OwnHandler());
	b11.addActionListener(new OwnHandler());
	b12.addActionListener(new OwnHandler());
	b13.addActionListener(new OwnHandler());
	b14.addActionListener(new OwnHandler());
	b15.addActionListener(new OwnHandler());
	b16.addActionListener(new OwnHandler());
	bR.addActionListener(new Varivaihto());
	
	b1.setBackground(Color.BLUE);
	b2.setBackground(Color.BLUE);
	b3.setBackground(Color.BLUE);
	b4.setBackground(Color.BLUE);
	b5.setBackground(Color.BLUE);
	b6.setBackground(Color.BLUE);
	b7.setBackground(Color.BLUE);
	b8.setBackground(Color.BLUE);
	b9.setBackground(Color.BLUE);
	b10.setBackground(Color.BLUE);
	b11.setBackground(Color.BLUE);
	b12.setBackground(Color.BLUE);
	b13.setBackground(Color.BLUE);
	b14.setBackground(Color.BLUE);
	b15.setBackground(Color.BLUE);
	b16.setBackground(Color.BLUE);
	
	f.setMenuBar(mb);
	//MenuBar sisältö
	
	mb.add(m1);
	mb.add(m2);
	
	//menuupaarin lisäykset
	m3.add(mi1);
	m3.add(mi4);
	m3.add(mi5);
	
	mi1.addActionListener(new LaivaPelit());
	mi4.addActionListener(new LaivaPelit());
	mi5.addActionListener(new LaivaPelit());
	mi2.addActionListener(new Loppu());

	m1.add(m3);
	m1.add(mi2);

	m2.add(mi3);
	m2.add(mi6);

	p5.add(bR);
	//p5.add(l9);
	p5.add(l5);
	p5.add(l6);
	p5.add(l7);
	p5.add(l8);

	p1.add(l1);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);

	p2.add(l2);
	p2.add(b5);
	p2.add(b6);
	p2.add(b7);
	p2.add(b8);

	p3.add(l3);
	p3.add(b9);
	p3.add(b10);
	p3.add(b11);
	p3.add(b12);

	p4.add(l4);
	p4.add(b13);
	p4.add(b14);
	p4.add(b15);
	p4.add(b16);
	
	p6.add(tull);

	p1.setLayout(new FlowLayout());
	p2.setLayout(new FlowLayout());
	p3.setLayout(new FlowLayout());
	p4.setLayout(new FlowLayout());
	p5.setLayout(new FlowLayout());

	f.add(p5);
	f.add(p1);
	f.add(p2);
	f.add(p3);
	f.add(p4);
	f.add(p6);
	f.setBackground(Color.orange);
	f.setLayout(new GridLayout(6,1));
	f.pack();
	f.setVisible(true);
	f.addWindowListener(new HoiteleIkkunanSulkeminen());
}

private class LaivaPelit implements ActionListener {
	private void Laivat(){
		Boolean sekoita = true;
		while(sekoita){
		laiva = (int)(Math.random() * 16)+1;
		laiva2 = (int)(Math.random() * 16)+1;
		laiva3 = (int)(Math.random() * 16)+1;
		System.out.println("sekoitus");
		System.out.println("Laiva 1 "+laiva);
		System.out.println("Laiva 2 "+laiva2);
		System.out.println("Laiva 3 "+laiva3);
		if((laiva==laiva2)||(laiva == laiva3)||(laiva2==laiva3))
			sekoita = true;
		else
			sekoita = false;
		}
	}
	private void maalausJaNollaus(){
		b1.setBackground(Color.BLUE);
		b2.setBackground(Color.BLUE);
		b3.setBackground(Color.BLUE);
		b4.setBackground(Color.BLUE);
		b5.setBackground(Color.BLUE);
		b6.setBackground(Color.BLUE);
		b7.setBackground(Color.BLUE);
		b8.setBackground(Color.BLUE);
		b9.setBackground(Color.BLUE);
		b10.setBackground(Color.BLUE);
		b11.setBackground(Color.BLUE);
		b12.setBackground(Color.BLUE);
		b13.setBackground(Color.BLUE);
		b14.setBackground(Color.BLUE);
		b15.setBackground(Color.BLUE);
		b16.setBackground(Color.BLUE);
	}
//esimerkiksi Button generoi tapahtuman, joka aiheuttaa kutsun tänne
public void actionPerformed(ActionEvent e){
	String text = e.getActionCommand();
	System.out.println("Komento: " + text);
	
if (e.getSource() == mi1){
	maalausJaNollaus();
	Laivat();
	laiva2 = 0;
	laiva3 = 17;
	
	tull.setText("Etsi 1 Laivaa");
	yritys = 0;
	find = 0;
	numero = 1;
}

if (e.getSource() == mi4){
	maalausJaNollaus();
	Laivat();
	laiva3 = 0;

	tull.setText("Etsi 2 Laivaa");
	yritys = 0;
	find = 0;
	numero = 2;
}

if (e.getSource() == mi5){
	maalausJaNollaus();
	Laivat();
	
	tull.setText("Etsi 3 Laivaa");
	yritys = 0;
	find = 0;
	numero = 3;
}
}
}
private class Varivaihto implements ActionListener {
	public void actionPerformed (ActionEvent a){
		if(a.getSource() == bR){
			Color[] varit= new Color[] {Color.PINK, Color.ORANGE, Color.GREEN, Color.CYAN, Color.WHITE};
			int arvo = (int)(Math.random() * 5);
			p1.setBackground(varit[arvo]);
			p2.setBackground(varit[arvo]);
			p3.setBackground(varit[arvo]);
			p4.setBackground(varit[arvo]);
			p5.setBackground(varit[arvo]);
			p6.setBackground(varit[arvo]);
			l1.setBackground(varit[arvo]);
			l2.setBackground(varit[arvo]);
			l3.setBackground(varit[arvo]);
			l4.setBackground(varit[arvo]);
			l5.setBackground(varit[arvo]);
			l6.setBackground(varit[arvo]);
			l7.setBackground(varit[arvo]);
			l8.setBackground(varit[arvo]);
			tull.setBackground(varit[(int)(Math.random() * 5)]);
			bR.setBackground(varit[(int)(Math.random() * 5)]);
		}
	}
}
// Yksinkertainen oma tapahtumakäsittelijä
private class OwnHandler implements ActionListener{
	private void nappula(int ruutu, Button nappi){
		if(find < numero && numero != 0){
			if (ruutu==laiva || ruutu==laiva2 || ruutu==laiva3){
				if(nappi.getBackground()==Color.red){
					yritys++;
					tull.setText("Löysit tämän jo!  "+yritys+". yritys!");
				}
				else{
					nappi.setBackground(Color.red);
					yritys++;
					tull.setText("OSUIT!!!  "+yritys+". yrityksellä!");
					find++;
					if (find >= numero){
						tull.setText("Löysit kaikki laivat!  "+yritys+". yrityksellä!");
						}
					}
				}
			else{
				if(nappi.getBackground()==Color.yellow){
					yritys++;
					tull.setText("Katsoit tämän jo!  "+yritys+". yritys!");
					}
				else{
					nappi.setBackground(Color.yellow);
					yritys++;
					tull.setText("Ohi!  "+yritys+". yritys!");
					}
				}
			}
	}
	
//esimerkiksi Button generoi tapahtuman, joka aiheuttaa kutsun tänne
public void actionPerformed(ActionEvent e){
	System.out.println("-----------------");
	System.out.println("Löydöt "+find);
	System.out.println("Laiva 1 "+laiva);
	System.out.println("Laiva 2 "+laiva2);
	System.out.println("Laiva 3 "+laiva3);
	System.out.println("-----------------");
	if (find >= numero && numero != 0) { 
		tull.setText("Löysit kaikki laivat!  "+yritys+". yrityksellä!");
		System.out.println("--Loppu--");
	}
	if (e.getSource() == b1){
		nappula(1,b1);
		}
	else if (e.getSource() == b2){
		nappula(2,b2);	
		}

	else if (e.getSource() == b3){
		nappula(3,b3);
	}
	else if (e.getSource() == b4){
		nappula(4,b4);
	}
	else if (e.getSource() == b5){
		nappula(5,b5);
	}
	else if (e.getSource() == b6){
		nappula(6,b6);
	}
	else if (e.getSource() == b7){
		nappula(7,b7);
	}
	else if (e.getSource() == b8){
		nappula(8,b8);
	}
	else if (e.getSource() == b9){
		nappula(9,b9);
	}
	else if (e.getSource() == b10){
		nappula(10,b10);
	}
	else if (e.getSource() == b11){
		nappula(11,b11);
	}
	else if (e.getSource() == b12){
		nappula(12,b12);
	}
	else if (e.getSource() == b13){
		nappula(13,b13);
	}
	else if (e.getSource() == b14){
		nappula(14,b14);
	}
	else if (e.getSource() == b15){
		nappula(15,b15);
	}
	else if (e.getSource() == b16){
		nappula(16,b16);
	}
}
}


public class Loppu implements ActionListener{
//esimerkiksi Button generoi tapahtuman, joka aiheuttaa kutsun tänne
public void actionPerformed(ActionEvent e){
	String text = e.getActionCommand();
	System.out.println("Selected: " + text);
	if (text.equals("Lopeta"))
		System.exit(0);
}
}
public static void main(String a[]){
	LaivanupotusXL3 me;
	me = new LaivanupotusXL3();
	me.upotus();
}
class HoiteleIkkunanSulkeminen extends WindowAdapter {
	public void windowClosing(WindowEvent tapahtuma){
		System.exit(0); // ikkunan sulkeminen
	}
}
}