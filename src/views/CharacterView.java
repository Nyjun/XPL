package views;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class CharacterView extends CellView
{
	public static final char PLAYER_CHAR = '@';
	public CharacterView()
	{
		super();
		label.setBorder(new LineBorder(Color.BLACK, 2));
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
