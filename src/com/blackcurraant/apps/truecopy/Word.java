package com.blackcurraant.apps.truecopy;


public class Word {
	
	private String word;
	public boolean ENDS_WITH_FULLSTOP = false;
	public boolean ENDS_WITH_COMMA = false;

	public String toString(){
		return word;
	}
	public Word(String word){
		this.word = word;
		if(word.endsWith(".")) ENDS_WITH_FULLSTOP = true;
		if(word.endsWith(",")) ENDS_WITH_COMMA = true;
	}
	public int getLength(){
		if (ENDS_WITH_FULLSTOP = true ) return word.length() - 1 ;
		if (ENDS_WITH_COMMA = true ) return word.length() - 1 ;
		return word.length();
	}
	public char getFirstChar(){
		return word.charAt(0);
	}
	public char getLastChar(){
		if (ENDS_WITH_FULLSTOP = true ) return word.charAt(word.length() - 2);
		if (ENDS_WITH_COMMA = true ) return word.charAt(word.length() - 2);
		return word.charAt(word.length()-1);
	}
	public String getMiddleChars(){
		
		if (word.length()>2){
		return word.substring(1,word.length()-1);
		}
		else{
			return "";
		}
		
		}
		
	
}
