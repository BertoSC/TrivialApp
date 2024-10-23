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
        ((PreguntaMultiple) preguntaMultiple).addOpcion(new Opcion("Java", true))
                .addOpcion(new Opcion("C", false))
                .addOpcion(new Opcion("Python", false))
                .addOpcion(new Opcion("Modula-2", false))
                .setCategoria(new Categoria("Programación"))
                .setTipoPregunta(TipoPregunta.MULTIPLE)
                .setDificultad(Dificultad.EASY);

       /* //EJERCICIO A
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(TipoPregunta.class, new JsonSerializer<TipoPregunta> (){
                    @Override
                    public JsonElement serialize(TipoPregunta tipoPregunta, Type type, JsonSerializationContext jsonSerializationContext) {

                        return new JsonPrimitive(tipoPregunta.toString().toLowerCase());
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
        //
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(Categoria.class, new JsonSerializer<Categoria>() {
                    @Override
                    public JsonElement serialize(Categoria categoria, Type type, JsonSerializationContext jsonSerializationContext) {
                        return new JsonPrimitive(categoria.getNome());
                    }
                }).create();

        System.out.println(builder.toJson(preguntaMultiple));


         */

        /*// EJERCICIO E

        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(PreguntaMultiple.class, new JsonSerializer<PreguntaMultiple>() {
                    @Override
                    public JsonElement serialize(PreguntaMultiple preguntaM, Type type, JsonSerializationContext jsonSerializationContext) {
                        JsonObject  js = new JsonObject();
                        js.add("type", new JsonPrimitive(preguntaM.getTipoPregunta().getTipoPregunta().toLowerCase()));
                        js.add("difficulty", new JsonPrimitive((preguntaM.getDificultad().getDificultad().toLowerCase())));
                        js.add("category", new JsonPrimitive((preguntaM.getCategoria().toString().toLowerCase())));
                        js.add("question", new JsonPrimitive((preguntaM.getPregunta().toString().toLowerCase())));
                        JsonArray jsA = new JsonArray();
                        for(Opcion o: preguntaM.getOpciones()){
                            JsonObject temp = new JsonObject();
                            temp.addProperty("enunciado",o.getEnunciado());
                            temp.addProperty("correcta", o.isCorrecta());
                            jsA.add(temp);
                        }
                        js.add("options", jsA);
                        return js;
                    }
                })
                .registerTypeAdapter(PreguntaVerdaderoFalso.class, new JsonSerializer<PreguntaVerdaderoFalso>() {
                    @Override
                    public JsonElement serialize(PreguntaVerdaderoFalso preguntaVF, Type type, JsonSerializationContext jsonSerializationContext) {
                        JsonObject js2 = new JsonObject();
                        js2.addProperty("type", preguntaVF.getTipoPregunta().getTipoPregunta().toLowerCase());
                        js2.addProperty("difficulty", preguntaVF.getDificultad().getDificultad().toLowerCase());
                        js2.addProperty("category", preguntaVF.getCategoria().toString().toLowerCase());
                        js2.addProperty("question", preguntaVF.getPregunta().toString().toLowerCase());
                        js2.addProperty("answer", preguntaVF.isRespuesta());
                        return js2;
                    }
                })
                .create();

        System.out.println(builder.toJson(preguntaMultiple));
           */

/*
        //EJERCICIO F
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(PreguntaMultiple.class, new JsonSerializer<PreguntaMultiple>() {
                    @Override
                    public JsonElement serialize(PreguntaMultiple preguntaM, Type type, JsonSerializationContext jsonSerializationContext) {
                        JsonObject js = new JsonObject();
                        js.add("type", new JsonPrimitive(preguntaM.getTipoPregunta().getTipoPregunta().toLowerCase()));
                        js.add("difficulty", new JsonPrimitive((preguntaM.getDificultad().getDificultad().toLowerCase())));
                        js.add("category", new JsonPrimitive((preguntaM.getCategoria().toString().toLowerCase())));
                        js.add("question", new JsonPrimitive((preguntaM.getPregunta().toString().toLowerCase())));
                        JsonPrimitive pr;
                        JsonArray jsA = new JsonArray();
                        for (Opcion o : preguntaM.getOpciones()) {
                            JsonObject temp = new JsonObject();
                            if (o.isCorrecta()) {
                                pr = new JsonPrimitive(o.getEnunciado().toString().toLowerCase());
                                js.add("correct answer", pr);
                            } else {
                                jsA.add(o.getEnunciado());
                            }

                            js.add("incorrect answers", jsA);

                        }
                        return js;
                    }
                }).create();
        System.out.println(builder.toJson(preguntaMultiple));
*/
    }


}