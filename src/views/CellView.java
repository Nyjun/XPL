package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

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
	
	protected ArrayList<EntityView> content;
	protected EntityView displayedEntity;
	private boolean selected;
	protected TerrainType terrain;
	public void addEntity(EntityView entity)
	{
		content.add(entity);
		if (entity.getPriority() >= displayedEntity.getPriority())
			updateDisplayedEntity();
	}
	public void removeEntity(EntityView entity)
	{
		content.remove(entity);
		updateDisplayedEntity();
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
	public void updateDisplayedEntity()
	{
		EntityView ev = getMaxPriorityEntity();
		if (ev == null)
		{
			remove(displayedEntity);
		}
		else if(ev != displayedEntity)
		{
			remove(displayedEntity);
			add(ev);
		}
	}
	public void update()
	{
		revalidate();
		repaint();
	}
	
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
