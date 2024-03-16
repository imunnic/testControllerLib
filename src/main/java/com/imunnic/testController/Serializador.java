package com.imunnic.testController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;

//Creación de una competición y calificación de sus participantes
public class Serializador {

  public static void main(String[] args) {
    //creo una nueva competición y empiezo a agregarle todos los valores
    Test competicion1 = new Test();
    competicion1.setName("Patriot Race");
    competicion1.setDescription("Carrera de pruebas físicas");
    competicion1.setDate(LocalDate.now().plusMonths(2));
    //añado las pruebas de la competición
    competicion1.getTrials().add(Trial.BURPEES);
    competicion1.getTrials().add(Trial.PUSH_UPS);
    competicion1.getTrials().add(Trial.PULL_UPS);
    competicion1.getTrials().add(Trial.RUN);
    competicion1.getTrials().add(Trial.DEVIL_PRESS);
    //compruebo la competición
    System.out.println(competicion1.toString());
    System.out.println("-------------");
    //compruebo las pruebas
    competicion1.getTrials().forEach(System.out::println);
    System.out.println("-------------");
    //Voy a deserializar y serializar(obtener la información de algún lado). Creo el mapper
    //con esto pretendo añadir los participantes a la competición y ver como serían los datos 
    //impresos por pantalla
    ObjectMapper mapper = new ObjectMapper()
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(Feature.ALLOW_UNQUOTED_FIELD_NAMES);
    //leo los participantes del Json
    try (BufferedReader buffer =
        new BufferedReader(new FileReader(new File("./src/main/resources/participants.json")))) {
      buffer.lines().forEach(l -> {
        try {
          Participant participant = mapper.readValue(l, Participant.class);
          competicion1.getParticipants().add(participant);
        } catch (JsonMappingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (JsonProcessingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    //compruebo la salida
    competicion1.getParticipants().forEach(System.out::println);
    System.out.println("-------------");
    //serializo los participantes
    competicion1.getParticipants().stream()
                                  .map( p -> {
                                    String json = "N/D";
                                    try {
                                      json = mapper.writeValueAsString(p);
                                    } catch (Exception e) {
                                      e.printStackTrace();
                                    }
                                    return json;
                                  })//Compruebo la salida
                                  .forEach(System.out::println);
    System.out.println("-------------");    
    //agrego los jueces a la competición desde el Json
    try (BufferedReader buffer =
        new BufferedReader(new FileReader(new File("./src/main/resources/tester.json")))) {
      buffer.lines().forEach(l -> {
        try {
          Tester tester = mapper.readValue(l, Tester.class);
          competicion1.getTesters().add(tester);
        } catch (JsonMappingException e) {
          e.printStackTrace();
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    //compruebo la salida
    competicion1.getTesters().forEach(System.out::println);
    System.out.println("-------------"); 
    //compruebo que un juez pueda calificar a un participante
    //el juez califica una prueba de dominadas
    Result result1 = competicion1.getTesters().get(0).certifyResult(Trial.PULL_UPS, 10);
    competicion1.getTesters().get(0).asignResult(competicion1.getParticipants().get(0), result1);
    //compruebo que se ha agregado el resultado al participante
    System.out.println(competicion1.getParticipants().get(0).getResults().toString());
    //añadimos todos los resultados de la prueba
    result1 = competicion1.getTesters().get(0).certifyResult(Trial.PUSH_UPS, 30);
    competicion1.getTesters().get(0).asignResult(competicion1.getParticipants().get(0), result1);
    result1 = competicion1.getTesters().get(1).certifyResult(Trial.DEVIL_PRESS, 5);
    competicion1.getTesters().get(1).asignResult(competicion1.getParticipants().get(0), result1);
    result1 = competicion1.getTesters().get(2).certifyResult(Trial.BURPEES, 15);
    competicion1.getTesters().get(2).asignResult(competicion1.getParticipants().get(0), result1);
    result1 = competicion1.getTesters().get(3).certifyResult(Trial.RUN, 33);
    competicion1.getTesters().get(3).asignResult(competicion1.getParticipants().get(0), result1);
    System.out.println("-------------"); 
    competicion1.getParticipants().get(0).getResults().forEach(System.out::println);
    //comprobamos que se obtiene resultado para un participante
    System.out.println("-------------"); 
    System.out.println("El resultado para el primer participante es:");
    System.out.println(competicion1.getMark(competicion1.getParticipants().get(0)));
    System.out.println("-------------"); 
    //Vamos a añadir los datos a otro participante
    Result result2 = competicion1.getTesters().get(0).certifyResult(Trial.PULL_UPS, 15);
    competicion1.getTesters().get(0).asignResult(competicion1.getParticipants().get(1), result2);
    result2 = competicion1.getTesters().get(0).certifyResult(Trial.PUSH_UPS, 34);
    competicion1.getTesters().get(0).asignResult(competicion1.getParticipants().get(1), result2);
    result2 = competicion1.getTesters().get(1).certifyResult(Trial.DEVIL_PRESS, 3);
    competicion1.getTesters().get(1).asignResult(competicion1.getParticipants().get(1), result2);
    result2 = competicion1.getTesters().get(2).certifyResult(Trial.BURPEES, 20);
    competicion1.getTesters().get(2).asignResult(competicion1.getParticipants().get(1), result2);
    result2 = competicion1.getTesters().get(3).certifyResult(Trial.RUN, 30);
    competicion1.getTesters().get(3).asignResult(competicion1.getParticipants().get(1), result2);
    //ordenamos los participantes y mostramos por pantalla para ver que el segundo va antes que el primero
    competicion1.sort();
    competicion1.getParticipants().forEach(System.out::println);
    //Vamos a ver los datos al serializar un participante
    try {
      System.out.println(mapper.writeValueAsString(competicion1.getParticipants().get(0)));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    //Esto es la librería, ahora quiero integrarla en un proyecto para evaluar un curso
    //¿Cómo hago para que al serializar los datos de un participante solo serialice el id del tester?
    //¿Lo sencillo es irme a tester y fundirme al serializar todo menos el id y luego hacer
    //un properties con todos los tester? ¿Hay algo más sencillo o con más sentido?
    //¿Es ahí donde entran los mixins? Entiendo que son para traducir de una clase a otra pero no veo cómo
    //ni cuando utilizarlos
    
  }
  
}
