package player;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;

import display.Build;
import display.Tile;

public class Player {
	
	String name;
	int strength, speed, vitality;
	
	public int damage;
	
	public int health;
	public int healthMax;
	
	public int water = 25;
	public int waterMax = 25;

	int gold;
	
	int x;
	int y;
	
	
	//file stuff
	static File playerImageF = new File("Tiles/png/playerImage.png");
	static BufferedImage playerImage;
	String undoMove;
	boolean hasBoat = false;
	Tile[][] tiles = Build.tiles;
	
	public Player(String name, int x, int y, int strength, int speed, int vitality) {
		this.name = name;
		this.x = x;
		this.y = y;		
		this.strength = strength;
		this.speed = speed;
		this.vitality = vitality;
		setImage();
		
	}

	public Action move(String direction) {
		
		//Up, Down, Left, Right
		
		System.out.println("Moving");
		
		switch(direction) {
			case "up":
				y -=1;
				undoMove = "down";
				checkMove();
				break;
			case "down":
				y += 1;
				undoMove = "up";
				checkMove();
				break;
			case "left": 
				x -= 1;
				undoMove = "right";
				checkMove();
				break;
			case "right":
				x += 1;
				undoMove = "left";
				checkMove();
				break;
			
		
		}
		return null;
		
	}
	
	public void checkMove() {
		
		//System.out.println("Current biome: "+ tiles[x][y].getBiome());
		//System.out.println("Current landmark: "+ tiles[x][y].getLandmark().getType());
		//System.out.println("---");
		boolean move;
			if(water == 0) {
				health -= 10;
			}
		
			if((!hasBoat & tiles[x][y].getBiome() == "sea")) {
				move = false;
			}else {
				move = true;
				water--;
			}
				
			if(!move) {
				move(undoMove);
			}
	}
	
	public void enterLandmark(String type) {
		
		System.out.println("enter landmark");
		
		
	}
	
	public void leaveLandmark() {
		
		System.out.println("enter landmark");
		
	}
	
	void calculateStats() {
		//TODO: add weapon equip in inventory
		//damage = strength*weapon.getDamage();
		healthMax = vitality*5;
	}
	
	
	
	
	
	//There are like a billion getters and setters down here, run far away-----------------------------------------------------------------------------------------------------
	
	void setBoat(boolean hasBoat) {
		this.hasBoat = hasBoat;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealthMax() {
		return healthMax;
	}

	public void setHealthMax(int healthMax) {
		this.healthMax = healthMax;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	
	public void fillWater() {
		this.water = waterMax;
	}
	
	public void changeWater(int change) {
		this.water = water+change;
		if(water > waterMax) {
			this.water = waterMax;
		}
	}

	public int getWaterMax() {
		return waterMax;
	}

	public void setWaterMax(int waterMax) {
		this.waterMax = waterMax;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	void setImage() {
		try {                
	         playerImage = ImageIO.read(playerImageF);
	      } catch (IOException ex) {
	           System.out.println("Player - image could not be imported");
	      }
	}
	
	public Image getImage() {
		
		return playerImage;
	}
	
	
	
}
