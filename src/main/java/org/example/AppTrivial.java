package org.example;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;

public class AppTrivial {
    public static void main(String[] args) {
        Pregunta preguntaTrueFalse = new PreguntaVerdaderoFalso("¿Java es un lenguaje de programación orientado a objetos?", true);
        preguntaTrueFalse.setCategoria(new Categoria("Programación"))
                .setTipoPregunta(TipoPregunta.BOOLEAN)
                .setDificultad(Dificultad.EASY);
        System.out.println(preguntaTrueFalse);

        Pregunta preguntaMultiple = new PreguntaMultiple("¿Cuál de los siguientes lenguajes de programación es orientado a objetos puro?");
        ((PreguntaMultiple)preguntaMultiple).addOpcion(new Opcion("Java", true))
                .addOpcion(new Opcion("C", false))
                .addOpcion(new Opcion("Python", true))
                .addOpcion(new Opcion("Modula-2", true))
                .setCategoria(new Categoria("Programación"))
                .setTipoPregunta(TipoPregunta.MULTIPLE)
                .setDificultad(Dificultad.EASY);

        Gson builder = new GsonBuilder()
                .registerTypeAdapter(TipoPregunta.class, new JsonSerializer<TipoPregunta> (){
                    @Override
                    public JsonElement serialize(TipoPregunta tipoPregunta, Type type, JsonSerializationContext jsonSerializationContext) {

                        return new JsonPrimitive(tipoPregunta.getTipoPregunta().toLowerCase());
                    }


                }).create();

        System.out.println(builder.toJson(preguntaMultiple));



    }


}