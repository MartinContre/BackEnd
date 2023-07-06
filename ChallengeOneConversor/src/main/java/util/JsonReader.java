package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exception.KeynotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private JsonObject jsonObject;
    public JsonReader(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                throw new FileNotFoundException("El archivo JSON no existe: " + filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader(filePath)){
            Object obj = parser.parse(reader);
            jsonObject = (JsonObject) obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] getValues(String key) {
        try {
            if (jsonObject == null) {
                throw new IllegalStateException("El archivo JSON no ha sido cargado");
            }

            JsonElement element = jsonObject.get(key);

            if (element == null) {
                throw new KeynotFoundException("La clave no se encuentra en el archivo JSON: " + key);
            }

            if (element.isJsonArray()) {
                JsonArray jsonArray = element.getAsJsonArray();
                String[] values = new String[jsonArray.size()];

                for (int i = 0; i < jsonArray.size(); i++) {
                    values[i] = jsonArray.get(i).getAsString();
                }

                return values;
            }

            throw new KeynotFoundException("El valor de la clave no es un arreglo en el archivo JSON: " + key);
        } catch (IllegalStateException e) {
            // Manejar la excepción de archivo JSON no cargado
            System.err.println(e.getMessage());
            return new String[0]; // Retorna un arreglo vacío en caso de error
        } catch (KeynotFoundException e) {
            // Manejar la excepción de clave no encontrada
            System.err.println(e.getMessage());
            return new String[0]; // Retorna un arreglo vacío en caso de error
        }
    }

    public String getValue(String key) {
        return jsonObject.get(key).getAsString();
    }
}
