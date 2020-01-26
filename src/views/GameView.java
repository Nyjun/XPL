package views;

import java.awt.*;
import javax.swing.*;


public class GameView
{
	public static final int CAMERA_SIZE_X = 15; //Must be >= 3
	public static final int CAMERA_SIZE_Y = 15; //Must be >= 3
	public GameView()
	{
		//Create frame
		frame = new JFrame();
		frame.setSize(500,400);//w/h 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create panels
		toolPanel = new JPanel();
		JScrollPane toolScroll = new JScrollPane(toolPanel);
		toolScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		toolScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mapView = new MapView(CAMERA_SIZE_X, CAMERA_SIZE_Y);
		//mapView.setSize(400, 400);
		
		// Create & Set layouts
		mainLayout = new BorderLayout();
		frame.setLayout(mainLayout);
		toolLayout = new GridLayout(1, 0);
		toolPanel.setLayout(toolLayout);
		
		// Add content into the frame
		frame.add(toolScroll, BorderLayout.PAGE_END);
		frame.add(mapView, BorderLayout.CENTER);
		toolPanel.add(new JButton("Tool"));
		toolPanel.add(new JButton("Tool"));
 
		frame.setVisible(true);
		//System.out.println(((JButton)mapPanel.getComponent(6)).getText());
		
	}
	
	private JFrame frame;
	
	private JPanel toolPanel;
	private MapView mapView;
	
	private BorderLayout mainLayout;
	private GridLayout toolLayout;
	
	public void update()
	{
		mapView.update();
		frame.revalidate();
		frame.repaint();
	}

	public MapView getMapView() {
		return mapView;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
	
	
		
}
