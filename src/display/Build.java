package display;

import java.util.ArrayList;

import javax.swing.JPanel;

import player.Player;

public class Build {

	Frame window = Frame.window;
	static JPanel mainPanel = Frame.mainPanel;
	//Frame.mapPanel;
	
	//Map
	static int panelX = MapPanel.panelX;
	static int panelY = MapPanel.panelX;
	
	static int width = MapPanel.width;
	static int height = MapPanel.height;
	
	ArrayList<Tile> leaders = new ArrayList<Tile>();
	public static Tile[][] tiles = new Tile[panelX/width][panelY/height];
	
	int leaderCount = 15;
	
	//Landmark

	//LandmarkPanel landmarkPanel;
	
	//Player
	
	static Player player;
	
	public Build() {
		
		System.out.println("Building");
		buildLeaders();
		buildBiome();
		buildLandmarks();
		buildPlayer();
		//buildMapPanel();
		
	}
	
	//Randoms--------------------------------------------------------------------------------------
		int rand(int low,int high) {
			int r = (int )(Math.random() * high + low); 
			return r;
		}
		String randLeaderBiome() {
			int r = (int )(Math.random() *4); 
			
			//System.out.println("biome: "+r);
			
			switch(r){
				case 0:
					return "sea";
				case 1:
					return "forest";
				case 2:
					return "desert";
				case 3:
					return "plain";
				default:
					return "noType";
			}
		}
		
		String randLandmark(int i, int j) {
			int rA = (int )(Math.random() *100); 
			
			int rB  = (int )(Math.random() *1000); 
			//System.out.println("landmark: "+r);

			String biome = tiles[i][j].getBiome();
			
			if(rA < 90) {
				return "none";
			}
			//Sea
			else if(biome == "sea") {
				
			}
			
			//Forest
			else if(biome == "forest" ) {
				if(rB>=0 & rB < 50) {
					return "forestHouse";
				}
				else if(rB >= 850 & rB<1000) {
					try {
						if(tiles[i+1][j].getBiome() == "sea" | tiles[i-1][j].getBiome() == "sea" |tiles[i][j+1].getBiome() == "sea" |tiles[i][j-1].getBiome() == "sea") {
								
							return "port";
								
						}
					}catch(Exception e) {
						System.out.println("Array likely out of bounds");
					}
				}else return "none";
				
			}
			
			
			//Desert
				else if(biome == "desert" ) {
					if(rB>=0 & rB < 50) {
						return "desertHouse";
					}
					else if(rB >=50 & rB < 75) {
						return "desertWaterHole";
					}
					
					else if(rB >= 850 & rB<1000) {
						try {
							if(tiles[i+1][j].getBiome() == "sea" | tiles[i-1][j].getBiome() == "sea" |tiles[i][j+1].getBiome() == "sea" |tiles[i][j-1].getBiome() == "sea") {
									
								return "port";
									
							}
						}catch(Exception e) {
							System.out.println("Array likely out of bounds");
						}
					}else return "none";
					
				}
			
			//Plain
				else if(biome == "plain" ) {
					if(rB>=0 & rB < 50) {
						return "plainHouse";
					}
					else if(rB>= 50 & rB < 100) {
						return "plainFarm";
					}
					
					else if(rB >=850 & rB<1000) {
						try {
							if(tiles[i+1][j].getBiome() == "sea" | tiles[i-1][j].getBiome() == "sea" |tiles[i][j+1].getBiome() == "sea" |tiles[i][j-1].getBiome() == "sea") {
									
								return "port";
									
							}
						}catch(Exception e) {
							System.out.println("Array likely out of bounds");
						}
					}else return "none";
					
				}
			
			else return "none";
			
			return "none";
			
		}
	//Centers-------------------------------------------------------------------------------------------
		void buildLeaders() {
			
			System.out.println("build centers");
				
				for(int i = 0; i<rand(5,leaderCount);i++ ) {
					leaders.add(new Tile(randLeaderBiome(), rand(0,panelX), rand(0,panelX)));
				}
				leaders.add(new Tile("sea", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("forest", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("desert", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("plain", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("sea", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("forest", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("desert", rand(0,panelX), rand(0,panelX)));
				leaders.add(new Tile("plain", rand(0,panelX), rand(0,panelX)));
		}
				
		String closestLeader(int x, int y) {
			  
			//System.out.println("closest leader");
			int dist;
			int distMin = 999999999;
			String biome = "noType";
			
			for(int i = 0; i< leaders.size();i++) {
				dist = (int) Math.sqrt((y - leaders.get(i).getY()) * (y - leaders.get(i).getY()) + (x - leaders.get(i).getX()) * (x - leaders.get(i).getX()));
				
				if(distMin > dist) {
					distMin = dist;
					biome = leaders.get(i).getBiome();
					
				}
			}
			//System.out.println(biome);
			return biome;
			
		}
		
	//Map-----------------------------------------------------------------------------------------
		void buildBiome() {
			
			System.out.println("build map");
			
			
			
			for(int i = 0; i < panelX/height; i++) {
	    		for(int j = 0; j< panelY/width; j++) {
	    			
	    			String biome = closestLeader(i*width,j*height);
	    			//System.out.println(biome);
	    			tiles[i][j] = new Tile(biome,i,j);
	    			
	    		}	
			}
		}
	//Landmarks-----------------------------------------------------------------------------------	
		void buildLandmarks(){
			
			System.out.println("build landmarks running");
			
			for(int i = 0; i < panelX/height; i++) {
	    		for(int j = 0; j< panelY/width; j++) {
	    			
	    			tiles[i][j].setLandmark(new Landmark(tiles[i][j].getBiome(),randLandmark(i,j)));
	    			tiles[i][j].getLandmark().setImage();
	    			
	    		}
			}	
		}
		
	//Player 
		void buildPlayer() {
			
			player = new Player("Carter", rand(0,panelX/width),rand(0,panelY/height), 3,3,3);
			
			
		}
	
	
}
