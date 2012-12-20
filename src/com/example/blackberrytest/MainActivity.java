package com.example.blackberrytest;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class MainActivity extends Activity {

	public static View gameview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.menu_view);

		
		ImageView menu = (ImageView)findViewById(R.id.menu);
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Thread myThread = new Thread(new UpdateThread());
				myThread.start();


				setContentView(R.layout.activity_main);

				MainActivity.gameview = (View)findViewById(R.id.gamecanvas);
				
			}
		});

		//load images
		InputStream is = this.getResources().openRawResource(R.drawable.bg);
		Support.backgroundImage = BitmapFactory.decodeStream(is);

		is = this.getResources().openRawResource(R.drawable.spaceship1);
		Support.enemyImage = BitmapFactory.decodeStream(is);

		is = this.getResources().openRawResource(R.drawable.barrel);
		Support.barrelImage = BitmapFactory.decodeStream(is);


		for(int i=0;i<20;i++)
		{
			Support.entities.add(new Stone((float)Math.round(Math.random()*1000)+120, (float)Math.round(Math.random()*400) + 100));
		}

		Support.entities.add(new Enemy(150,700));
		Support.entities.add(new Enemy(350,700));
		Support.entities.add(new Enemy(550,700));
		Support.entities.add(new Enemy(750,700));
		Support.entities.add(new Enemy(950,700));


		


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

class UpdateThread implements Runnable {

	@Override
	public void run() {
		while(true)
		{
			//update entities
			for(AbstractEntity entity:Support.entities)
			{

				entity.update();
			}



			if(Player.pathValid && Player.pathProgress<(Support.player.getPath().size()-1))
			{
				Support.player.setX(Support.player.getPath().get(Player.pathProgress).x);
				Support.player.setY(Support.player.getPath().get(Player.pathProgress).y);
				Player.pathProgress++;



				MainActivity.gameview.postInvalidate();

			}

			if(Player.pathValid && Player.pathProgress==(Support.player.getPath().size()-1))
			{
				Support.player.setX(50);
				Support.player.setY(384);
				Support.player.getPath().clear();
				
				Support.entities.clear();
				
				for(int i=0;i<20;i++)
				{
					Support.entities.add(new Stone((float)Math.round(Math.random()*1000)+120, (float)Math.round(Math.random()*400) + 100));
				}

				Support.entities.add(new Enemy(150,700));
				Support.entities.add(new Enemy(350,700));
				Support.entities.add(new Enemy(550,700));
				Support.entities.add(new Enemy(750,700));
				Support.entities.add(new Enemy(950,700));
				
				
				Player.pathProgress=0;
				Player.pathValid=false;
			}

			if(MainActivity.gameview!=null)
				MainActivity.gameview.postInvalidate();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}
}






