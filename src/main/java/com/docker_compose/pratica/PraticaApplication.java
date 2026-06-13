package com.docker_compose.pratica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PraticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PraticaApplication.class, args);
    }

    @Bean
    CommandLineRunner executar(LivroRepository repository) {
        return args -> {

            Livro livro = new Livro("O Hobbit");

            repository.save(livro);

            System.out.println("Livro salvo no banco!");

            repository.findAll()
                      .forEach(System.out::println);
        };
    }
}