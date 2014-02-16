package com.blackcurraant.apps.truecopy;


import java.io.File;
import java.io.FileOutputStream;


import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Capture extends Activity 
{
	String letters[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
	int count=0;
	GestureOverlayView gs;
	Path path1;
	TextView letter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture);
		gs=(GestureOverlayView)findViewById(R.id.signaturePad);
		letter=(TextView)findViewById(R.id.letter);
		letter.setText(letters[count]);
		
	}
	
	
	public void clear(View v)
	{
		
		gs.clear(true);
	}


	public void save(View v)
	{	
	path1 = gs.getGesturePath();
	Bitmap alphabet = BitmapGenerator.generateBitmap(path1);
	try
	{
		//String name= "Letter"+letters[count];
		String filename = letters[count] + "CENTRE" + ".png";
		String path =  Environment.getExternalStorageDirectory() +"/" + "TC" + "/";
		Log.v(path, path);
		
		File tempdir = new File(path);
        //if (!tempdir.exists())
            tempdir.mkdirs();
		
		
		
		File f = new File(path + filename);
		f.createNewFile();
		FileOutputStream os = new FileOutputStream(f);
		alphabet.compress(Bitmap.CompressFormat.PNG,100,os);
		os.close();
	}
	catch(Exception e){}
	gs.clear(true);
	if(count<letters.length-1)
	letter.setText(letters[++count]);
	else
	{
		Toast.makeText(this,"Training Completed",Toast.LENGTH_LONG).show();
	}
	
	}

	public void set(View v)
	{
		
	
	}
	

}
