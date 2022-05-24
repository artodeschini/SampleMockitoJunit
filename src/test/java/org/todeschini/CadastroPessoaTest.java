package org.todeschini;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static  org.assertj.core.api.Assertions.*;

public class CadastroPessoaTest {

    private CadastroPessoa cadastro;

    @BeforeEach
    void setUp() {
        cadastro = new CadastroPessoa();
    }

    @AfterEach
    void tearDown() {
        cadastro = null;
    }

    @Test
    public void deveCriarCadastroDePessoasSemPessoas() {
        //given
        //when
        //then

        // verifica se ao criar é getPessoas está vazio

        //com assertJ
        assertThat(cadastro.getPessoas()).isEmpty();
        //sem assertj
        Assertions.assertTrue(cadastro.getPessoas().isEmpty());
    }

    @Test
    public void deveAdicionarPessoasEmListaDePessoas() {
        //given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Artur");
        //when
        cadastro.adicionar(pessoa);

        //then
        //com assertJ
        assertThat(cadastro.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);
        //sem assertj
        Assertions.assertTrue(!cadastro.getPessoas().isEmpty());
        Assertions.assertEquals(1, cadastro.getPessoas().size());
        Assertions.assertTrue(cadastro.getPessoas().contains(pessoa));
    }

    @Test
    public void naoDeveAdicionarPessoasComNomeVazio() {
        //given
        Pessoa pessoa = new Pessoa();

        //when // then

        //assertj
        assertThatThrownBy(() -> {
            cadastro.adicionar(pessoa);
        }).isInstanceOf(PessoaSemNomeException.class).hasMessage("Pessoa deve conter nome").hasMessageContaining("nome");

        //junit 5 somente
        PessoaSemNomeException psne = Assertions.assertThrows(PessoaSemNomeException.class, () ->  cadastro.adicionar(pessoa));
        Assertions.assertTrue(psne.getMessage().equals("Pessoa deve conter nome") &&  psne.getMessage().contains("nome"));
    }

    @Test
    public void deveRemoverPessoaDoCadastro()  {
        // given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Artur");

        cadastro.adicionar(pessoa);

        //when
        cadastro.remover(pessoa);

        assertThat(cadastro.getPessoas().isEmpty());
    }

    @Test
    public void deveLancarErroAoTentarRemoverPessoaInexistente()  {
        // given
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Artur");

        //then

        //assertj
        assertThatThrownBy(() -> {
            cadastro.remover(pessoa);
        }).isInstanceOf(PessoaNaoCadastradaException.class).hasMessage("O cadastro nao possui essa pessoa").hasMessageContaining("nao");

        //junit 5 somente
        PessoaNaoCadastradaException pnce = Assertions.assertThrows(PessoaNaoCadastradaException.class, () ->  cadastro.remover(pessoa));
        Assertions.assertTrue(pnce.getMessage().equals("O cadastro nao possui essa pessoa") &&  pnce.getMessage().contains("nao"));
    }
}
