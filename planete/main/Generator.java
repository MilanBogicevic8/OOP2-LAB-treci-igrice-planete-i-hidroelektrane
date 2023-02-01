package main;

public class Generator extends Thread{
	private Svemir svemir;
	private boolean work;
	public Generator(Svemir s) {
		this.svemir=s; this.start();
	}
	
	public void run() {
		try {
		while(!Thread.interrupted()) {
			synchronized(this) {
				while(work==false) wait();
			}
			
				Thread.sleep(900);
				svemir.dodajNebeskoTelo(new Kometa((int)(Math.random()*200),0,(int)(Math.random()*20+10)));
				svemir.repaint();
		}
		} catch (InterruptedException e) {};
	}
	
	public synchronized void pokreni() { work=true; notify();}
	public synchronized void zaustavi() {interrupt();}
}
