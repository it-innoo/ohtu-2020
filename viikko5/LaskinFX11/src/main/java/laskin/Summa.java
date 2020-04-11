package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    
    public Summa(TextField tuloskentta,
            TextField syotekentta,
            Button nollaa,
            Button undo,
            Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    
    @Override
    public void suorita() {
        int arvo = getArvo();
        
        sovellus.plus(arvo);
        int laskunTulos = sovellus.tulos();
        tulos = tuloskentta.getText();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}
