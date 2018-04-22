package com.tamaproject.entity;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.input.touch.TouchEvent;

import java.util.ArrayList;

/**
 * The backpack stores the user's items and manages the positions at which the items are displayed in the game
 * 
 * @author Jonathan
 * 
 */
public class Backpack
{
    private ArrayList<Item> items;
	private ArrayList<Entity> itemPages = new ArrayList<Entity>();
    private final int MAX_SIZE = 113; // max number of items backpack can hold
    private boolean backpackOpen = false;

    public Backpack(ArrayList<Item> items)
    {
	this.items = items;
    }

    public Backpack()
    {
	this.items = new ArrayList<Item>();
    }

    /**
     * Adds an item to the backpack.
     * 
     * @param item
     * @return true if item was added, false if backpack is full and item not added
     */
    public boolean addItem(Item item)
    {
	synchronized (items)
	{
	    if (items.size() == MAX_SIZE)
	    {
		return false;
	    }
	    else
	    {
		items.add(item);
		return true;
	    }
	}
    }

    public int numItems()
    {
	return items.size();
    }

    public int maxSize()
    {
	return MAX_SIZE;
    }

    /**
     * Removes an item from the backpack.
     * 
     * @param item
     * @return true if successfully removed, false if not
     */
    public boolean removeItem(Item item)
    {
	synchronized (items)
	{
	    if (items.remove(item))
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
    }

    public boolean isBackpackOpen()
    {
	return backpackOpen;
    }

    public void setBackpackOpen(boolean backpackOpen)
    {
	this.backpackOpen = backpackOpen;
    }

    public ArrayList<Item> getItems()
    {
	return items;
    }

    public void setItems(ArrayList<Item> items)
    {
	this.items = items;
    }

    /**
     * Puts all the items in a grid formation for when the user opens the backpack to view the items
     * 
     * @param width
     *            Width of the screen.
     * @param height
     *            Height of the screen.
     */
    public void resetPositions(float width, float height)
    {
	float xSpacing = width / 11;
	float ySpacing = height / 13;
	int count = 0;
	int size = items.size();
	try
	{
	    for (int i = 1; i <= 13; i++) //was 6
	    {
		for (int j = 1; j <= 10; j++) //was 5
		{
		    items.get(count).setPosition((xSpacing * j) - items.get(count).getWidth() / 2, (ySpacing * i) - items.get(i).getHeight() / 2);
		    if (++count > size - 1)
			return;
		}
	    }
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }




}
