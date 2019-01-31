package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import player.Player;



public class LandmarkPanel extends JPanel {

	String type;
	static int panelX = Frame.frameX-5;
	static int panelY = Frame.frameY-30;
	
	InputMap im;
	ActionMap am;
	
	Build build = Frame.build;
	Player player = Build.player;
	
	final static String EXIT  = "exit";
	
	public LandmarkPanel(String type) {
		this.type = type;
		setPreferredSize(new Dimension(panelX,panelY));
		setVisible(true);
		removeAll();
		setKeys();
		
		player.fillWater();
		
	}
	
	void setKeys(){

		System.out.println("Landmark Set keys");
		
		im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0 , false), EXIT);
		
		ActionMap am = this.getActionMap();
		am.put(EXIT,new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action performed");
				PanelControl.buildMapPanel();
				player.leaveLandmark();
			} 	 
		});
		
		
	}
	
//----------------------------------------------------------------------------
	 @Override
	    public void update(Graphics g) {
	    	
		 
	    }
//---------------------------------------------------------------------------
    public void repaint() {
       super.repaint();
    }	

//---------------------------------------------------------------------------
    public void paintComponent(Graphics g) {
    	g.setColor(Color.black);
    	g.fillRect(0, 0, panelX, panelY);
    	
    	System.out.println("Painting landmark");
    	
    	
        //update(g);
    }
	
	
}
	

