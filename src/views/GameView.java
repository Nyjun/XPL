package views;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import controllers.Game.Input;


public class GameView
{
	public static final int CAMERA_SIZE_X = 15; //Must be >= 3
	public static final int CAMERA_SIZE_Y = 15; //Must be >= 3
	public GameView()
	{
		setCharacterView(new CharacterView());
		
		//Create frame
		frame = new JFrame();
		frame.setSize(500,400);//w/h 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create panels
		toolPanel = new JPanel();
		JScrollPane toolScroll = new JScrollPane(toolPanel);
		toolScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		toolScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mapView = new MapView(CAMERA_SIZE_X, CAMERA_SIZE_Y, charView);
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
	
	private CharacterView charView;
	
	public void update()
	{
		mapView.update();
		frame.revalidate();
		frame.repaint();
	}
	
	 /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e)
    {
    	keyEventToInput(e, true);
    }
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e)
    {
    	keyEventToInput(e, false);
    }

    private Input keyEventToInput(KeyEvent e, boolean pressed)
    {
    	switch(e.getKeyCode())
    	{
    	case KeyEvent.VK_UP:
    		return pressed ? Input.PRESSED_UP : Input.RELEASED_UP;
    	case KeyEvent.VK_DOWN:
    		return pressed ? Input.PRESSED_DOWN : Input.RELEASED_DOWN;
    	case KeyEvent.VK_LEFT:
    		return pressed ? Input.PRESSED_LEFT : Input.RELEASED_LEFT;
    	case KeyEvent.VK_RIGHT:
    		return pressed ? Input.PRESSED_RIGHT : Input.RELEASED_RIGHT;
    	default:
    		return pressed ? Input.PRESSED_NULL : Input.RELEASED_NULL;
    	}
    }
    
	public MapView getMapView() {
		return mapView;
	}
	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
	public CharacterView getCharacterView() {
		return charView;
	}
	public void setCharacterView(CharacterView charView) {
		this.charView = charView;
	}
	
	
		
}
