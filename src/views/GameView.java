package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controllers.Game;
import controllers.Game.Input;


public class GameView extends JFrame implements KeyListener
{
	public static final int CAMERA_SIZE_X = 15; //Must be >= 3
	public static final int CAMERA_SIZE_Y = 15; //Must be >= 3
	public GameView()
	{
		//Create frame
		super();
		this.setSize(500,400);//w/h 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setCharacterView(new CharacterView());
		
		// Create panels
		toolPanel = new JPanel();
		JScrollPane toolScroll = new JScrollPane(toolPanel);
		toolScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		toolScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mapView = new MapView(CAMERA_SIZE_X, CAMERA_SIZE_Y, charView);
		//mapView.setSize(400, 400);
		
		// Create & Set layouts
		mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		toolLayout = new GridLayout(1, 0);
		toolPanel.setLayout(toolLayout);
		
		// Add content into the frame
		this.add(toolScroll, BorderLayout.PAGE_END);
		this.add(mapView, BorderLayout.CENTER);
		toolPanel.add(new JButton("Tool"));
		toolPanel.add(new JButton("Tool"));
 
		this.setFocusable(true);
		this.setVisible(true);
		//System.out.println(((JButton)mapPanel.getComponent(6)).getText());
		
		this.addKeyListener(this);
		
	}
	public void init(Game game)
	{
		this.game = game;
	}
	private Game game;
	
	private JPanel toolPanel;
	private MapView mapView;
	
	private BorderLayout mainLayout;
	private GridLayout toolLayout;
	
	private CharacterView charView;
	
	public void update()
	{
		mapView.update();
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e)
	{
		game.addInput(keyEventToInput(e, false));
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		game.addInput(keyEventToInput(e, true));
	}

    private Input keyEventToInput(KeyEvent e, boolean pressed)
    {
    	switch(e.getKeyCode())
    	{
    	case KeyEvent.VK_UP:
    		//System.out.println("UP");
    		return pressed ? Input.PRESSED_UP : Input.RELEASED_UP;
    	case KeyEvent.VK_DOWN:
    		//System.out.println("DOWN");
    		return pressed ? Input.PRESSED_DOWN : Input.RELEASED_DOWN;
    	case KeyEvent.VK_LEFT:
    		//System.out.println("LEFT");
    		return pressed ? Input.PRESSED_LEFT : Input.RELEASED_LEFT;
    	case KeyEvent.VK_RIGHT:
    		//System.out.println("RIGHT");
    		return pressed ? Input.PRESSED_RIGHT : Input.RELEASED_RIGHT;
    	case KeyEvent.VK_SPACE:
    		//System.out.println("RIGHT");
    		return pressed ? Input.PRESSED_SPACE : Input.RELEASED_SPACE;
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
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
