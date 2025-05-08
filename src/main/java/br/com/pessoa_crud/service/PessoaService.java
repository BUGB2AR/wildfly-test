package br.com.pessoa_crud.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.pessoa_crud.model.Endereco;
import br.com.pessoa_crud.model.Pessoa;
import br.com.pessoa_crud.repository.PessoaRepository;
import br.com.pessoa_crud.util.ValidacaoUtil;

import java.util.List;

@Stateless
public class PessoaService {

    @EJB
    private PessoaRepository pessoaRepository;

    @EJB
    private EnderecoService enderecoService;

    public Pessoa salvar(Pessoa pessoa) throws IllegalArgumentException {
        if (!ValidacaoUtil.validarIdade(pessoa.getDataNascimento())) {
            throw new IllegalArgumentException("Idade deve estar entre 18 e 100 anos");
        }
        return pessoaRepository.salvar(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null && pessoa.getEnderecos() != null) {
            for (Endereco endereco : pessoa.getEnderecos()) {
                enderecoService.excluir(endereco.getId());
            }
        }
        pessoaRepository.excluir(id);
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.buscarPorId(id);
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.listarTodos();
    }
    
    public Pessoa buscarPorIdComEnderecos(Long id) {
        return pessoaRepository.buscarPorId(id);
    }
}
