package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	private DizionarioDAO dizionarioDAO; 
	List<Anagramma> anagrammi;

	public Model() {
		this.dizionarioDAO=new DizionarioDAO(); 
	}
	
	public List<Parola> getTutteLeParole(){
		return this.dizionarioDAO.getTutteLeParole(); 
	}
	
	public List<Anagramma> anagramma(String s) {
		anagrammi= new ArrayList<Anagramma>();
		anagramma_ricorsiva("", 0, s); 
		checkParole(); 
		return anagrammi; 
	}
	
	public void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		//casi terminali
		if (rimanenti.compareTo("")==0) {
			anagrammi.add(new Anagramma(parziale, false)); 
		}
		
		//casi intermedi
		else {
			for (int i=0; i<rimanenti.length(); i++){
				anagramma_ricorsiva(parziale+rimanenti.charAt(i),
						livello+1, 
						rimanenti.substring(0,i)+rimanenti.substring(i+1));
			}
		}
	}
	
	public void checkParole() {
		List <Parola> dizionario= getTutteLeParole(); 
			for (int j=0; j<anagrammi.size(); j++) {
				for (int k=0; k<dizionario.size(); k++) {
					if(anagrammi.get(j).getWord().compareTo(dizionario.get(k).getParola())==0)
						anagrammi.get(j).setCorretta(true);
				}
			}
	}
}
