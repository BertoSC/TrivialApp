package org.example;

final public class Opcion {
    String enunciado;

    Boolean correcta;

    public Opcion(){
    }

    public Opcion(String enunciado) {
        if (enunciado==null){
            throw new IllegalArgumentException ("El enunciado no puede ser nulo");
        }
        this.enunciado = enunciado;
        this.correcta = false;
    }

    public Opcion(String enunciado, Boolean correcta) {
        if (enunciado==null){
            throw new IllegalArgumentException ("El enunciado no puede ser nulo");
        }
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return enunciado + (correcta ? "*" : "");
    }

}
