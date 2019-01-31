package display;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class Frame extends JFrame{

	public static Frame window;
	final JLabel label = new JLabel("Random Number Fractal");
	
	static int frameX = 1005;
	static int frameY = 1025;
	
	public static Build build;
	public static JPanel mainPanel;
	//public static MapPanel mapPanel;
	
	public Frame() {
		super();
		
		
		mainPanel = new JPanel();
		mainPanel.setSize(frameX-5,frameY-30);
		add(mainPanel);
		build = new Build();
		PanelControl.buildMapPanel();
		//build = new Build();
		//mapPanel = new MapPanel();
		//add(mapPanel);
		
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
