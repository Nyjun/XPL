package models;

public abstract class EntityModel
{
	public EntityModel(long ID)
	{
		this.ID = ID;
	}
	
	protected int x;
	protected int y;
	protected final long ID;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public long getID() {
		return ID;
	}
}
