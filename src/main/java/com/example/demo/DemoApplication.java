package com.example.demo;

import com.example.demo.visao.ListarPessoas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoApplication.class)
                .headless(false)
                .run(args);

        ListarPessoas appFrame = context.getBean(ListarPessoas.class);
        appFrame.setVisible(true);
        appFrame.setDefaultCloseOperation(ListarPessoas.EXIT_ON_CLOSE);
    }

}
