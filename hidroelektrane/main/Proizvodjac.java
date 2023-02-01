package main;

import java.awt.Color;

public abstract class Proizvodjac extends Parcela implements Runnable{

	private int OsnVreme;
	protected Baterija baterija;
	private int ukVreme;
	private Thread nit=new Thread(this);
	public Proizvodjac(char c, Color color,int vreme,Baterija baterija) {
		super(c, color);
		this.OsnVreme=vreme;
		this.baterija=baterija;
		ukVreme+=OsnVreme+Math.random()*300;
		nit.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		while(!Thread.interrupted()) {
			
				Thread.sleep(ukVreme);
				Color prev=color;
				boolean uspeh=proizvedi();
				
				if(uspeh) {
					color=Color.RED;
					setForeground(Color.RED);
				}
				Thread.sleep(300);
				setForeground(Color.WHITE);
				
		}
		} catch (InterruptedException e) {};
	}
	
	public abstract boolean proizvedi();
	public void zaustavi() { nit.interrupt();}

}
