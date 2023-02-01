package com.attornatus.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EnderecoServiceTest {

    @MockBean
    private EnderecoService enderecoService;

    @Test
    public void deveTerApenasUmEnderecoAtivo(){

    }


}
