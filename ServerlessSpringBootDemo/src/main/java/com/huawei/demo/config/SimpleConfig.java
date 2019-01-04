package com.huawei.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@PropertySource("test.properties")
@Configuration
public class SimpleConfig {
    @Value("${int-test}")
    private int intTest;
    @Value("${string-test}")
    private String stringTest;
    @Value("${array-test}")
    private String[] arrayTest;

    @Bean
    public String configTest() {
        System.out.println("*******************************************************************************");
        System.out.println(intTest);
        System.out.println(stringTest);
        System.out.println(Arrays.asList(arrayTest));
        System.out.println("*******************************************************************************");
        return "ok";
    }
}
