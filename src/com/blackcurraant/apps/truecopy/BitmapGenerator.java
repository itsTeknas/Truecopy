package com.blackcurraant.apps.truecopy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class BitmapGenerator {

	public static Bitmap generateBitmap(Path path){
		
		int end = 0 ;
		int start = 0;
		int exit = 0;
		
		
		Bitmap scr = Bitmap.createBitmap(720, 500, Bitmap.Config.ARGB_8888);
		Canvas can = new Canvas(scr);
		Paint paint = new Paint();
		
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(5);
		
		can.drawPath(path, paint);
		
		for (int x =0 ; x<scr.getWidth()-1 ; x+=5 ){
			for (int y = 0 ; y<scr.getHeight()-1;y++){
				if (scr.getPixel(x, y)==Color.BLACK){
					start = x;
					exit =1;
				}
				if (exit == 1) break;
			}
			if (exit==1)break;
		}
		exit=0;
		for (int x = scr.getWidth()-1 ; x>=0 ; x-=5){
			for(int y = 0;y<scr.getHeight()-1 ; y++){
				if(scr.getPixel(x, y)==Color.BLACK){
					end = x;
					exit=1;
					if (exit==1) break;
				}
				if(exit==1) break;
			}
		}
		// improve cropping algorithm based on binary search.
		
		Bitmap cropped = Bitmap.createBitmap(scr, start, 0, end - start  , scr.getHeight());
		
		return cropped;
	}
}
