package main;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat{

	protected int r;
	public NebeskoTelo(int x, int y, Color c,int r) {
		super(x, y, c);
		this.r=r;
	}
}
