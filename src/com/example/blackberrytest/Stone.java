package com.example.blackberrytest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Stone extends AbstractEntity {
	
	public static int defaultLife = 100;
	public static Paint paint;
	
	private int life;
	
	public Stone(float x, float y)
	{
		this.setX(x);
		this.setY(y);
		
		this.setSize(30);
		init();
	}
	
	
	public Stone()
	{
		init();
	}
	
	public void init()
	{
		life = Stone.defaultLife;
		paint = new Paint();
		paint.setColor(Color.GRAY);
		this.setSize(20);
	}
	
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(Support.barrelImage, this.getX()-this.getSize(), this.getY()-this.getSize(), new Paint());
		
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
