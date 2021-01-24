package se.lexicon.omar.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonIO {
    private ObjectMapper objectMapper;

    public JsonIO() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeToJson(File file, List list) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, list);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Owner> deserializeOwner(File file) {
        List<Owner> owners = new ArrayList<>();
         try{
            owners = objectMapper.readValue(file, new TypeReference<List<Owner>>() {});

        } catch (IOException e) {
            e.printStackTrace();

        }
        return owners;
    }

    public List<Car> deserializeCars(File file) {
        List<Car> cars = new ArrayList<>();
        try{
            cars = objectMapper.readValue(file, new TypeReference<List<Car>>() {});

        } catch (IOException e) {
            e.printStackTrace();

        }
        return cars;
    }
}

