package br.com.pessoa_crud.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.pessoa_crud.model.Endereco;
import br.com.pessoa_crud.repository.EnderecoRepository;

@Stateless
public class EnderecoService {

    @EJB
    private EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.salvar(endereco);
    }

    public void excluir(Long id) {
        enderecoRepository.excluir(id);
    }
    
}
