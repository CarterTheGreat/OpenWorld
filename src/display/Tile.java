package display;

import java.awt.Color;

public class Tile {

	String type;
	int x,y;
	Color color;
	
	public Tile(String type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
		setColor();
	}

	public String getType() {
		
		
		return type;
	}

	public void setColor() {
		
		switch(type) {
			case "noType":
				color = Color.red;
				break;
			case "forest":
					color = Color.green;
					break;
			case "sea":
					color = Color.blue;
					break;
			case "desert":
					color = Color.yellow;
					break;
			
		}
		
		
		this.color= color;
	}

	public Color getColor() {
		return color;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
