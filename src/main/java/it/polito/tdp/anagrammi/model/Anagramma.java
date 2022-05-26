package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	String word; 
	boolean corretta;
	
	public Anagramma(String word, boolean corretta) {
		this.word = word;
		this.corretta = corretta;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	} 
	
	
	

}
