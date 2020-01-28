package controllers;

import java.util.HashMap;

import models.EntityModel;
import views.EntityView;

public abstract class Entity
{
	private static long nbEntity = 0;
	private static HashMap<Integer, Entity> entities = new HashMap<Integer, Entity>();
	
	public Entity(EntityView view)
	{
		ID = nbEntity++;
		setModel(createModel(ID));
		setView(view);
	}
	
	private final long ID;
	private EntityModel model;
	private EntityView view;
	
	protected abstract EntityModel createModel(long ID);
	
	public int getX()
	{
		return model.getX();
	}
	public void setX(int x)
	{
		model.setX(x);
	}
	public int getY()
	{
		return model.getY();
	}
	public void setY(int y)
	{
		model.setY(y);
	}
	public EntityModel getModel() {
		return model;
	}
	public void setModel(EntityModel model) {
		this.model = model;
	}
	public EntityView getView() {
		return view;
	}
	public void setView(EntityView view) {
		this.view = view;
	}
	public long getID() {
		return ID;
	}
}
