package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.Entity;
import controllers.Map.TerrainType;

public class CellView extends JPanel
{
	public CellView()
	{
		super();
		this.setLayout(new BorderLayout());
		content = new ArrayList<EntityView>();

		this.setOpaque(true);
		selected = false;
		setTerrain(TerrainType.VOID);
	}
	public CellView(Color border, int thickness)
	{
		this();
		setBorder(new LineBorder(border, thickness));
	}
	
	private ArrayList<EntityView> content;
	private EntityView displayedEntity;
	private boolean selected;
	private TerrainType terrain;

	public ArrayList<EntityView> getContent()
	{
		return content;
	}
	public void setContent(ArrayList<Entity> entities)
	{
		this.content = entityToView(entities);
		this.removeAll();
		EntityView ev = getMaxPriorityEntity();
		if (ev != null)
			this.add(ev);
	}
	
	public TerrainType getTerrain()
	{
		return terrain;
	}
	public void setTerrain(TerrainType terrain)
	{
		this.terrain = terrain;
		//label.setBackground(terrainToColor(terrain));
		this.setBackground(terrainToColor(terrain));
		
	}
	public boolean isSelected()
	{
		return selected;
	}
	public void select(boolean selected)
	{
		this.selected = selected;
	}
	public void toggleSelected()
	{
		if (selected)
			setBorder(null);
		else
			setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		selected = !selected;
	}
	private void updateDisplayedEntity()
	{
		EntityView ev = getMaxPriorityEntity();
		if (ev == null)
		{
			if (displayedEntity != null)
				remove(displayedEntity);
		}
		else if(ev != displayedEntity)
		{
			if (displayedEntity != null)
				remove(displayedEntity);
			add(ev);
		}
	}
	public void update()
	{
		revalidate();
		repaint();
	}
	
	
	private EntityView getMaxPriorityEntity()
	{
		if (content.size() == 0)
			return null;
		EntityView max = content.get(0);
		for (EntityView ev : content)
		{
			if (max.getPriority() <= ev.getPriority())
				max = ev;
		}
		return max;
	}
	
	/// CONVERTERS ///
	private Color terrainToColor(TerrainType terrain)
	{
		switch(terrain)
		{
			case GRASS:
				return new Color(40, 125, 25);
			case ROCK:
				return Color.LIGHT_GRAY;
			case WATER:
				return Color.CYAN.darker();
			case BORDER:
				return Color.DARK_GRAY;
			default:
				return Color.BLACK;
		}
	}
	private ArrayList<EntityView> entityToView(ArrayList<Entity> entities)
	{
		ArrayList<EntityView> newContent = new ArrayList<EntityView>();
		for(Entity ent : entities)
		{
			newContent.add(ent.getView());
		}
		return newContent;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
