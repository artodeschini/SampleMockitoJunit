package org.todeschini;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    private List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            throw new PessoaSemNomeException("Pessoa deve conter nome");
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if ( !this.pessoas.contains(pessoa) ) {
            throw new PessoaNaoCadastradaException("O cadastro nao possui essa pessoa");
        }
        this.pessoas.remove(pessoa);
    }
}
