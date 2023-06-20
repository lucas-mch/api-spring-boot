package dev.lucasmachado.services;

import dev.lucasmachado.model.Pessoa;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PessoaServiceTest {

    @MockBean
    private PessoaService pessoaService;

    public Pessoa getPessoaTest(){
        return Pessoa.Builder.create()
                .id(null)
                .nome("")
                .dataNascimento(new Date())
                .build();
    }
    @Test
    public void deveCriarUmaPessoa() {
        Pessoa pessoa = mock(Pessoa.class);
        Mockito.when(pessoaService.save(any())).thenReturn(pessoa);
    }

}
