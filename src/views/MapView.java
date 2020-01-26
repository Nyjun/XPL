package views;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MapView extends JPanel
{
	public MapView(int sizeX, int sizeY)
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
					map[i][j] = new CharacterView();
				}
				else
				{
					map[i][j] = new CellView();
				}
				super.add(map[i][j]);
			}
		}

	}

	private CellView[][] map;
	private int viewWidth;
	private int viewHeight;
	
	public CellView getCell(int x, int y)
	{
		return map[x][y];
	}
	public void setCell(int x, int y, CellView cell)
	{
		map[x][y] = cell;
	}
	public CharacterView getCharacter()
	{
		return (CharacterView)map[viewWidth/2][viewHeight/2];
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
			System.out.println();
		}
		System.out.println();
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
