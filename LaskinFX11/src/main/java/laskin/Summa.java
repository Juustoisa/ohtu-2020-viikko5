package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    String nykyinenSyote;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus){
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
        
    @Override
    public void suorita() {
        if(syotekentta.getText().isEmpty())return;
        this.nykyinenSyote = syotekentta.getText();
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        syotekentta.setText("");
        undo.disableProperty().set(false);
    }

    @Override
    public void undo() {
        sovellus.miinus(Integer.valueOf(nykyinenSyote));
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        syotekentta.setText(nykyinenSyote);
        undo.disableProperty().set(true);
    }
}
