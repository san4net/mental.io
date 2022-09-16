package com.mental.io.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
@javax.persistence.Converter
public class MyCustomConverter implements AttributeConverter<CoursesJson, String> {

    private  ObjectMapper objectMapper;

    @Autowired
    public MyCustomConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String convertToDatabaseColumn(CoursesJson coursesJson) {
        try {
            return objectMapper.writeValueAsString(coursesJson);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public CoursesJson convertToEntityAttribute(String databaseDataAsJSONString) {
        try {
            return objectMapper.readValue(databaseDataAsJSONString, CoursesJson.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
