package com.attornatus;

import com.attornatus.model.endereco.Endereco;
import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.services.EnderecoServiceImp;
import com.attornatus.services.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class AttornatusApplication implements CommandLineRunner {

    @Autowired
    private PessoaServiceImp pessoaService;

    @Autowired
    private EnderecoServiceImp enderecoService;

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

        Endereco e1 = Endereco.Builder.create()
                .logradouro("Rua Manoel Jovencio de Castro")
                .CEP(88708071)
                .numero(133)
                .build();

        Endereco e2 = Endereco.Builder.create()
                .logradouro("Estrada Geral Barreiros")
                .CEP(88700100)
                .numero(null)
                .build();

        pessoaService.save(p1);
        enderecoService.save(e1);

    }
}
