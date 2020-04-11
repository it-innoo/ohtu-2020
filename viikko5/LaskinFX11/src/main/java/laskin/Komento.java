
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public abstract class Komento {
    protected TextField tuloskentta; 
    protected TextField syotekentta; 
    protected Button plus;
    protected Button miinus;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    
    protected String tulos;

    public Komento(
            TextField tuloskentta,
            TextField syotekentta,
            Button nollaa,
            Button undo,
            Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public abstract void suorita();
   
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText(tulos);
    }
    
    protected int getArvo() {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
