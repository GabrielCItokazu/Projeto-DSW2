package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;

@SuppressWarnings("unchecked")
public interface IPromoHotelDAO extends CrudRepository<PromoHotel, Long> {
	
	PromoHotel findById(long id);
	PromoHotel findByInicio(String inicio);
	List<PromoHotel> findAll();
	List<PromoHotel> findByHotel(Hotel hotel);
	List<PromoHotel> findBySitereserva(SiteReserva sitereserva);
	PromoHotel save(PromoHotel promohotel);
	void deleteById(Long id);
	
	//Filtro por data
	@Query("SELECT p FROM PromoHotel p WHERE STR_TO_DATE(p.inicio, '%d/%m/%Y') >= :inicio AND STR_TO_DATE(p.fim, '%d/%m/%Y') <= :fim")
    List<PromoHotel> findAllByDate(String inicio, String fim);
}