package com.attornatus.resources;

import com.attornatus.model.Pessoa;
import com.attornatus.services.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PessoaResourceTest {

    @MockBean
    private static PessoaService pessoaService;

    @MockBean
    private static PessoaResource resource;

    @Test
    public void deveEditarUmaPessoa() {
        Pessoa pessoa = mock(Pessoa.class);
        Mockito.when(pessoaService.save(any())).thenReturn(pessoa);
        ResponseEntity<Void> response = resource.update(pessoa, 1L);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void deveConsultarUmaPessoa() {
        Pessoa pessoa = mock(Pessoa.class);
        Mockito.when(pessoaService.save(any())).thenReturn(pessoa);
    }

    @Test
    public void deveListarPessoas() {
        Pessoa pessoa = mock(Pessoa.class);
        Mockito.when(pessoaService.save(any())).thenReturn(pessoa);
    }


}
