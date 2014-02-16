package com.blackcurraant.apps.truecopy;

public class LayoutDefinition {
	
	public int DENSITY = 100;
	
	public int xcm = 0;
	public int ycm = 0;
	public int xpixels = 0;
	public int ypixels = 0;
	public int linecount = 0;
	public int lineheight = 0;
	public int leftmargin = 0;
	public int rightmarging = 0;
	public int bottommargin = 0;
	public int topmargin = 0;
	public int charsperline = 0;
	
	public LayoutDefinition(int xcm,int ycm, int linecount){
		
		this.xcm = xcm;
		this.ycm = ycm;
		this.linecount = linecount;
		
		xpixels = xcm * 40;
		ypixels = ycm * 40;
		
		lineheight = (ypixels - bottommargin - topmargin)/linecount ;
		
		charsperline = xcm / (ycm/linecount) ;
		//charsperline = 100;
	}
	
	
}
