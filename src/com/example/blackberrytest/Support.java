package com.example.blackberrytest;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class Support {
	
	public static ArrayList<AbstractEntity> entities = new ArrayList<AbstractEntity>();
	public static ArrayList<AbstractEntity> entitiesToAdd = new ArrayList<AbstractEntity>();
	public static ArrayList<AbstractEntity> entitiesToRemove = new ArrayList<AbstractEntity>();
	public static Player player = new Player();
	
	public static int startZone=100;
	public static int endZone = 1180;
	
	
	public static Bitmap backgroundImage;
	public static Bitmap enemyImage;
	public static Bitmap barrelImage;
	
	public static boolean validatePath()
	{
		//check if the line begins close to the player
		if(Support.distance(Support.player.getPath().get(0).x, Support.player.getPath().get(0).y, Support.player.getX(), Support.player.getY())< 100.0)
		{
			Support.player.getPath().set(0, new Coordinate((int)Support.player.getX(),(int)Support.player.getY()));
		}else
		{
			Player.pathPaint.setColor(Color.RED);
			Player.setPathValid(false);
			return false;
		}
		
		for(Coordinate c:Support.player.getPath())
		{
			for(AbstractEntity e:Support.entities)
			{
				if(Support.distance(c.x, c.y, e.getX(), e.getY())< (Support.player.size+e.getSize()))
				{
					Player.pathPaint.setColor(Color.RED);
					Player.setPathValid(false);
					return false;
				}
			}
		}
		
		//check if the line ends in the finish zone
		if(Support.player.getPath().get(Support.player.getPath().size()-1).x<Support.endZone)
		{
			Player.pathPaint.setColor(Color.RED);
			Player.setPathValid(false);
			return false;
		}
		
		return true;
	}
	
	public static float distance(float x1,float y1, float x2, float y2)
	{
		return (float)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
	

}
