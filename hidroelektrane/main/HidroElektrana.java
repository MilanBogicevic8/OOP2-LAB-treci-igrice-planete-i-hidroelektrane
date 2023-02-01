package main;

import java.awt.Color;

public class HidroElektrana extends Proizvodjac {

	public int brvode=0; //vrati na private
	public HidroElektrana(Baterija baterija) {
		super('H', Color.BLUE, 1500, baterija);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean proizvedi() {
		// TODO Auto-generated method stub
		if(brvode>=1) {
			baterija.dodajEnergiju(brvode);;
			return true;
		}
		return false;
	}
	
	public synchronized void postaviBrvode(int br) {
		brvode=br;
		if(br<0) br=0;
	}

}
