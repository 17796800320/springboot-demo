package com.tm.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("person")
@Data
public class Person {

    private String name;
    private Integer age;
    private String[] city;

}
