package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    String nykyinenTulos = "0";
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus){
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
        
    @Override
    public void suorita() {
        this.nykyinenTulos = tuloskentta.getText();
        sovellus.nollaa();
        tuloskentta.setText("0");
        syotekentta.setText("0");
        undo.disableProperty().set(false);
    }

    @Override
    public void undo() {
        sovellus.plus(Integer.parseInt(nykyinenTulos));
        tuloskentta.setText(nykyinenTulos);
        undo.disableProperty().set(true);
    }
}
