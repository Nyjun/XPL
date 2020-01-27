package views;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class CharacterView extends CellView
{
	public static final char PLAYER_CHAR = '@';
	public CharacterView()
	{
		super();
		setBorder(new LineBorder(Color.BLACK, 2));
		setCellContent(PLAYER_CHAR);
		revalidate();
		repaint();
	}
	
	public char getCellContent()
	{
		return PLAYER_CHAR;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
