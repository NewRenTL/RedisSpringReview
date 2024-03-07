package com.codigo.msbustamantepalomino.infrastructure.util;


import com.codigo.msbustamantepalomino.domain.aggregates.dto.PersonaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Util {
    //Object Json to String
    public static String convertToJson(PersonaDTO personaDTO)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(personaDTO);
        }catch (JsonProcessingException e)
        {
            //I must catch the error that could occur
            throw new RuntimeException(e);
        }
    }
    //String to Json

    public static <T> T convertFromJson(String json ,Class<T> valueType)
    {
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json,valueType);
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
