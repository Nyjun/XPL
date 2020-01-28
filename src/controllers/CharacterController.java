package controllers;

import java.util.HashMap;

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
	
	private static int nbCharacter = 0;
	private static int selectedCharacter = nbCharacter;
	private static HashMap<Integer, CharacterController> characters = new HashMap<Integer, CharacterController>();
	public static CharacterController getSelectedCharacter()
	{
		if (characters.containsKey(selectedCharacter))
		{
			return characters.get(selectedCharacter);
		}
		else
			return null;
	}
	
	
	public CharacterController(int posX, int posY, CharacterView view)
	{
		super(view);
		charID = getModel().getCharID();
		setX(posX);
		setY(posY);
		setView(view);
		
		characters.put(charID, this);
	}
	@Override
	protected EntityModel createModel(long ID)
	{
		return new CharacterModel(ID, nbCharacter++);
	}
	
	//private CharacterModel model;
	//private CharacterView view;
	private final int charID;
	
	public void move(int x, int y)
	{
		setX(getX() + x);
		setY(getY() + y);
		System.out.printf("[%d, %d]\n", getX(), getY());
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
