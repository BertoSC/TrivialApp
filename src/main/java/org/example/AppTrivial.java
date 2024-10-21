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

       /* //EJERCICIO A
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(TipoPregunta.class, new JsonSerializer<TipoPregunta> (){
                    @Override
                    public JsonElement serialize(TipoPregunta tipoPregunta, Type type, JsonSerializationContext jsonSerializationContext) {

                        return new JsonPrimitive(tipoPregunta.getTipoPregunta().toLowerCase());
                    }


                }).create();

        System.out.println(builder.toJson(preguntaMultiple));
*/

        /*EJERCICIO B
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(TipoPregunta.class, new JsonSerializer<TipoPregunta> () {
                    @Override
                    public JsonElement serialize(TipoPregunta tipoPregunta, Type type, JsonSerializationContext jsonSerializationContext) {

                        return new JsonPrimitive(tipoPregunta.toString().substring(0, 1).toUpperCase() + tipoPregunta.toString().substring(1).toLowerCase());
                    }


                }).create();

        System.out.println(builder.toJson(preguntaMultiple));
        */

        /*//EJERCICIO C a
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Dificultad.class, new JsonSerializer<Dificultad>() {
                    @Override
                    public JsonElement serialize(Dificultad dificultad, Type type, JsonSerializationContext jsonSerializationContext) {
                        return new JsonPrimitive(dificultad.getDificultad().toLowerCase());
                    }
                }).create();

        System.out.println(builder.toJson(preguntaMultiple));
        //EJERCICIO C b
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Dificultad.class, new JsonSerializer<Dificultad>() {
                    @Override
                    public JsonElement serialize(Dificultad dificultad, Type type, JsonSerializationContext jsonSerializationContext) {
                        return new JsonPrimitive(dificultad.toString().substring(0,1).toUpperCase()+ dificultad.toString().substring(1).toLowerCase());
                    }
                }).create();
        System.out.println(builder.toJson(preguntaMultiple));
        */

        /*  EJERCICIO D (No creo que este bien)
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Categoria.class, new JsonSerializer<Categoria>() {
                    @Override
                    public JsonElement serialize(Categoria categoria, Type type, JsonSerializationContext jsonSerializationContext) {
                        return new JsonPrimitive(categoria.getNome());
                    }
                }).create();

        System.out.println(builder.toJson(preguntaMultiple));


         */

        // EJERCICIO F

        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Pregunta.class, new JsonSerializer<Pregunta>() {
                    @Override
                    public JsonElement serialize(Pregunta pregunta, Type type, JsonSerializationContext jsonSerializationContext) {
                        JsonObject  js = new JsonObject();
                        js.add("type", new JsonPrimitive(pregunta.getTipoPregunta().getTipoPregunta().toLowerCase()));
                        js.add()

                        return null;
                    }
                }).create();


    }


}