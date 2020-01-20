package com.emma.prueba;

import com.emma.ComponenteTextEspia;
import com.emma.Evento;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PruebaComponente extends Application {
    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox vbox = new VBox();
        ComponenteTextEspia textEspia = new ComponenteTextEspia();

        textEspia.aniadir_palabra("Palabra");
        textEspia.setFicheroLog("C:\\Users\\Emma\\Desktop\\espia.txt");
        textEspia.evento(new Evento() {
            @Override
            public void ejecuta_lo_que_sea() {
                System.out.println("JaJa");
            }
        });

        vbox.getChildren().add(textEspia);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();


    }
}
