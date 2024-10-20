package org.example;

import java.io.Serializable;

class Pregunta implements Comparable<Pregunta>, Serializable {
    Long idPregunta;
    TipoPregunta tipoPregunta;
    Dificultad dificultad;
    String difi;
    Categoria categoria;
    String enunciado;



    public Dificultad getDificultad() {
        return dificultad;
    }



}