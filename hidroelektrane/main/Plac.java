package main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;


public class Plac extends Panel {

	private int red;
	private int kolona;
	private Parcela[][] parcele;
	private List<Proizvodjac> lista=new LinkedList<>();
	private Parcela parc; // trnutno aktivna parcela na placu
	public void prijava(Parcela par) {
		if(parc!=null) {// postavi prethodnu parcelu na normalnu velicinu
		parc.setFont(new Font(Font.SERIF,Font.BOLD,14));
		parc.revalidate();
		}
		parc=par;
		parc.setFont(new Font(Font.SERIF,Font.BOLD,20));
		parc.revalidate();
		
	}
	public Plac(int red,int kolona) {
		this.red=red;
		this.kolona=kolona;
		parcele=new Parcela[this.red][this.kolona];
		setLayout(new GridLayout(red,kolona,2,2));
		for(int i=0;i<red;i++) {
			for(int j=0;j<kolona;j++) {
				if(Math.random()<0.7) {
					add(parcele[i][j]=new TravnataPovrs());
				}else {
					add(parcele[i][j]=new VodenaPovrs());
				}
			}
		}	
	}
	
	public void dodajProizvodjacaNaParcelu(Proizvodjac pr) {
		lista.add(pr);
		for(int i=0;i<red;i++) {
			for(int j=0;j<kolona;j++) {
				if(parc==parcele[i][j]) {
					if(parc instanceof HidroElektrana) ((HidroElektrana) parc).zaustavi();
					remove(parc);
					parcele[i][j]=pr;
					//pr.revalidate();
				}
				
				
			}
		}
		
		for(int i=0;i<red;i++) {
			for(int j=0;j<kolona;j++) {
				add(parcele[i][j]);
			}
		}
		
		System.out.println("---------------------------------");
		//preracunavanje broja vodenih povrsina
		for(int i=0;i<red;i++) {
			for(int j=0;j<kolona;j++) {
				if(parcele[i][j] instanceof HidroElektrana) {
					int broj=0;	
				
					if(i-1>=0) {//leva
						if(parcele[i-1][j] instanceof VodenaPovrs) {
						
							broj++;
						}
					}
					if(i+1<red) {//desna
						if(parcele[i+1][j] instanceof VodenaPovrs) {
						
							broj++;
						}
					}
					
					if(j-1>=0) {// gornja
						if(parcele[i][j-1] instanceof VodenaPovrs) {
							broj++;
						}
					}
					
					if(j+1<kolona) {// donja
						if(parcele[i][j+1] instanceof VodenaPovrs) {
							broj++;
						}
					}

					if(i+1<red && j-1>=0) {// donja leva
						if(parcele[i+1][j-1] instanceof VodenaPovrs) {
								broj++;
					}
					}
					if(i+1<red && j+1<kolona) {// donja desna
						if(parcele[i+1][j+1] instanceof VodenaPovrs) {
								broj++;
					}
					}	
					if(i-1>=0 && j+1<kolona) {// gornja desna
						if(parcele[i-1][j+1] instanceof VodenaPovrs) {
								broj++;
						}
					}	
					if(i-1>=0 && j-1>=0) {// gornja leva
						if(parcele[i-1][j-1] instanceof VodenaPovrs) {
								broj++;
					}
					}
					
					((HidroElektrana)parcele[i][j]).postaviBrvode(broj);
					System.out.println("Ovo je "+i+"red "+j+" kolona"+" i ima vode"+((HidroElektrana)parcele[i][j]).brvode+".");
				}	
			}
		}	
		//parc=null;
		parc=pr;
		parc.revalidate();
	}
	
	public void kraj() {
		for(Proizvodjac p:lista) p.zaustavi();
	}
	
	
}
