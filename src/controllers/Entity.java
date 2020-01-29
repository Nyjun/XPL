package controllers;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import models.CellModel;
import models.EntityModel;
import views.EntityView;

public abstract class Entity
{
	private static long nbEntity = 0;
	private static HashMap<Long, Entity> entities = new HashMap<Long, Entity>();
	private static Queue<Entity> destroyedEntities = new ConcurrentLinkedQueue<Entity>();
	public static void destroy(Entity entity)
	{
		destroyedEntities.add(entity);
	}
	public static Entity getEntity(long ID)
	{
		return entities.get(ID);
	}
	public static void updateEntities()
	{
		for (Entity ent : entities.values())
		{
			ent.update();
		}
		while (destroyedEntities.peek() != null)
		{
			Entity ent = destroyedEntities.remove();
			ent.getCurrentCell().removeEntity(ent.getModel());
			entities.remove(ent.getID());
		}
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
	private CellModel currentCell;
	
	protected abstract EntityModel createModel(long ID);
	protected abstract void update();

	public CellModel getCurrentCell() {
		return currentCell;
	}
	public void setCell(CellModel currentCell)
	{
		this.currentCell = currentCell;
		setX(currentCell.getX());
		setY(currentCell.getY());
	}
	public int getX()
	{
		return model.getX();
	}
	private void setX(int x)
	{
		model.setX(x);
	}
	public int getY()
	{
		return model.getY();
	}
	private void setY(int y)
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
