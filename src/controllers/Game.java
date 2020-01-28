package controllers;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import models.GameModel;
import models.MapModel;
import views.GameView;
import views.MapView;

public class Game
{
	private static final int SPAWN_RATE = 20;
	
	public enum Input
	{
		PRESSED_UP,
		PRESSED_DOWN,
		PRESSED_LEFT,
		PRESSED_RIGHT,
		RELEASED_UP,
		RELEASED_DOWN,
		RELEASED_LEFT,
		RELEASED_RIGHT,
		PRESSED_NULL,
		RELEASED_NULL
	}
	
	public Game(GameModel model, GameView view)
	{
		inputQueue = new ConcurrentLinkedQueue<Input>();
		running = false;
		gameModel = model;
		gameView = view;
		gameView.init(this);
		map = new Map(gameModel.getMap(), gameView.getMapView());
		character = new CharacterController(gameView.getCharacterView());
		map.addEntity(character, 	map.getMapModel().getWidth()/2,
									map.getMapModel().getHeight()/2);
		
		gameLoop = new Thread(
			new Runnable()
			{
				@Override
				public void run()
				{
					running = true;
					try
					{
						System.out.println("Game start !");
						while (running)
						{
							long millis = System.currentTimeMillis();
						    
							while (inputQueue.peek() != null)
							{
								handleInput(inputQueue.remove());
							}
							
							map.updateView();
							//System.out.println("Update...");
						    Thread.sleep(100 - millis % 100);
						}
						System.out.println("Game stopped...");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						System.out.println("Ending game...");
					}
				}
			});
		gameLoop.run();
	}
	private Map map;
	
	private GameModel gameModel;
	private GameView gameView;
	
	private CharacterController character;

	private boolean running;
	private Thread gameLoop;
	
	/// INPUT HANDLING ///
	private Queue<Input> inputQueue;
	private Input prevInput;
	public void addInput(Input input)
	{
		//if (prevInput != input)
		//{
			inputQueue.add(input);
		//	prevInput = input;
		//}
			
	}
	private void handleInput(Input input)
	{
		switch (input)
		{
		case PRESSED_DOWN:
			moveEntity(character, 0, 1);
			break;
		case PRESSED_UP:
			moveEntity(character, 0, -1);
			break;
		case PRESSED_LEFT:
			moveEntity(character, -1, 0);
			break;
		case PRESSED_RIGHT:
			moveEntity(character, 1, 0);
			break;
		default:
			break;
		}
	}
	
	/// ACTIONS ///
	public void moveEntity(Entity ent, int x, int y)
	{
		map.moveEntity(ent, x, y);
	}
	
	public void generateEnergy()
	{
		
	}
	
	
	public void stopGame()
	{
		running = false;
	}
}
