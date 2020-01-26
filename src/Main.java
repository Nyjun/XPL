
import controllers.Game;
import models.GameModel;
import views.GameView;

public class Main {

	public static void main(String[] args)
	{
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView();
		Game game = new Game(gameModel, gameView);
		

	}

}
