package controllers;

import java.util.HashMap;

import models.EntityModel;
import views.EntityView;

public abstract class Entity
{
	private static long nbEntity = 0;
	private static HashMap<Long, Entity> entities = new HashMap<Long, Entity>();
	public static Entity getEntity(long ID)
	{
		return entities.get(ID);
	}
	
	public Entity(EntityView view)
	{
		ID = nbEntity++;
		setModel(createModel(ID));
		setView(view);
		entities.put(ID, this);
	}
	
	private final long ID;
	private EntityModel model;
	private EntityView view;
	private int visualPriority = 0;		//TODO: handling priorities
	private int logicalPriority = 0;
	
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

	public int getVisualPriority() {
		return visualPriority;
	}

	public void setVisualPriority(int visualPriority) {
		this.visualPriority = visualPriority;
	}

	public int getLogicalPriority() {
		return logicalPriority;
	}

	public void setLogicalPriority(int logicalPriority) {
		this.logicalPriority = logicalPriority;
	}
}
