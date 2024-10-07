package com.ejemplo.datos.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ejemplo.datos.mapper") // Ajusta el paquete según tu estructura
public class MyBatisConfig {
    // Aquí puedes agregar configuraciones adicionales si es necesario
}
