package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import player.Player;

public class MapPanel extends JPanel{

	
	static int panelX = Frame.frameX-5;
	static int panelY = Frame.frameY-30;
	
	//Width of tiles
	static int width = 10;
	static int height = 10;
	
	Build build = Frame.build;
	Player player  = Build.player;
	
	Font font = new Font("Times New Roman", Font.BOLD, 26);
	
	Tile[][] tiles = Build.tiles;
	
	InputMap im;
	ActionMap am;
	
	public MapPanel() {
		
			System.out.println("Map panel building");
			
			setPreferredSize(new Dimension(panelX,panelY));
		    setVisible(true);
		    removeAll();
		    setKeys();
		    
		    System.out.println("Map panel built");
				
	}

	void setKeys(){

		im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0 , false),  "up");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0 , false),  "down");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0 , false),  "left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0 , false),  "right");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0 , false),  "enterLandmark");
		
		ActionMap am = this.getActionMap();
		am.put("up",new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.move("up");
			}
		});
		am.put("down",new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.move("down");
			}
		});
		am.put("left",new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						player.move("left");
					}
				});
		am.put("right",new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.move("right");
			}
		});
		am.put("enterLandmark",new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tiles[player.getX()][player.getY()].getLandmark().getType() != "none") {
					build.buildLandmarkPanel(tiles[player.getX()][player.getY()].getLandmark().getType());
					player.enterLandmark(tiles[player.getX()][player.getY()].getLandmark().getType());
				}	
			}
		});
		
	}
	
//PROCESS--------------------------------------------------------------------------------------------------------------------------------------------------------------
	
//-----------------------------------------------------------------------------
	    @Override
	    public void update(Graphics g) {
	    	process();
	    	repaint();
	    }
//--------------------- -------------------------------------------------------    
	void process() {
		
	}
	
//DRAW--------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
//---------------------------------------------------------------------------
    public void repaint() {
       super.repaint();
    }	

//---------------------------------------------------------------------------
    public void paintComponent(Graphics g) {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, panelX, panelY);

    	for(int i = 0; i < panelX/height; i++) {
    		for(int j = 0; j< panelY/width; j++) {
    			
    			g.drawImage(tiles[i][j].getLandmark().getImage(),i*width, j*height ,width,height,this);
    			
    		}
    	}
    	
    	g.drawImage(player.getImage(),player.getX()*width, player.getY()*height,width,height,this);
    	
    	
    	/*/Draw Leaders as black dots
    	for(int i = 0; i< leaders.size();i++) {
    		g.setColor(Color.black);
    		g.fillRect(leaders.get(i).getX(),leaders.get(i).getY(),5, 5);
    	}
    	*/
    	
    	//g.setColor(Color.BLACK);   	
    	//g.fillRect(990,990,10,10);
    	
    	
        update(g);
    }
	
	
}
