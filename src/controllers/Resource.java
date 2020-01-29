package controllers;

import models.EntityModel;
import models.ResourceModel;
import views.ResourceView;

public class Resource extends Entity
{
	public Resource(ResourceView view)
	{
		super(view);
	}
	@Override
	protected EntityModel createModel(long ID)
	{
		return new ResourceModel(ID);
	}
	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}
}
