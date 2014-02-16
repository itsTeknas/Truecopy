package com.blackcurraant.apps.truecopy;

//this is just a demo activity, has to be entirely rewritten

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		Button capture = (Button) findViewById(R.id.captureHandwriting);
		capture.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,Capture.class);
				startActivity(intent);
			}
			
		});
		Button build = (Button) findViewById(R.id.build);
		build.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				build();
			}
			
		});
		
	}
	public void build(){
		PageContainer pagecontainer = new PageContainer(new LayoutDefinition(20, 40, 15));
		pagecontainer.addText("WE ARE ABOUT TO ROCK YOUR WORLD");
		
		PageBuilder builder = new PageBuilder(pagecontainer);
		ArrayList <Bitmap> images = new ArrayList <Bitmap>();
		images = builder.getImages();
		
		LinearLayout root = (LinearLayout) findViewById(R.id.root);
		for (Bitmap image:images){
			ImageView im = new ImageView(this);
			im.setImageBitmap(image);
			root.addView(im);
		}
	}

}
