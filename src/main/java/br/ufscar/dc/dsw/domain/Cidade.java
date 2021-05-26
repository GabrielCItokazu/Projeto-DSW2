package br.ufscar.dc.dsw.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cidade")
public class Cidade extends AbstractEntity<Long> {

	@NotBlank(message = "NotNull.cidade.nomeCidade")
	@Size(min = 3, max = 200, message = "{Size.cidade.nomeCidade}")
    @Column(nullable = false, length = 128, unique = true)
    private String nome;
	
	@OneToMany(mappedBy = "cidade")
	private Set<Hotel> hotelDaCidade;

	public Cidade() {
	}
	
	public Cidade(String nome) {
		this.nome = nome;
		this.hotelDaCidade = new HashSet<Hotel>();
	}
	
	public Cidade(String nome, Set<Hotel> hotelDaCidade) {
		this.nome = nome;
		this.hotelDaCidade = hotelDaCidade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Hotel> getHotelDaCidade() {
		return this.hotelDaCidade;
	}
	
	public void setHotelDaCidade(Set<Hotel> hotelDaCidade) {
		this.hotelDaCidade = hotelDaCidade;
	}
	
	public void addHotelDaCidade(Hotel hotel) {
		this.hotelDaCidade.add(hotel);
	}
}