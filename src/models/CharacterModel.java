package models;

import controllers.CharacterController.Direction;

public class CharacterModel extends EntityModel
{
	public CharacterModel(long ID, int charID)
	{
		super(ID);
		this.charID = charID;
		setEnergy(0);
		setDirection(Direction.UP);
	}
	private int energy;
	private Direction direction;
	private final int charID;
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public int getCharID() {
		return charID;
	}
	
}
