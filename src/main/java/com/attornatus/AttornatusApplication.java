package com.attornatus;


import com.attornatus.model.Pessoa;
import com.attornatus.repositories.PessoaRepository;
import com.attornatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class AttornatusApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[] args) {
        SpringApplication.run(AttornatusApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = Pessoa.Builder.create()
                .id(null)
                .nome("Lucas Machado de Souza")
                .dataNascimento(new Date("11/10/1998"))
                .build();

        Pessoa p2 = Pessoa.Builder.create()
                .id(null)
                .nome("Mikhail Tal")
                .dataNascimento(new Date("09/11/1936"))
                .build();

        pessoaRepository.saveAll(Arrays.asList(p1,p2));

    }
}
