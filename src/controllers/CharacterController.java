package controllers;

import models.CharacterModel;
import models.EntityModel;
import views.CharacterView;

public class CharacterController extends Entity
{
	public enum Direction
	{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	private static long selectedCharacter = 0;
	public static CharacterController getSelectedCharacter()
	{
		return (CharacterController)Entity.getEntity(selectedCharacter);
	}
	
	public CharacterController(CharacterView view)
	{
		super(view);
		setView(view);
	}
	@Override
	protected EntityModel createModel(long ID)
	{
		return new CharacterModel(ID);
	}
	
	@Override
	protected void update()
	{
		for (EntityModel em : this.getCurrentCell().getContent())
		{
			Entity ent = getEntity(em.getID());
			if (ent instanceof Resource)
			{
				this.getModel().changeEnergy(1);
				Entity.destroy(ent);
				System.out.println(getModel().getEnergy());
			}
		}
	}
	
	public CharacterModel getModel() {
		return (CharacterModel)super.getModel();
	}
	public void setModel(CharacterModel model) {
		super.setModel(model);
	}
	public CharacterView getView() {
		return (CharacterView)super.getView();
	}
	public void setView(CharacterView view) {
		super.setView(view);;
	}
}
