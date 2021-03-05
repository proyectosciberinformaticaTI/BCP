package com.example.demo;

import com.example.demo.configuration.ApplicationProperties;
import com.example.demo.entity.TipoCambio;
import com.example.demo.repository.TipoCambioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  TipoCambioRepository tipoCambioRepository;

  @Autowired
  ApplicationProperties applicationProperties;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    tipoCambioRepository.saveAll(getTipoCambio());
  }

  private List<TipoCambio> getTipoCambio() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String json = convert(applicationProperties.getTipoCambio());
    return mapper.readValue(json, new TypeReference<List<TipoCambio>>() {
    });
  }

  private String convert(String resource) {
    URL is = DemoApplication.class.getClassLoader().getResource(resource);
    try {
      String text = Resources.toString(is, Charsets.UTF_8);
      return text;
    } catch (IOException io) {
      io.printStackTrace();
    }
    return null;
  }
}
