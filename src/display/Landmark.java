package display;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Landmark {

	String biome;
	String type;
	int difficulty;
	Image image;
	
	static File seaF = new File("Tiles/jpeg/sea.jpg");
	static File forestF = new File("Tiles/jpeg/forest.jpg");
	static File desertF = new File("Tiles/jpeg/desert.jpg");
	static File plainF = new File("Tiles/jpeg/plain.jpg");
	
	static File forestHouseF = new File("Tiles/jpeg/forestHouse.jpg");
	static File desertHouseF = new File("Tiles/jpeg/desertHouse.jpg");
	static File plainHouseF = new File("Tiles/jpeg/plainHouse.jpg");
	

	static File desertWaterHoleF = new File("Tiles/jpeg/desertWaterHole.jpg");
	static File plainFarmF = new File("Tiles/jpeg/plainFarm.jpg");
	
	static File portF = new File("Tiles/jpeg/port.jpg");
	
	static BufferedImage sea,forest,desert,plain;
	static BufferedImage forestHouse,desertHouse,plainHouse;
	static BufferedImage desertWaterHole,plainFarm;
	static BufferedImage port;
	
	public Landmark(String biome,String type) {
		//System.out.println("Landmark- building");
		this.biome = biome;
		this.type = type;
		setSettings();
		
		
	}
	
	/*
	 * Types-
	 * 
	 * none - refers to default tile type 
	 * 		ie. sea none = sea default tile
	 * 
	 * Sea-
	 * Forest-
	 * 		forestHouse
	 * Desert-
	 * 		desertHouse
	 * 		desertWateringHole
	 * Plain
	 * 		plainHouse
	 * 		plainFarm
	 * Multi-
	 * 		port (forest,desert,plain)
	 * 
	 * 
	 */
	public String getType() {
		return type;
	}
	
	void setSettings() {
			
			 try {                
		         sea      = ImageIO.read(seaF);
		         forest  = ImageIO.read(forestF);
		         desert = ImageIO.read(desertF);
		         plain   = ImageIO.read(plainF);
		         
		         forestHouse  = ImageIO.read(forestHouseF);
		         desertHouse = ImageIO.read(desertHouseF);
		         plainHouse   = ImageIO.read(plainHouseF);
		         
		         desertWaterHole  = ImageIO.read(desertWaterHoleF);
		         plainFarm 		 	= ImageIO.read(plainFarmF);
		         
		        port = ImageIO.read(portF);
		         
		      } catch (IOException ex) {
		           System.out.println("Landmark - Images could not be imported");
		      }
		
	}
	
	
	
	void setImage() {
		
		//System.out.println("Landmark - get image running");
		
		switch(biome) {
			case "sea":
				
				switch(type) {
					case "none":
						image = sea;
						break;
					
				}
			break;
				
				
			case "forest":
				
				switch(type) {
					case "none":
						image = forest;
						break;
					case "forestHouse":
						image = forestHouse;
						break;
					case "port":
						image = port;
						break;
			}
			break;
			
			
			case "desert":
				
				switch(type) {
					case "none":
						image = desert;
						break;
					case "desertHouse":
						image = desertHouse;
						break;
					case "desertWaterHole":
						image = desertWaterHole;
						break;
					case "port":
						image = port;
						break;
				}
			break;
				
			
			case "plain":
				
				switch(type) {
					case "none":	
						image = plain;
						break;
					case "plainHouse":
						image = plainHouse;
						break;
					case "plainFarm":
						image = plainFarm;
						break;
					case "port":
						image = port;
						break;
				}
			break;	
		}
		
	}
	
	Image getImage() {
		return image;
	}
	
}	
	
