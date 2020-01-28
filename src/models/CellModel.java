package models;

import java.util.ArrayList;

import controllers.Map.TerrainType;

public class CellModel
{
	private static final TerrainType DEFAULT = TerrainType.GRASS;
	
	public CellModel()
	{
		this(DEFAULT);
	}
	public CellModel(TerrainType terrain)
	{
		this.content = new ArrayList<EntityModel>();
		this.terrain = terrain;
	}
	
	private TerrainType terrain;
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
}
