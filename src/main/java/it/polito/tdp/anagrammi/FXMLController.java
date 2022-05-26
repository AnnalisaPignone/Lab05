/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model; 
	List <Anagramma> anagrammiRisultato = new ArrayList <Anagramma>(); 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="parolaInserita"
    private TextField parolaInserita; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    
    String inserito= parolaInserita.getText(); 
    anagrammiRisultato= model.anagramma(inserito);
    for (Anagramma a: anagrammiRisultato) {
    	if (a.isCorretta()==true) {
    		txtCorretti.appendText(a.getWord());
    		txtCorretti.appendText("\n");
    	}
    	else {
    		txtErrati.appendText(a.getWord());
    		txtErrati.appendText("\n");
    	}
    	
    }

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtErrati.clear();
        txtCorretti.clear();
        parolaInserita.clear();
    }
    
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert parolaInserita != null : "fx:id=\"parolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
