package br.ufscar.dc.dsw.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "SiteReserva")
public class SiteReserva extends Usuario {

	@NotBlank(message = "{NotBlank.siteReserva.url}")
	@Size(min = 3, max = 250, message = "{Size.siteReserva.url}")
	@Column(nullable = false, unique = false, length = 250)
    private String url;
	
	@Column(nullable = true, unique = false, length = 14)
    private String telefone;

	@OneToMany(mappedBy = "sitereserva")
	private List<PromoHotel> promocoes;

	public SiteReserva() {
    }
	
    public SiteReserva(String url) {
        this.url = url;
    }
    
    public SiteReserva(String url, String nome, String telefone, String login, String senha) {
    	super(nome, login, senha);
       	this.url = url;
	    this.telefone = telefone;
	}
    
	public SiteReserva(Long id, String url, String nome, String telefone, String login, String senha) {
	    super(nome, login, senha);
	    this.url = url;
	    this.telefone = telefone;
	}

	public String getUrl() {
	    return url;
	}
	
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public String getTelefone() {
	    return telefone;
	}
	
	public void setTelefone(String telefone) {
	    this.telefone = telefone;
	}
}