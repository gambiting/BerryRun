package com.example.blackberrytest;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player {
	private float x,y;
	public float size;
	private ArrayList<Coordinate> path;
	
	public static Paint pathPaint;
	
	public static Paint playerPaint;
	
	public static boolean pathValid=false;
	
	public static boolean isPathValid() {
		return pathValid;
	}

	public static void setPathValid(boolean pathValid) {
		Player.pathValid = pathValid;
	}
	public static int pathProgress=0;

	public Player()
	{
		path = new ArrayList<Coordinate>();
		playerPaint = new Paint();
		playerPaint.setColor(Color.RED);
		
		pathPaint = new Paint();
		pathPaint.setColor(Color.WHITE);
		pathPaint.setStrokeWidth(2f);
		this.x=50;
		this.y=384;
		this.size=20;
	}
	
	public void draw(Canvas canvas)
	{
		canvas.drawCircle(x, y, size, Player.playerPaint);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public ArrayList<Coordinate> getPath() {
		return path;
	}
	
	
	
	//publ

	
}
