package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Svemir extends Canvas implements Runnable {
	
	private List<NebeskoTelo> lista=new LinkedList<>();
	private Thread thread=new Thread(this);
	private boolean work;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		while(!Thread.interrupted()) {
				synchronized(this) {
					while(work==false) wait();
				}
				Thread.sleep(100);
				//repaint();
				synchronized(lista) {
					for(NebeskoTelo nt:lista) {
						nt.pomY(5);
					}
					repaint();
				}
		}
		} catch (InterruptedException e) {};
	}
	
	public void paint(Graphics g) {
		iscrtajNtela();
	}
	public Svemir() {
		setBackground(Color.BLACK); thread.start();
	}
	
	public void dodajNebeskoTelo(NebeskoTelo nt) {
		synchronized(lista) {
		lista.add(nt);
		}
	}
	public synchronized void pokreni() { work=true; notify();}
	public synchronized void zavrsi() {thread.interrupt();}
	private void iscrtajNtela() {
		synchronized(lista) {
		Graphics g=getGraphics();
		for(NebeskoTelo nt:lista) {
			nt.paint(g);
		}
		}
	}

}
