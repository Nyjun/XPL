package controllers;

import java.util.Hashtable;

import models.CharacterModel;
import views.CharacterView;

public class Character
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
	private static Hashtable<Integer, Character> characters = new Hashtable<Integer, Character>();
	public static Character getSelectedCharacter()
	{
		if (characters.containsKey(selectedCharacter))
		{
			return characters.get(selectedCharacter);
		}
		else
			return null;
	}
	
	
	public Character(CharacterModel model, CharacterView view)
	{
		id = nbCharacter++;
		setModel(model);
		setView(view);
		
		characters.put(id, this);
	}
	
	private CharacterModel model;
	private CharacterView view;
	private final int id;
	
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
