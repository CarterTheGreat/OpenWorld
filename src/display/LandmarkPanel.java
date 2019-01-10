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
	
	public LandmarkPanel(String type) {
		this.type = type;
		setPreferredSize(new Dimension(panelX,panelY));
		setVisible(true);
		removeAll();
		setKeys();
		
		
		System.out.println("Focus Owner: "+isFocusOwner());
	}
	
	void setKeys(){

		System.out.println("Set keys");
		im = this.getInputMap(JComponent.WHEN_FOCUSED);
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0 , false),  "leave");
		
		ActionMap am = this.getActionMap();
		am.put("leave",new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action performed");
				build.buildMapPanel();
				player.leaveLandmark();
			} 	 
		});
	}
	
//----------------------------------------------------------------------------
	 @Override
	    public void update(Graphics g) {
	    	
		 System.out.println("update");
		 
	    }
//---------------------------------------------------------------------------
    public void repaint() {
       super.repaint();
    }	

//---------------------------------------------------------------------------
    public void paintComponent(Graphics g) {
    	g.setColor(Color.white);
    	g.fillRect(0, 0, panelX, panelY);
    	
    	System.out.println("Painting landmark");
    	
    	
        //update(g);
    }
	
	
}
	

