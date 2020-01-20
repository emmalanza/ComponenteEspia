package com.emma;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ComponenteTextEspia extends TextField {

    private String ficheroLog;
    private ArrayList<String> lista_palabras = new ArrayList<String>();
    private FileWriter fw;
    private PrintWriter pw;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private Evento evento;

    public ComponenteTextEspia(){
        textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                if(lista_palabras.size()>0){
                    for(int i = 0; i<lista_palabras.size(); i++){
                        if(getText().equals(lista_palabras.get(i))){
                            Date date = new Date();
                            String fecha = sdf.format(date);

                            try
                            {
                                fw = new FileWriter(ficheroLog, true);
                                pw = new PrintWriter(fw);
                                pw.println(getText() + " " + fecha);

                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    if (null != fw)
                                        fw.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (evento!=null)
                                evento.ejecuta_lo_que_sea();
                        }
                    }
                }
            }
        });
    }

    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }

    public ArrayList<String> getLista_palabras() {
        return lista_palabras;
    }

    public void setLista_palabras(ArrayList<String> lista_palabras) {
        this.lista_palabras = lista_palabras;
    }

    public void aniadir_palabra(String palabra){
        lista_palabras.add(palabra);
    }

    public void evento(Evento evento){
        this.evento = evento;
    }

}
