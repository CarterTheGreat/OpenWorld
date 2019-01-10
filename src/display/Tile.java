package display;

import java.awt.Color;
import java.awt.Image;

public class Tile {

	String biome;
	Landmark landmark;
	Image landmarkImage;
	int x,y;
	Color color;
	
	public Tile(String biome, int x, int y) {
		this.biome = biome;
		this.x = x;
		this.y = y;
	}

	public String getBiome() {
		
		
		return biome;
	}

	public void setLandmark(Landmark set) {
		
		landmark = set;		
		
	}

	public Landmark getLandmark() {
		return landmark;
	}
	
	public Image getLandmarkImage() {
				
		return landmarkImage;
	}
	
	public void setBiome(String biome) {
		this.biome = biome;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
