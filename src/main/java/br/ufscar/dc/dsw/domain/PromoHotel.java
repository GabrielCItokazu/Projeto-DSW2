package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "PromoHotel")
public class PromoHotel extends AbstractEntity<Long> {
	
	@NotNull(message = "{NotBlank.promoHotel.preco}")
	@Column(nullable = false, unique = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal preco;
	
	@NotBlank(message = "{NotBlank.promoHotel.inicio}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.inicio}")
	@Column(nullable = false, unique = false, length = 10)
    private String inicio;

	@NotBlank(message = "{NotBlank.promoHotel.fim}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.fim}")
	@Column(nullable = false, unique = false, length = 10)
	private String fim;
    
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "sitereserva_id")
    private SiteReserva sitereserva;

	public PromoHotel() {
    }

	public PromoHotel(BigDecimal preco, String inicio, String fim, Hotel hotel) {
		this.preco = preco;
	    this.inicio = inicio;
	    this.fim = fim;
	    this.hotel = hotel;
	    this.sitereserva = new SiteReserva();
	}
	
	public PromoHotel(BigDecimal preco, String inicio, String fim, Hotel hotel, SiteReserva sitereserva) {
		this.preco = preco;
	    this.inicio = inicio;
	    this.fim = fim;
	    this.hotel = hotel;
	    this.sitereserva = sitereserva;
	}
	
	public PromoHotel(Long id, BigDecimal preco, String inicio, String fim, Hotel hotel, SiteReserva sitereserva) {
	    this.preco = preco;
	    this.inicio = inicio;
	    this.fim = fim;
	    this.hotel = hotel;
	    this.sitereserva = sitereserva;
	}
	
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    
    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public SiteReserva getSitereserva() {
        return sitereserva;
    }

    public void setSitereserva(SiteReserva sitereserva) {
        this.sitereserva = sitereserva;
    }
}