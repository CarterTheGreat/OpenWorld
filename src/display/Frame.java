package display;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel; 

public class Frame extends JFrame{

	static Frame window;
	final JLabel label = new JLabel("Random Number Fractal");
	
	static int frameX = 500;
	static int frameY = 500;
	
	private MapPanel mapPanel;
	
	public Frame() {
		super();
		
		mapPanel = new MapPanel();
		add(mapPanel);
		
		setSize(frameX,frameY);
		setResizable(false);
        setBackground(Color.white);
		
	}
	
	
	public static void main(String[] args) {
		
		window = new Frame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	    window.setTitle("Tile Map");
	    window.setLocationRelativeTo(null);
		
	}
	
}
