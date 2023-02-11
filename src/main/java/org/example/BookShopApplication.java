package org.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@SpringBootApplication
public class BookShopApplication{
    public static void main(String[] args) {SpringApplication.run(BookShopApplication.class,args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}