package br.ufscar.dc.dsw.controller;

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
import br.ufscar.dc.dsw.service.spec.ICidadeService;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/hoteis")
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private ICidadeService serviceC;
	
	@GetMapping("/listarTodosHoteis")
	public String listarTodosHoteis(ModelMap model) {
		model.addAttribute("hoteis", service.buscarTodos());
		return "hoteis/listarTodosHoteis";
	}
	
	@PostMapping("/listarTodosHoteis")
	public String listarTodosHoteisPost(ModelMap model) {
		model.addAttribute("hoteis", service.buscarTodos());
		return "hoteis/listarTodosHoteis";
	}

	@GetMapping("/formParaBuscaDeHotelPorCidade")
	public String formParaBuscaDeHotelPorCidade(@RequestParam(required = false) String cidadeSelecionada, ModelMap model) {
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
			model.addAttribute("hotelDaCidade", service.buscarTodosHoteisDaCidade(cidade));
		}
		
		return "hoteis/formParaBuscaDeHotelPorCidade";
	}
}