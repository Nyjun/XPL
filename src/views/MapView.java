package views;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MapView extends JPanel
{
	public MapView(int sizeX, int sizeY, CharacterView charView)
	{
		super();
		setLayout(new GridLayout(sizeX, sizeY));
		this.setViewWidth(sizeX);
		this.setViewHeight(sizeY);
		map = new CellView[sizeX][sizeY];
		for (int i = 0; i < sizeX; i++)
		{
			for (int j = 0; j < sizeY; j++)
			{
				if (i == sizeX/2 && j == sizeY/2)
				{
					characterView = charView;
					map[j][i] = characterView;
				}
				else
				{
					map[j][i] = new CellView();
				}
				super.add(map[j][i]);
			}
		}

	}

	private CellView[][] map;
	private int viewWidth;
	private int viewHeight;
	private CharacterView characterView;
	
	public CellView getCell(int x, int y)
	{
		return map[x][y];
	}
	public void setCell(int x, int y, CellView cell)
	{
		map[x][y] = cell;
	}
	public CharacterView getCharacterView()
	{
		return characterView;
	}
	
	public void update()
	{
		for (int i = 0; i < viewWidth; i++)
		{
			for (int j = 0; j < viewWidth; j++)
			{
				map[i][j].update();
				//System.out.printf("[%d,%d] Color: %s Type: %s || ", i, j, map[i][j].getBackground().toString(), map[i][j].getTerrain().toString());
			}
		}
	}

	public int getViewWidth() {
		return viewWidth;
	}
	public void setViewWidth(int width) {
		this.viewWidth = width;
	}
	public int getViewHeight() {
		return viewHeight;
	}
	public void setViewHeight(int height) {
		this.viewHeight = height;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
