package br.com.bruno.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private LocalDate createdDate = LocalDate.now();

	private Integer quantidadeEstoque;

	private Double valorDeCusto;

	private Double valorDeVenda;

	private String percentualDeLucro;

	private String observacao;

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public Double getValorDeCusto() {
		return valorDeCusto;
	}


	public void setValorDeCusto(Double valorDeCusto) {
		this.valorDeCusto = valorDeCusto;
	}


	public Double getValorDeVenda() {
		return valorDeVenda;
	}


	public void setValorDeVenda(Double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}


	public String getPercentualDeLucro() {
		return percentualDeLucro;
	}


	public void setPercentualDeLucro(String percentualDeLucro) {
		this.percentualDeLucro = percentualDeLucro;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Produto() {
		
	}	
	

	public Produto(Long id, String name, LocalDate createdDate, Integer quantidadeEstoque, Double valorDeCusto, Double valorDeVenda, String percentualDeLucro, String observacao) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.quantidadeEstoque = quantidadeEstoque;
		this.valorDeCusto = valorDeCusto;
		this.valorDeVenda = valorDeVenda;
		this.percentualDeLucro = percentualDeLucro;
		this.observacao = observacao;
	}


}
