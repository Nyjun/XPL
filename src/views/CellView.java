package views;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.Map.TerrainType;

public class CellView extends JPanel
{
	public CellView()
	{
		super();
		label = new JLabel();

		this.setOpaque(true);
		setCellContent(' ');
		setTerrain(TerrainType.VOID);
		selected = false;
	}
	
	protected JLabel label;
	private boolean selected;
	protected TerrainType terrain;
	public void setCellContent(char c)
	{
		label.setText(Character.toString(c));
	}
	public char getCellContent()
	{
		return label.getText().charAt(0);
	}

	public TerrainType getTerrain()
	{
		return terrain;
	}
	public void setTerrain(TerrainType terrain)
	{
		this.terrain = terrain;
		label.setBackground(terrainToColor(terrain));
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
			label.setBorder(null);
		else
			label.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		selected = !selected;
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
				return Color.GREEN;
			case ROCK:
				return Color.LIGHT_GRAY;
			case WATER:
				return Color.CYAN;
			case BORDER:
				return Color.DARK_GRAY;
			default:
				return Color.BLACK;
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
