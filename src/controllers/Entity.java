package controllers;

import java.util.HashMap;

public abstract class Entity
{
	private static long nbEntity = 0;
	private static HashMap<Integer, Entity> entities = new HashMap<Integer, Entity>();
	
	public Entity()
	{
		entID = nbEntity++;
	}
	
	private final long entID;
}
