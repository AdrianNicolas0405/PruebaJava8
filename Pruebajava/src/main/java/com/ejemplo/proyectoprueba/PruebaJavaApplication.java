package com.ejemplo.proyectoprueba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ejemplo.datos.mapper") // Agrega esta línea
public class PruebaJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PruebaJavaApplication.class, args);
    }
}
