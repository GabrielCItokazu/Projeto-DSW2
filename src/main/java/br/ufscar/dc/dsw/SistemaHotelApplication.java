package br.ufscar.dc.dsw;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.ICidadeDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.IPromoHotelDAO;
import br.ufscar.dc.dsw.dao.ISiteReservaDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.*;

@SpringBootApplication
public class SistemaHotelApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaHotelApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ICidadeDAO cidadeDAO, IHotelDAO hotelDAO, IPromoHotelDAO promoHotelDAO, ISiteReservaDAO siteReservaDAO, IUsuarioDAO dao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			/*
			// criação de administradores
			Usuario u1 = new Usuario("Mayk", "mayk@admin.com", encoder.encode("mayk"));
			Usuario u2 = new Usuario("Gabriel","gabriel@admin.com", encoder.encode("gabriel"));
			Usuario u3 = new Usuario("Daniel","daniel@admin.com", encoder.encode("daniel"));
			dao.save(u1);
			dao.save(u2);
			dao.save(u3);
			
			// criação de cidades
			Cidade cidade1 = new Cidade("São Carlos");
			Cidade cidade2 = new Cidade("São Paulo");
			cidadeDAO.save(cidade1);
			cidadeDAO.save(cidade2);
			
			// criação de hotéis
			Hotel hotel1 = new Hotel("55.789.390/0008-99", "Hotel Boa Viagem", cidade1, "hotel1@hotel.com", encoder.encode("hotel1"));
			Hotel hotel2 = new Hotel("71.150.470/0001-40", "Hotel Bela Vista", cidade2, "hotel2@hotel.com", encoder.encode("hotel2"));
			Hotel hotel3 = new Hotel("32.106.536/0001-82", "Hotel Bienvenido", cidade2, "hotel3@hotel.com", encoder.encode("hotel3"));
			hotelDAO.save(hotel1);
			hotelDAO.save(hotel2);
			hotelDAO.save(hotel3);

			// criação de sets de hotéis
			Set<Hotel> setHotel1 = new HashSet<Hotel>();
			Set<Hotel> setHotel2 = new HashSet<Hotel>();
			setHotel1.add(hotel1);
			setHotel2.add(hotel2);
			setHotel2.add(hotel3);

			// atualização dos hotéis das cidades
			cidade1.setHotelDaCidade(setHotel1);
			cidade2.setHotelDaCidade(setHotel2);
			cidadeDAO.save(cidade1);
			cidadeDAO.save(cidade2);
			
			// criação de sites
			SiteReserva site1 =  new SiteReserva("www.sitereservabrasil.com", "Reserva Brasil", "(16)1234-5678", "site1@siteres.com", encoder.encode("site1"));
			SiteReserva site2 =  new SiteReserva("www.siteboareserva.com", "Boa Reserva", "(16)1234-5688", "site2@siteres.com", encoder.encode("site2"));
			SiteReserva site3 =  new SiteReserva("www.sitebelareserva.com", "Bela Reserva", "(16)1234-5699", "site3@siteres.com", encoder.encode("site3"));
			siteReservaDAO.save(site1);
			siteReservaDAO.save(site2);
			siteReservaDAO.save(site3);

			// criação de promoções
			PromoHotel promo1 = new PromoHotel(BigDecimal.valueOf(220.5), "11/11/2020", "12/11/2020", hotel1, site1);
			PromoHotel promo2 = new PromoHotel(BigDecimal.valueOf(430.5), "11/11/2020", "12/11/2020", hotel2, site2);
			PromoHotel promo3 = new PromoHotel(BigDecimal.valueOf(355.5), "11/11/2020", "12/11/2020", hotel3, site3);
			PromoHotel promo4 = new PromoHotel(BigDecimal.valueOf(430.5), "08/08/2020", "08/09/2020", hotel3, site3);
			promoHotelDAO.save(promo1);
			promoHotelDAO.save(promo2);
			promoHotelDAO.save(promo3);
			promoHotelDAO.save(promo4);

			// criação de listas de promoções
			List<PromoHotel> listaPromo1 = new ArrayList<PromoHotel>();
			List<PromoHotel> listaPromo2 = new ArrayList<PromoHotel>();
			List<PromoHotel> listaPromo3 = new ArrayList<PromoHotel>();
			listaPromo1.add(promo1);
			listaPromo2.add(promo2);
			listaPromo3.add(promo3);
			listaPromo3.add(promo4);
			
			// atualização das promoções dos hotéis
			hotel1.setPromocoes(listaPromo1);
			hotel2.setPromocoes(listaPromo2);
			hotel3.setPromocoes(listaPromo3);
			*/
		};
	}
}