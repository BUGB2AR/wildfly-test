package br.com.pessoa_crud.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pessoa_crud.model.Pessoa;

import java.util.List;

@Stateless
public class PessoaRepository {

    @PersistenceContext(unitName = "pessoaPU")
    private EntityManager em;

    public Pessoa salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            em.persist(pessoa);
        } else {
            pessoa = em.merge(pessoa);
        }
        return pessoa;
    }

    public void excluir(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.remove(pessoa);
        }
    }

    public Pessoa buscarPorId(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> listarTodos() {
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }
    
    public Pessoa buscarPorIdComEnderecos(Long id) {
        return em.createQuery(
            "SELECT DISTINCT p FROM Pessoa p LEFT JOIN FETCH p.enderecos WHERE p.id = :id", 
            Pessoa.class)
            .setParameter("id", id)
            .getSingleResult();
    }
}