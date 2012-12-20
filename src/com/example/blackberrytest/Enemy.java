package com.example.blackberrytest;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Enemy extends AbstractEntity {


	public Enemy(float x, float y)
	{
		this.setX(x);
		this.setY(y);
		this.setSize(30);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(Support.enemyImage, this.getX()-this.getSize(), this.getY()-this.getSize(), new Paint());

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
