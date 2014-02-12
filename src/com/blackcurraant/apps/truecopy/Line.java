package com.blackcurraant.apps.truecopy;

import java.util.ArrayList;

public class Line {
	
	public ArrayList<Word> Words = new ArrayList<Word>();
	public LayoutDefinition layout;
	
	public Line(LayoutDefinition layout){
		this.layout=layout;
	}
	
	public boolean addWord(String word){
		
		if (getLength() + word.length() < layout.charsperline ){
			Word w = new Word(word);
			Words.add(w);
			return true;
		}
		else {
			return false ;
		}
	}
	

	
	public Word getWord(int index){
		return Words.get(index);
	}
	
	
	public int getLength(){
		int length = 0;
		for (int i = 0 ; i <Words.size() ; i++ ){
			length = length + Words.get(i).getLength();
		}
		return length + (Words.size() - 1) ;		//account for spaces
	}
}
