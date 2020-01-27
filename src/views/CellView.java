package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.Map.TerrainType;

public class CellView extends JPanel
{
	public CellView()
	{
		super();
		this.setLayout(new BorderLayout());
		label = new JLabel();
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label, BorderLayout.CENTER);

		this.setOpaque(true);
		selected = false;
		setCellContent(' ');
		setTerrain(TerrainType.VOID);
	}
	
	protected JLabel label;
	private boolean selected;
	protected TerrainType terrain;
	public void setCellContent(char c)
	{
		label.setText(Character.toString(c));
		revalidate();
		repaint();
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
