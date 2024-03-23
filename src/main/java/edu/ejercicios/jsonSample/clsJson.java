package edu.ejercicios.jsonSample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class clsJson {

    //convierte un objeto a Jsojn en una linea simple o de un solo elemento

    public String convierteObjetoJson(Object objeto, String archivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File(archivo),objeto);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(objeto);
        return jsonInString;
    }
    public Object converiteJsonAObjeto(){
        ObjectMapper mapper = new ObjectMapper();
        Object objArchivo = new Object();
        try{
            objArchivo = mapper.readValue(new File(""), mdBot.class);
        } catch (Exception ex){
            System.out.println("error:" +ex.getMessage());
        }
        return objArchivo;
    }

    ///trabajando con multiples registros
    public ArrayList<mdBot> converiteJsonAObjeto(){
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<mdBot> listaObjetos = new ArrayList<>();
    try{
        listaObjetos = mapper.readValue(new File(""), new TypeReference<ArrayList<mdBot>>() {
        })
    }
}

    public static void main(String[] args) {
        clsJson objJson = new clsJson();
        mdBot botData = new mdBot();

        botData = (mdBot) objJson.converiteJsonAObjeto();
        System.out.println("nombre"+botData.getNombre());



        /*botData.setNombre("Sergio");
        botData.setMensaje("Hola");
        botData.setId(12345678L);

        try{
            System.out.println(objJson.convierteObjetoJson(botData,"\"C:\\tmp\""));
        } catch (Exception ex){
            System.out.println("hubo error:"+ex.getMessage());
        }
    }*/
}
