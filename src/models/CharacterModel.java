package models;

import controllers.Character.Direction;

public class CharacterModel
{
	public CharacterModel(int x, int y)
	{
		setX(x);
		setY(y);
		setEnergy(0);
		setDirection(Direction.UP);
	}
	private int energy;
	private int x;
	private int y;
	private Direction direction;
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
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
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
