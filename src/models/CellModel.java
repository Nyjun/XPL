package models;

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
	
	private EntityModel content;
	public EntityModel getContent()
	{
		return content;
	}
	public void setContent(EntityModel entity)
	{
		this.content = entity;
	}
}
