package com.attornatus;

import com.attornatus.model.endereco.Endereco;
import com.attornatus.model.pessoa.Pessoa;
import com.attornatus.services.EnderecoServiceImp;
import com.attornatus.services.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        Pessoa p1 = new Pessoa();
        Endereco e1 = new Endereco();
        Endereco e2 = new Endereco();

        e1.setCEP(88708071);
        e1.setLogradouro("Rua Manoel Jovencio de Castro");
        e1.setNumero(133);

        e2.setLogradouro("Estrada Geral Barreiros");
        e2.setCEP(88700100);
        e2.setNumero(0);

        enderecoService.save(e1);
        enderecoService.save(e2);

        p1.setNome("Lucas Machado de Souza");
        p1.setDataNascimento(new Date("11/10/1998"));
        p1.addEndereco(e1);
        p1.addEndereco(e2);

        pessoaService.save(p1);

    }
}
