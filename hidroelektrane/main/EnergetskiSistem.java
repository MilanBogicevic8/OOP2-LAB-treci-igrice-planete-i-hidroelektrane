package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame{

	private Plac plac;
	private Baterija baterija;
	private Button dugme=new Button("Dodaj");
	public EnergetskiSistem(int x,int y,int kap) {
		super("Energetski sistem");
		plac=new Plac(x,y);
		baterija=new Baterija(kap);
		setResizable(false);
		setBounds(700, 300, 500, 500);
		
		Panel sever=new Panel();
		sever.add(dugme);
		add(sever,BorderLayout.NORTH);
		
		add(plac,BorderLayout.CENTER);
		
		populateWindow();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				plac.kraj();
				dispose();
			}
		});
		setVisible(true);
	}
	
	private void populateWindow() {
		// TODO Auto-generated method stub
		dugme.addActionListener((ae)->{
			plac.dodajProizvodjacaNaParcelu(new HidroElektrana(baterija));
		});
	}

	public static void main(String[] args) {
		new EnergetskiSistem(5,5,10);
	}
}
