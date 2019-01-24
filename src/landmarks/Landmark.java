package landmarks;

public class Landmark {

	String biome;
	String type;
	int x;
	int y;
	int difficulty;
	
	public Landmark( String biome,String type, int x, int y) {
		this.biome = biome;
		this.type = type;
		this.x = x;
		this.y = y;
		setSettings();
	}
	
	
	void setSettings() {
		
		//Set difficulty of area based off dist from center
		
	}
	
}
