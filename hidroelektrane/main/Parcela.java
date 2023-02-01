package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Parcela extends Label {
	protected char c;
	protected Color color;
	
	public Parcela(char c,Color color) {
		this.color=color;this.c=c;
		setFont(new Font(Font.SERIF,Font.BOLD,14));
		setForeground(Color.WHITE);
		setBackground(color);
		setAlignment(Label.CENTER);
		setText(String.valueOf(c));
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				((Plac)getParent()).prijava(Parcela.this);
				}
			
		});
		//revalidate();
	}
	
	
	public void promeniBojuPozadine(Color co) {
		color=co;
		setBackground(co);
	}
	
	
}
