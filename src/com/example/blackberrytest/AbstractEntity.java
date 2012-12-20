package com.example.blackberrytest;

import android.graphics.Canvas;

public abstract class AbstractEntity {
	
	private float x,y;
	private float size;
	private float speedX=0,speedY=0;
	
	
	public abstract void draw(Canvas canvas);
	
	public abstract void update();
	
	
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
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}


	public float getSize() {
		return size;
	}


	public void setSize(float size) {
		this.size = size;
	}
	
	

}
