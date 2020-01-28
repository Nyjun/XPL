package views;

import javax.swing.JLabel;

public abstract class EntityView extends JLabel
{

	public EntityView(char iconChar, int priority)
	{
		super();
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setIconChar(iconChar);
		setPriority(priority);
	}
	
	private int priority;

	public char getIconChar()
	{
		return getText().charAt(0);
	}
	public void setIconChar(char iconChar)
	{
		setText(Character.toString(iconChar));
		revalidate();
		repaint();
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
