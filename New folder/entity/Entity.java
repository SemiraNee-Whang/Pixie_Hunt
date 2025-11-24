package entity;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int x, y;
	public int speed, runspeed,normalspeed;
	
	public BufferedImage West1, West2, Westneutral, South1, South2, North1, North2, East1, East2, Eastneutral, WestRun1, WestRun2, EastRun1, EastRun2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;

}
