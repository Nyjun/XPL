package models;

import java.util.ArrayList;

import controllers.Map.TerrainType;

public class CellModel
{
	private static final TerrainType DEFAULT = TerrainType.GRASS;
	
	public CellModel(int x, int y)
	{
		this(x, y, DEFAULT);
	}
	public CellModel(int x, int y, TerrainType terrain)
	{
		this.content = new ArrayList<EntityModel>();
		this.terrain = terrain;
		setX(x);
		setY(y);
	}
	
	private TerrainType terrain;
	private int x;
	private int y;
	
	public TerrainType getTerrain()
	{
		return terrain;
	}
	public void setTerrain(TerrainType terrain)
	{
		this.terrain = terrain;
	}
	
	public void addEntity(EntityModel entity)
	{
		if (!content.contains(entity))
		{
			content.add(entity);
		}
	}
	public void removeEntity(EntityModel entity)
	{
		content.remove(entity);
	}
	
	private ArrayList<EntityModel> content;
	public ArrayList<EntityModel> getContent()
	{
		return content;
	}
	public void setContent(ArrayList<EntityModel> content)
	{
		this.content = content;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
