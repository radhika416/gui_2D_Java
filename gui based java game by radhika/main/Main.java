package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args)
    {  
    	JFrame win = new JFrame();
    	win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	win.setResizable(false);
    	win.setTitle("2D adventures");
    	GamePanel gp=new GamePanel();
    	win.add(gp);
    	win.pack();
    	gp.startgt();
    	win.setLocationRelativeTo(null);
    	win.setVisible(true);
    }
}
