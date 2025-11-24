package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player (GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage ();
	}
	
	public void setDefaultValues () {
		
		x = 100;
		y = 100;
		speed = 4;
		normalspeed = 4;
		runspeed = 7;
		direction = "right";
	}
	
	public void getPlayerImage () {
			
		try {
			
			West1 = ImageIO.read(getClass().getResource("/player/West 1.png"));
			West2 = ImageIO.read(getClass().getResource("/player/West 2.png"));
			Westneutral = ImageIO.read(getClass().getResource("/player/West neutral.png"));
			South1 = ImageIO.read(getClass().getResource("/player/South 1.png"));
			South2 = ImageIO.read(getClass().getResource("/player/South 2.png"));
			North1 = ImageIO.read(getClass().getResource("/player/North 1.png"));
			North2 = ImageIO.read(getClass().getResource("/player/North 2.png"));
			East1 = ImageIO.read(getClass().getResource("/player/East Walk.png"));
			East2 = ImageIO.read(getClass().getResource("/player/East walk 2.png"));
			Eastneutral = ImageIO.read(getClass().getResource("/player/east neutral.png"));
			WestRun1 = ImageIO.read(getClass().getResource("/player/West Run.png"));
			WestRun2 = ImageIO.read(getClass().getResource("/player/West Run2.png"));
			EastRun1 = ImageIO.read(getClass().getResource("/player/East Run.png"));
			EastRun2 = ImageIO.read(getClass().getResource("/player/East Run2.png"));
		

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {

	    boolean moving = keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed;

	    // SPEED CHECK
	    if (keyH.runPressed && moving) {
	        speed = runspeed;
	    } else {
	        speed = normalspeed;
	    }

	    // MOVEMENT
	    if (keyH.upPressed) {
	        direction = "up";
	        y -= speed;
	    }
	    else if (keyH.downPressed) {
	        direction = "down";
	        y += speed;
	    }
	    else if (keyH.leftPressed) {
	        direction = "left";
	        x -= speed;
	    }
	    else if (keyH.rightPressed) {
	        direction = "right";
	        x += speed;
	    }

	    // ANIMATION
	    if (moving) {
	        spriteCounter++;
	        if (spriteCounter > 10) {
	            spriteNum = (spriteNum == 1) ? 2 : 1;
	            spriteCounter = 0;
	        }
	    } else {
	        spriteNum = 0;   // neutral frame
	    }
	}

	
	public void draw(Graphics2D g2) {

	    BufferedImage image = null;

	    switch (direction) {
	    
	    case "up":
	        if (spriteNum == 0) image = North1; 
	        else image = (spriteNum == 1 ? North1 : North2);
	        break;

	    case "down":
	        if (spriteNum == 0) image = South1;
	        else image = (spriteNum == 1 ? South1 : South2);
	        break;

	    case "left":

	        if (keyH.runPressed && spriteNum != 0) {
	            image = (spriteNum == 1 ? WestRun1 : WestRun2);
	        } else if (spriteNum == 0) {
	            image = Westneutral;
	        } else {
	            image = (spriteNum == 1 ? West1 : West2);
	        }
	        break;

	    case "right":

	        if (keyH.runPressed && spriteNum != 0) {
	            image = (spriteNum == 1 ? EastRun1 : EastRun2);
	        } else if (spriteNum == 0) {
	            image = Eastneutral;
	        } else {
	            image = (spriteNum == 1 ? East1 : East2);
	        }
	        break;
	    }

	    g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

}
