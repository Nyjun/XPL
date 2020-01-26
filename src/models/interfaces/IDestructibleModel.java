package models.interfaces;

public interface IDestructibleModel
{
	public abstract int getMaxHP();
	public abstract int getHP();
	public abstract void setHP(int hp);
	public default void damage(int dmg)
	{
		setHP(getHP() - dmg);
	}
	public default void destroy()
	{
		damage(getHP());
	}
	public default boolean isDead()
	{
		return getHP() <= 0;
	}
}
