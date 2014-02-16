package com.blackcurraant.apps.truecopy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class BitmapStore {
	static String path = Environment.getExternalStorageDirectory() +"/" + "TC" + "/" ;
	
	public enum Case {UPPER,LOWER}
	public enum Connection {LEFT,CENTRE,RIGHT}

	public static Bitmap getBitmap(char c,Case lettercase,Connection connection){
	
		if (connection == Connection.CENTRE){
		
			Bitmap bMap = BitmapFactory.decodeFile(path + c +"CENTRE.png");
			return bMap;
			
		}
		if (connection ==Connection.LEFT){
			
			
		}
		if (connection == Connection.RIGHT){
			
			
		}
		return null;
	}
}
