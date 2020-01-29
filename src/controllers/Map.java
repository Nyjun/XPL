package controllers;

import java.util.ArrayList;

import models.CellModel;
import models.EntityModel;
import models.MapModel;
import views.MapView;

public class Map
{
	public enum TerrainType
	{
		GRASS,
		ROCK,
		WATER,
		BORDER,
		VOID
	}
	public Map(MapModel mapModel, MapView mapView)
	{
		setMapModel(mapModel);
		setMapView(mapView);
	}
	
	private MapModel mapModel;
	private MapView mapView;
	
	public void addEntity(Entity ent, int x, int y)
	{
		if (x >= 0 && x < mapModel.getWidth() && y >= 0 && y < mapModel.getHeight())
		{
			mapModel.getCell(x, y).addEntity(ent.getModel());
			ent.setCell(mapModel.getCell(x, y));
		}
	}
	public void moveEntity(Entity ent, int x, int y)
	{
		if (mapModel.getCell(ent.getX(), ent.getY()).getContent().contains(ent.getModel()))
		{
			
			if (ent.getX() + x >= 0 && ent.getX() + x < mapModel.getWidth() && ent.getY() + y >= 0 && ent.getY() + y < mapModel.getHeight())
			{
				mapModel.getCell(ent.getX(), ent.getY()).removeEntity(ent.getModel());
				mapModel.getCell(ent.getX() + x, ent.getY() + y).addEntity(ent.getModel());
				ent.setCell(mapModel.getCell(ent.getX() + x, ent.getY() + y));
			}
		}
	}
	public void removeEntity(Entity ent)
	{
		if (mapModel.getCell(ent.getX(), ent.getY()).getContent().contains(ent.getModel()))
		{
			mapModel.getCell(ent.getX(), ent.getY()).removeEntity(ent.getModel());
		}
	}
	
	public void updateView()
	{
		for (int i = 0; i < mapView.getViewWidth(); i++)
		{
			for (int j = 0; j < mapView.getViewHeight(); j++)
			{
				int x =  - mapView.getViewWidth() / 2 + i;
				int y =  - mapView.getViewHeight() / 2 + j;
				if (CharacterController.getSelectedCharacter() != null)
				{
					x += CharacterController.getSelectedCharacter().getX();
					y += CharacterController.getSelectedCharacter().getY();
				}
				else
				{
//					x += mapModel.getWidth()/2;
//					y += mapModel.getHeight()/2;
					x += 1;
					y += 1;
				}
				if (x < 0 || x >= mapModel.getWidth() || y < 0 || y >= mapModel.getHeight())
				{
					mapView.getCell(i, j).setTerrain(TerrainType.VOID);
					mapView.getCell(i, j).setContent(new ArrayList<Entity>());
				}
				else
				{
					mapView.getCell(i, j).setTerrain(mapModel.getCell(x, y).getTerrain());
					mapView.getCell(i, j).setContent(getCellContent(mapModel.getCell(x, y)));
				}
			}
		}
		mapView.update();
	}
	
	private ArrayList<Entity> getCellContent(CellModel cell)
	{
		ArrayList<Entity> cellContent = new ArrayList<Entity>();
		for(EntityModel ent : cell.getContent())
		{
			Entity e = Entity.getEntity(ent.getID());
			if (e != null)
			{
				cellContent.add(e);
				//System.out.println("Entity" + ent.getID());
			}
		}
		return cellContent;
	}
	
	public MapModel getMapModel() {
		return mapModel;
	}
	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}
	public MapView getMapView() {
		return mapView;
	}
	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
}
