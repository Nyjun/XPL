package controllers;

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
	
	public void updateView()
	{
		for (int i = 0; i < mapView.getViewWidth(); i++)
		{
			for (int j = 0; j < mapView.getViewHeight(); j++)
			{
				int x =  - mapView.getViewWidth() / 2 + i;
				int y =  - mapView.getViewHeight() / 2 + j;
				if (Character.getSelectedCharacter() != null)
				{
					x += Character.getSelectedCharacter().getX();
					y += Character.getSelectedCharacter().getY();
				}
				else
				{
//					x += mapModel.getWidth()/2;
//					y += mapModel.getHeight()/2;
					x += 1;
					y += 1;
				}
				if (x < 0 || x >= mapModel.getWidth() || y < 0 || y >= mapModel.getHeight())
					mapView.getCell(i, j).setTerrain(TerrainType.VOID);
				else
				{
					mapView.getCell(i, j).setTerrain(mapModel.getCell(x, y).getTerrain());
				}
			}
		}
		mapView.update();
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
