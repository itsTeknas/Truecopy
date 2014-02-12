package com.blackcurraant.apps.truecopy;

import java.util.ArrayList;

import android.util.Log;

public class Page {
	
	public ArrayList<Line> Lines = new ArrayList<Line>();
	public LayoutDefinition layout;
	
	public Page(LayoutDefinition layout){
		this.layout = layout;
	}
	
	public Line getLine(int index){
		return Lines.get(index);
	}
	
	public void Addline (Line a) {
		Lines.add(a);
	}
	
	public int getLineCount(){
		return Lines.size();
	}
	
	public boolean addText(String word){
		int i = Lines.size();
		if( i < layout.linecount ){
		
			if(i==0){
				Line l = new Line(layout);
				l.addWord(word);
				Lines.add(l);
				
			}
			else {
				
				if (Lines.get(i-1).addWord(word) == true ){}
				else{
					Line l = new Line(layout);
					l.addWord(word);
					Lines.add(l);
					
				}
			}
			return true;
		}
		Log.v("Page Full", "Creating new page");
		return false;
	}

}
