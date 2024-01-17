package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.player;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS
	final int originalTileSize=16;
	final int scale=4;
	public final int tileSize=originalTileSize*scale;
	final int maxScrCol=18;
	final int maxScrrRow=12;
	final int scrWidth=tileSize*maxScrCol;
	final int scrHeight=tileSize*maxScrrRow;
	// FPS
	int FPS=60;
	keyHandler kH=new keyHandler();
	Thread gt;
	player p=new player(this,kH);
	//set player's default position
	int playerX=100;
	int playerY=100;
	int playerSpeed=4;
	public GamePanel() {
		this.setPreferredSize(new Dimension(scrWidth,scrHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(kH);
		this.setFocusable(true);
		
	}
	
	public void startgt() {
		gt=new Thread(this);
		gt.start();
	}
	
	public void run()
	{
		double drawInterval= 1000000000/FPS;
		double nextDrawTime=System.nanoTime()+ drawInterval;
		while(gt!=null) {
			
			//long currentTime2=System.currentTimeMillis();
			upDate();
			repaint();
			
			try {
				double remainingTime=nextDrawTime-System.nanoTime();
				remainingTime=remainingTime/1000000;
				
				  if(remainingTime<0) {
					  remainingTime=0;
				  }
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println("the game loop is running");
			//1.UPDATE- update informations such as character positions
			//2.Draw- draw the screen with the updated information
		}}
	public void upDate() {
		p.upDate1();
		
	}
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		p.draw(g2);
		g2.dispose();
	}
	}
	


