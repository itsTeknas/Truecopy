package com.blackcurraant.apps.truecopy;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class PageBuilder {
	private PageContainer pageContainer;
	private ArrayList <Canvas> pages = new ArrayList<Canvas>();
	private ArrayList <Bitmap> images = new ArrayList <Bitmap>();
	private LayoutDefinition layout;
	
	
	
	PageBuilder (PageContainer pageContainer){
		this.pageContainer = pageContainer;
		LayoutDefinition layout = pageContainer.getLayout();
		int pagewidth  = layout.xpixels;
		int pageheight = layout.ypixels;
		
		//initialize all pages with empty canvas
		for (int i = 0 ; i < pageContainer.getPageCount() ; i++){
			
			images.add(Bitmap.createBitmap(pagewidth, pageheight, Bitmap.Config.ARGB_8888 ));
			pages.add(new Canvas(images.get(i)));
			
		}
		
		int x=0,y=0,i=0;
		Bitmap b;
		int bitmapheight =(int) ( layout.lineheight * (1.50) ) ;
		//initilize based on layout
		
		x = layout.leftmargin;
		y = layout.topmargin;
		//y = y + (int)(layout.lineheight * 0.15);
		Paint p = new Paint();
		
		for (Page page : pageContainer.Pages){
			Canvas edit = pages.get(i);
			
			for(Line line : page.Lines){
				
				for(Word word : line.Words){
					
					word.getFirstChar();
					b = BitmapGenerator.generateBitmap(new Path());
					//get right connected
					b = scaleBitmap(b,bitmapheight);
					
					
					edit.drawBitmap(b, x , y, p);
					x = x + b.getWidth();
					
					char [] chars = word.getMiddleChars().toCharArray();
					for(char c : chars){
						b = BitmapGenerator.generateBitmap(new Path());
						//get middle
						b = scaleBitmap(b,bitmapheight);
						
						edit.drawBitmap(b, x , y, p);
						x = x + b.getWidth();
					}
					
					word.getLastChar();
					b = BitmapGenerator.generateBitmap(new Path());
					//get left connected
					b = scaleBitmap(b,bitmapheight);
					
					edit.drawBitmap(b, x , y, p);
					x = x + b.getWidth();
				
					//Deal with fullstop and comma
					if(word.ENDS_WITH_FULLSTOP = true){
						//insert fullstop
					}
					if(word.ENDS_WITH_COMMA = true ){
						//insert comma
					}
				}
								
				y = y + layout.lineheight ;
			}
			i++;
		}
		
	}
	
	public ArrayList <Bitmap> getImages(){
		return images;
	}
	
	public Bitmap scaleBitmap(Bitmap src,int height){
		
		float ratio = src.getHeight() / height;
		
		Bitmap.createScaledBitmap(src, (int)(src.getWidth()/ratio) , (int) (src.getHeight()/ratio) , false);
		
		return null;
	}
	

}
