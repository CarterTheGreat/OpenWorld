package display;

import javax.swing.JPanel;

public class PanelControl {

	
	static JPanel mainPanel = Frame.mainPanel;
	static MapPanel mapPanel = new MapPanel();
	
	public static void buildMapPanel() {
		System.out.println("Buildng map panel");
		
		 mainPanel.removeAll();
		 System.out.println("Removed all");
	     mainPanel.add(mapPanel);
	     System.out.println("Added map");
	     mainPanel.revalidate();
	     mainPanel.repaint();
			
	}
			
	public static void buildLandmarkPanel(String type) {
				
		LandmarkPanel landmarkPanel = new LandmarkPanel(type);
							
		mainPanel.removeAll();
		System.out.println("Build new landmark panel");
	    mainPanel.add(landmarkPanel);
	    mainPanel.revalidate();
	    mainPanel.repaint();
	    System.out.println("Repainting");
				
				
	}
	
	
}
