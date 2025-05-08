package br.com.pessoa_crud.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pessoa_crud.model.Endereco;

@Stateless
public class EnderecoRepository {

    @PersistenceContext(unitName = "pessoaPU")
    private EntityManager em;

    public Endereco salvar(Endereco endereco) {
        if (endereco.getId() == null) {
            em.persist(endereco);
        } else {
            endereco = em.merge(endereco);
        }
        return endereco;
    }

    public void excluir(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        if (endereco != null) {
            em.remove(endereco);
        }
    }
}
