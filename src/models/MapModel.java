package models;

import controllers.Map.TerrainType;

public class MapModel
{
	
	public MapModel(int width, int height)
	{
		this.width = width;
		this.height = height;
		setMap(createMap());
	}

	private final int width; //Size without outer border;
	private final int height; //Size without outer border;
	private CellModel[][] map;
	public void setMap(CellModel[][] map)
	{
		this.map = map;
	}
	public CellModel[][] getMap()
	{
		return map;
	}
	public CellModel[][] createMap()
	{
		CellModel[][] newMap = new CellModel[getWidth()][getHeight()];
		for(int i = 0; i < getWidth(); i++)
		{
			for (int j = 0; j < getHeight(); j++)
			{
				if (i == 0 || j == 0 || i == getWidth() - 1 || j == getHeight() - 1)
					newMap[i][j] = new CellModel(i, j, TerrainType.BORDER);
				else
					newMap[i][j] = new CellModel(i, j);
			}
		}
		return newMap;
	}
	public CellModel getCell(int x, int y)
	{
		return map[x][y];
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
//	public void setWidth(int width) {
//		this.width = width + 1;
//	}
//	public void setHeight(int height) {
//		this.height = height + 1;
//	}
}
