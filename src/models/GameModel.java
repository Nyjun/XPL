package models;

public class GameModel
{
	public GameModel()
	{
		map = new MapModel(15, 15);
	}
	
	private MapModel map;
	public MapModel getMap()
	{
		return map;
	}
	public void setMap(MapModel map)
	{
		this.map = map;
	}

	
}
