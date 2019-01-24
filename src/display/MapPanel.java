package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapPanel extends JPanel{

	
	static int panelX = Frame.frameX;
	static int panelY = Frame.frameY;
	
	//Width of tiles
	static int width = 5;
	static int height = 5;
	//Tile images
	BufferedImage forest;
	
   
	
	Font font = new Font("Times New Roman", Font.BOLD, 26);
	int leaderCount = 5;
	
	ArrayList<Tile> leaders = new ArrayList<Tile>();
	Tile[][] tiles = new Tile[panelX/width][panelY/height];
	
	public MapPanel() {
			
	
			System.out.println("Map panel building");
			setPreferredSize(new Dimension(panelX,panelY));
		    setVisible(true);
		    removeAll();
		    
		    getImages();
		    buildMap();
		    
		    System.out.println("Map panel built");
				
	}
	
	 void  getImages() {
	       try {                
	          forest = ImageIO.read(new File("/src/forest.png"));
	       } catch (IOException ex) {
	            System.out.println("Images could not be imported");
	       }
	    }
	 
	void buildMap() {
		
		System.out.println("build map");
		
		buildCenters();
		
		for(int i = 0; i < panelX/height; i++) {
    		for(int j = 0; j< panelY/width; j++) {
    			
    			String type = closestCenter(i*width,j*height);
    			//System.out.println(type);
    			tiles[i][j] = new Tile(type,i,j);
    			
    		}	
		}
	}
	
	
	int rand(int low,int high) {
		int r = (int )(Math.random() * high + low); 
		return r;
	}
	String randType() {
		int r = (int )(Math.random() *3); 
		
		System.out.println("type: "+r);
		
		switch(r){
			case 0:
				return "sea";
			case 1:
				return "forest";
			case 2:
				return "desert";
			default:
				return "noType";
		}
	}
	
	void buildCenters() {
		
		System.out.println("build centers");
			
			for(int i = 0; i<rand(5,leaderCount);i++ ) {
				leaders.add(new Tile(randType(), rand(0,panelX), rand(0,panelX)));
			}
			leaders.add(new Tile("sea", rand(0,panelX), rand(0,panelX)));
			leaders.add(new Tile("forest", rand(0,panelX), rand(0,panelX)));
			leaders.add(new Tile("desert", rand(0,panelX), rand(0,panelX)));
	}
		
	String closestCenter(int x, int y) {
		  
		//System.out.println("closest centers");
		int dist;
		int distMin = 999999999;
		String type = "noType";
		
		for(int i = 0; i< leaders.size();i++) {
			dist = (int) Math.sqrt((y - leaders.get(i).getY()) * (y - leaders.get(i).getY()) + (x - leaders.get(i).getX()) * (x - leaders.get(i).getX()));
			
			if(distMin > dist) {
				distMin = dist;
				type = leaders.get(i).getType();
				
			}
		}
		//System.out.println(type);
		return type;
		
	}
	
	
	
	void buildLandmarks(){
		//Should i add another biome? A planes biome? Should ground textures be build befor landmarks? yeah probably
		
		
		//build landmarks on tiles here
		//Different tiles more and less likely to have landmarks 
		//Landmark types are different between different biomes
		
		//Ports on land tiles bordering ocean
		
	}
	
//RUNNING---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
//---------------------------------------------------------------------------
    @Override
    public void update(Graphics g) {
    	repaint();
    }
    
//---------------------------------------------------------------------------
    public void repaint() {
    	
    	//this doesn't need to repeat unless there is input
    	
    	
       // super.repaint();
    }	

//---------------------------------------------------------------------------
    public void paintComponent(Graphics g) {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, panelX, panelY);

    	for(int i = 0; i < panelX/height; i++) {
    		for(int j = 0; j< panelY/width; j++) {
    			
    			g.setColor(tiles[i][j] .getColor());
    			g.fillRect(i*width, j*height ,height,width);
    			
    		}
    	}
    	
    	for(int i = 0; i< leaders.size();i++) {
    		g.setColor(Color.black);
    		g.fillRect(leaders.get(i).getX(),leaders.get(i).getY(),5, 5);
    	}
    	
    	   	
        update(g);
    }
	
	
}
