package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.keyHandler;

public class player extends Entity {
 public player(GamePanel gamePanel, keyHandler kH2) {
	 this.gp=gamePanel;
	 this.kH=kH2;
	 setDefaultValue();
	 getPlayerImage();
		// TODO Auto-generated constructor stub
	}
GamePanel gp;
 keyHandler kH;

 
 public void setDefaultValue() {
	  x = 100;
	 y=100;
	  speed = 4;
	  direction="down";
 }
 public void getPlayerImage() {
	 try {
		 up1=ImageIO.read(getclass().getResourceAsStream("/player/boy_up_1.png.png"));
		 up2=ImageIO.read(getclass().getResourceAsStream("/player/boy_up_12.png.png"));
		 down1=ImageIO.read(getclass().getResourceAsStream("/player/boy_down_1.png.png"));
		 down2=ImageIO.read(getclass().getResourceAsStream("/player/boy_down_2.png.png"));
		 left1=ImageIO.read(getclass().getResourceAsStream("/player/boy_left_1.png.png"));
		 left2=ImageIO.read(getclass().getResourceAsStream("/player/boy_left_2.png.png"));
		 right1=ImageIO.read(getclass().getResourceAsStream("/player/boy_right_1.png.png"));
		 right2=ImageIO.read(getclass().getResourceAsStream("/player/boy_right2_1.png.png"));
		 
	 }
	 catch(IoOException e) 
	 {e.printStacktTrace();}
 }
 
 
 public void upDate1() {
	 if(kH.up==true||kH.down==true||kH.right==true||kH.left==true) { if(kH.up==true) {
		 direction="up";
			y-=speed;
		}else if(kH.down==true) {
			direction="down";
			y+=speed;
		}else if(kH.left==true) {
			direction="left";
			x-=speed;
		}else if(kH.right==true) {
			direction="right";
			x+=speed;
		}
	 spriteCounter++;
	 if(spriteCounter >12) {
		 if(spriteNum==1) {
			 spriteNum=2;
		 }
		 else if(spriteNum==2) {
			 spriteNum=1;
		 }
spriteCounter=0	;}}
		 
		
	}public void draw(Graphics2D g2) {
	//	g2.setColor(Color.WHITE);
	//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		bufferedImage image=null;
		
		switch(direction) {
		case "up":
			if(spriteCounter==1) {image = up1;}
			if(spriteCounter==2) {image = up2;}
			
			break;
		case "down":
			if(spriteCounter==1) {image = down1;}
			if(spriteCounter==2) {image = down2;}
			break;
		case "right":
			if(spriteCounter==1) {image = right1;}
			if(spriteCounter==2) {image = right2;}
			break;
		case "left":
			if(spriteCounter==1) {image = left1;}
			if(spriteCounter==2) {image = left2;}
			break;
			 
		}
		g2.drawImage(image,x,y,gp.titleSize,gp.titleSize,null);
	}
	}

}
