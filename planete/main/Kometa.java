package main;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {

	private double ugao;
	public Kometa(int x, int y, int r) {
		super(x, y,Color.GRAY, r);
		// TODO Auto-generated constructor stub
		ugao=Math.random()*2*Math.PI;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Color c=g.getColor();
		g.setColor(color);
		g.translate(x, y);
		
		
		int[] arr1=new int[6];
		int[] arr2=new int[6];
		int br=0;
		for(double angle=0;angle<=2*Math.PI;angle+=(2*Math.PI/5)) {
		
			int korX=x+(int)(Math.cos(angle+ugao)*r);
			int korY=y+(int)(Math.sin(angle+ugao)*r);
			
			arr1[br]= korX; //(int) (korX*Math.cos(ugao)-korY*Math.sin(ugao));
			arr2[br]= korY;//(int)(korY*Math.cos(ugao)+korX*Math.sin(ugao));
			
			br++;
		}
		
		g.translate(-x, -y);
		g.fillPolygon(arr1, arr2, arr1.length);
		//g.translate(-x, -y);
		g.setColor(c);
		
	}

}
