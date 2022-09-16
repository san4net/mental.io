package com.mental.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mental.io.controller.MentalController;
import com.mental.io.data.User;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Utils {
    private static final Logger log = LoggerFactory.getLogger(MentalController.class);
    private final ObjectMapper objectMapper;

    public Utils(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init(){
        User u = new User();
        u.setUserId(4l);
        u.setPassword("josh");
        u.setUserName("ram-shankar");
        try {
            String objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
            log.info("pojo {}", objJackson);
        } catch (JsonProcessingException e) {
            log.debug("failed conversion: Pfra object to Json", e);
        }

    }

}
