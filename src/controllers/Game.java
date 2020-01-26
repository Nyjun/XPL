package controllers;

import models.GameModel;
import models.MapModel;
import views.GameView;
import views.MapView;

public class Game
{
	public Game(GameModel model, GameView view)
	{
		running = false;
		gameModel = model;
		gameView = view;
		map = new Map(gameModel.getMap(), gameView.getMapView());
		
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
						    
							map.updateView();
							//System.out.println("Update...");
						    Thread.sleep(100 - millis % 100);
						}
						
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

	private boolean running;
	private Thread gameLoop;
	
	public void stopGame()
	{
		running = false;
	}
}
