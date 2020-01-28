package views;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class CharacterView extends EntityView
{
	public static final char PLAYER_CHAR = '@';
	public CharacterView()
	{
		super(PLAYER_CHAR, 0);
		//setBorder(new LineBorder(Color.BLACK, 2));
		revalidate();
		repaint();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
