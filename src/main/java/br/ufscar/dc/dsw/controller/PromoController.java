package br.ufscar.dc.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.service.spec.ICidadeService;
import br.ufscar.dc.dsw.service.spec.IHotelService;
import br.ufscar.dc.dsw.service.spec.IPromoHotelService;

@Controller
@RequestMapping("/promo")
public class PromoController {
	
	@Autowired
	private IPromoHotelService service;

	@Autowired
	private IHotelService serviceH;
	
	@Autowired
	private ICidadeService serviceC;
	
	@GetMapping("/listarTodas")
	public String listarTodas(ModelMap model) {
		model.addAttribute("promos", service.buscarTodos());
		return "promo/listarTodas";
	}
	
	@PostMapping("/listarTodas")
	public String listarTodasPost(ModelMap model) {
		model.addAttribute("promos", service.buscarTodos());
		return "promo/listarTodas";
	}

	@GetMapping("/listarPorCidade")
	public String listarPorCidade(@RequestParam(required = false) String cidadeSelecionada, ModelMap model) {
		List<Cidade> cidades = serviceC.buscarTodas();
		model.addAttribute("cidadesParaSelecionar", cidades);
		
		if (cidadeSelecionada != null) {
			Cidade cidade = new Cidade();
			for (Cidade c : cidades) {
				if (c.getNome().equals(cidadeSelecionada)) 				{
					cidade = c;
					break;
				}
			}
			List<PromoHotel> promos = new ArrayList();
			List<Hotel> hoteis = serviceH.buscarTodosHoteisDaCidade(cidade);
			for (Hotel hotel : hoteis) {
				List<PromoHotel> promoHotel = service.findByHotel(hotel);
				for (PromoHotel p : promoHotel) {
					promos.add(p);
				}
			}
			model.addAttribute("cidade", cidade);
			model.addAttribute("promos", promos);
		}
		
		return "promo/listarPorCidade";
	}
}