package org.example;

public enum TipoPregunta {
        MULTIPLE("Múltiple"), BOOLEAN ("Verdadero/Falso");
        private String tipoPregunta;

        private TipoPregunta(String tipoPregunta){
            this.tipoPregunta = tipoPregunta;
        }

        public String getTipoPregunta() {
            return tipoPregunta;
        }

    public static TipoPregunta getTipoPregunta(String tipoPregunta) {
        for (TipoPregunta tp : TipoPregunta.values()) { // Uso de values()
            if (tp.tipoPregunta.equalsIgnoreCase(tipoPregunta)) {
                return tp;
            }
        }
        throw new IllegalArgumentException("Tipo de pregunta no válido: " + tipoPregunta);
    }
    }

