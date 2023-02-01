package main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	protected int x,y;
	protected Color color;
	
	public Objekat(int x,int y,Color c) {
		this.x=x;this.y=y;
		this.color=c;
	}
	
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public void pomX(int x) {
		this.x+=x;
	}
	public void pomY(int y) {
		this.y+=y;
	}
	public abstract void paint(Graphics g);
}
