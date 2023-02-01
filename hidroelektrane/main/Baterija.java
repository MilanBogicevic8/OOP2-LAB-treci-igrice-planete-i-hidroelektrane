package main;

public class Baterija {

	private int kolicina;
	private int maxKap;
	
	public Baterija(int max) {
		this.kolicina=max;this.maxKap=max;
	}
	
	public synchronized void dodajEnergiju(int energija) {
		this.kolicina+=energija;
		if(kolicina>maxKap) kolicina=maxKap;
		
	}
	
	public synchronized void potpunoIsprazni() {
		kolicina=0;
	}
	
	public synchronized boolean puna() {
		return kolicina==maxKap;
	}
	
	
}
