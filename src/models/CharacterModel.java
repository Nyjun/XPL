package models;

import controllers.CharacterController.Direction;

public class CharacterModel extends EntityModel
{
	public CharacterModel(long ID)
	{
		super(ID);
		setEnergy(0);
		setDirection(Direction.UP);
	}
	private int energy;
	private Direction direction;
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public void changeEnergy(int energy)
	{
		this.energy += energy;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}
