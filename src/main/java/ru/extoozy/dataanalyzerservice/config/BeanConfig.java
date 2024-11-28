package ru.extoozy.dataanalyzerservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.InputStream;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML consumerXML(){
        try (InputStream inputStream = getClass().getResourceAsStream("/kafka/consumer.xml")) {
            return new XMLDocument(inputStream.readAllBytes());
        }
    }

}
