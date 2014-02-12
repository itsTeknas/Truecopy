package com.blackcurraant.apps.truecopy;

import java.util.ArrayList;

public class PageContainer {
	
	public LayoutDefinition layout;
	public ArrayList<Page> Pages = new ArrayList<Page>();
	
	public PageContainer(LayoutDefinition layout){
		
		this.layout = layout;
	}
	
	public LayoutDefinition getLayout(){
		return layout;
	}
	
	public Page getPage(int index){
		return Pages.get(index);
	}
	
	public void AddPage (Page a) {
		Pages.add(a);
	}
	
	public int getPageCount(){
		return Pages.size();
	}
	
	public void addText (String input){
		
		int i;
		String[] words = input.split(" ");
		
		for (String word  : words){
		i= Pages.size();
		
		if(i==0){
			Page p = new Page(layout);
			p.addText(word);
			Pages.add(p);
			
		}else{
		
			Page p = Pages.get(i-1);
			
			if(p.addText(word)==true){ /* Good ! */ }
			else {
				Page newPage = new Page(layout);
				newPage.addText(word);
				Pages.add(newPage);
				
			}
		}
		}
	}
}
