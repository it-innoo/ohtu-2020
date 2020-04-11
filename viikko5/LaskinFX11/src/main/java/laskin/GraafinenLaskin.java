package laskin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GraafinenLaskin extends Pane {

    // @SuppressWarnings("unchecked")
    public GraafinenLaskin() {
        super();
        
        TextField tuloskentta = new TextField("0"); 
        tuloskentta.setEditable(false);
        TextField syotekentta = new TextField(""); 
        
        HBox napit = new HBox(10);
        Button plus = new Button("+");
        Button miinus = new Button("-");
        Button nollaa = new Button("Z");
        nollaa.disableProperty().set(true);
        Button undo = new Button("undo"); 
        undo.disableProperty().set(true);
        
        napit.getChildren().addAll(plus, miinus, nollaa, undo);
                 
        EventHandler kasittelija = new Tapahtumankuuntelija(
                tuloskentta,
                syotekentta,
                plus,
                miinus,
                nollaa,
                undo);
        plus.setOnAction(kasittelija);
        miinus.setOnAction(kasittelija);
        nollaa.setOnAction(kasittelija);
        undo.setOnAction(kasittelija);
        
        VBox layout = new VBox(10);

        layout.getChildren().addAll(tuloskentta, syotekentta, napit);   
        
        getChildren().add(layout);
    }
}
