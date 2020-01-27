package controllers;

import java.util.HashMap;

import models.CharacterModel;
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
		id = nbCharacter++;
		setModel(new CharacterModel(posX, posY, id));
		setView(view);
		
		characters.put(id, this);
	}
	
	private CharacterModel model;
	private CharacterView view;
	private final int id;
	
	public void move(int x, int y)
	{
		setX(getX() + x);
		setY(getY() + y);
		System.out.printf("[%d, %d]\n", getX(), getY());
	}
	
	public int getX()
	{
		return model.getX();
	}
	public void setX(int x)
	{
		model.setX(x);
	}
	public int getY()
	{
		return model.getY();
	}
	public void setY(int y)
	{
		model.setY(y);
	}
	
	public CharacterModel getModel() {
		return model;
	}
	public void setModel(CharacterModel model) {
		this.model = model;
	}
	public CharacterView getView() {
		return view;
	}
	public void setView(CharacterView view) {
		this.view = view;
	}
}
