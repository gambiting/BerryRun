package com.example.blackberrytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

	float mod=0.0f;

	int playerX=100,playerY=100;

	public GameView(Context context) {
		super(context);
	}

	public GameView(final Context context, final AttributeSet attrs){
		super(context, attrs);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);

		mod+=0.1f;

		//draw background
		if(Support.backgroundImage!=null)
			canvas.drawBitmap(Support.backgroundImage, 0, 0, new Paint());

		//start zone
		Paint startZonePaint = new Paint();
		startZonePaint.setColor(Color.RED);
		startZonePaint.setStrokeWidth(2f);
		canvas.drawLine(Support.startZone, 0, Support.startZone, 768, startZonePaint);

		//end zone
		Paint endZonePaint = new Paint();
		endZonePaint.setColor(Color.GREEN);
		startZonePaint.setStrokeWidth(2f);
		canvas.drawLine(Support.endZone, 0, Support.endZone, 768, endZonePaint);


		//draw player
		Support.player.draw(canvas);


		//draw line
		if(Support.player.getPath().size()>1)
		{
			for(int i=1;i<Support.player.getPath().size();i++)
			{

				canvas.drawLine(Support.player.getPath().get(i-1).x, Support.player.getPath().get(i-1).y,
						Support.player.getPath().get(i).x, Support.player.getPath().get(i).y,
						Player.pathPaint);
			}

		}



		//draw entities
		for(AbstractEntity entity:Support.entities)
		{
			entity.draw(canvas);
		}


		


	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//playerX=(int) event.getX();
		//playerY=(int) event.getY();
		if( !Player.isPathValid() )
		{
			if(event.getAction() == MotionEvent.ACTION_DOWN && Support.player.getPath().size()>0 )
			{
				Support.player.getPath().clear();
				Player.pathPaint.setColor(Color.WHITE);
			}
			Support.player.getPath().add(new Coordinate((int)event.getX(),(int)event.getY()));

			if(event.getAction() == MotionEvent.ACTION_UP && Support.player.getPath().size()>0)
			{


				Player.pathValid = Support.validatePath(); 


			}

			this.postInvalidate();
		}
		return true;
	}







}
