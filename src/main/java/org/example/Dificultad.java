package org.example;

public enum Dificultad {
    EASY("Fácil"), MEDIUM("Media"), HARD("Difícil");
    private String dificultad;

    Dificultad (String dificultad){
        this.dificultad=dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad){
        this.dificultad=dificultad;
    }

    public static Dificultad getDificultad(String dif) {
        for (Dificultad d : Dificultad.values()) { // Uso de values()
            if (d.dificultad.equalsIgnoreCase(dif)) {
                return d;
            }
        }

        throw new IllegalArgumentException("Tipo de dificultad no válido: " + dif);
    }

}