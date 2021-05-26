package br.ufscar.dc.dsw.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = {"cidade", "promocoes"})
@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario {

	@NotBlank(message = "{NotBlank.hotel.cnpj}")
	@Size(min = 10, max = 18, message = "{Size.hotel.cnpj}")
	@Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
	private Cidade cidade;

	@OneToMany(mappedBy = "hotel")
	private List<PromoHotel> promocoes;

	public Hotel() {
    }
	
	public Hotel(String cnpj, String nome, Cidade cidade, String login, String senha) {
		super(nome, login, senha);
		this.cnpj = cnpj;
	    this.cidade = cidade;
	}
	
	public Hotel(Long id, String cnpj, String nome, Cidade cidade, String login, String senha) {
	    super(nome, login, senha);
	    this.cnpj = cnpj;
	    this.cidade = cidade;
	}
	
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<PromoHotel> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<PromoHotel> promocoes) {
        this.promocoes = promocoes;
    }
}