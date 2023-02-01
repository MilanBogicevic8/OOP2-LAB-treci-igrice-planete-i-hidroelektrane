package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	public Svemir svemir=new Svemir();
	public Panel comands=new Panel();
	public Generator generator=new Generator(svemir);
	
	public Simulator() {
		setResizable(false);
		setBounds(700,300,200,400);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				svemir.zavrsi();
				generator.zaustavi();
				dispose();
			}
		});
		populateWindow();
		setVisible(true);
	}
	
	
	private void populateWindow() {
		// TODO Auto-generated method stub
		Button pokreni=new Button("Pokreni!");
		comands.add(pokreni);
		
		pokreni.addActionListener((ae->{
			svemir.pokreni();
			generator.pokreni();
			pokreni.setEnabled(false);
		}));
		
		add(comands,BorderLayout.SOUTH);
		Panel igra=new Panel();
		igra.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		int dim1=getWidth(); int dim2=7*getHeight()/8;
		svemir.setPreferredSize(new Dimension(dim1,dim2));
		igra.add(svemir);
		add(igra,BorderLayout.CENTER);
		
	}


	public static void main(String[] args) {
		new Simulator();
	}
}
