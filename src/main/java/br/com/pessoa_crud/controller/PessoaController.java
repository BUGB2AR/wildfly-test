package br.com.pessoa_crud.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.pessoa_crud.model.Endereco;
import br.com.pessoa_crud.model.Pessoa;
import br.com.pessoa_crud.service.EnderecoService;
import br.com.pessoa_crud.service.PessoaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private Endereco endereco;
	private List<Endereco> enderecosTemp;

	@EJB
	private PessoaService pessoaService;
	@EJB
	private EnderecoService enderecoService;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		endereco = new Endereco();
		enderecosTemp = new ArrayList<>();
		pessoas = pessoaService.listarTodos();
	}

	public void carregarPessoa() {
		if (pessoa != null && pessoa.getId() != null) {
			pessoa = pessoaService.buscarPorIdComEnderecos(pessoa.getId());
			if (pessoa != null && pessoa.getEnderecos() != null && !pessoa.getEnderecos().isEmpty()) {
				enderecosTemp = new ArrayList<>(pessoa.getEnderecos());
				endereco = enderecosTemp.get(0);
			}
		} else {
			pessoa = new Pessoa();
			endereco = new Endereco();
			enderecosTemp = new ArrayList<>();
		}
	}


	public void adicionar() {
		if (endereco != null) {
			enderecosTemp.add(endereco);
			endereco = new Endereco();
		}
	}
	
	public void salvar() {
		try {
			if (endereco != null && endereco.getLogradouro() != null && !endereco.getLogradouro().isEmpty()) {
				enderecosTemp.add(endereco);
			}

			pessoa.setEnderecos(enderecosTemp); 
			pessoaService.salvar(pessoa); 

			enderecoService.excluir(pessoa.getId()); 

			for (Endereco end : enderecosTemp) {
				end.setPessoa(pessoa);
				enderecoService.salvar(end);
			}

			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa salva com sucesso!"));

			FacesContext.getCurrentInstance().getExternalContext()
				.redirect("lista.xhtml");

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
	}



	public void excluir(Long id) {
		pessoaService.excluir(id);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa excluída com sucesso!"));
		pessoas = pessoaService.listarTodos();
	}

	public String editar(Long id) {
		this.pessoa = pessoaService.buscarPorIdComEnderecos(id);

		if (this.pessoa == null) {
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Pessoa não encontrada!"));
			return "lista?faces-redirect=true";
		}

		this.enderecosTemp = new ArrayList<>(this.pessoa.getEnderecos());
		this.endereco = new Endereco();

		return "cadastro?faces-redirect=true";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecosTemp() {
		return enderecosTemp;
	}

	public void setEnderecosTemp(List<Endereco> enderecosTemp) {
		this.enderecosTemp = enderecosTemp;
	}
}