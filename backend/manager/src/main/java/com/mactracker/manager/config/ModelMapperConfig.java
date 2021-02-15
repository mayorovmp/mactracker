package com.mactracker.manager.config;

import com.mactracker.manager.mapper.MapperConfigurer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getMapperBean(List<MapperConfigurer> mapperConfigurers) {
        ModelMapper modelMapper = new ModelMapper();
        mapperConfigurers.forEach(mp -> mp.configure(modelMapper));
        return modelMapper;
    }
}
