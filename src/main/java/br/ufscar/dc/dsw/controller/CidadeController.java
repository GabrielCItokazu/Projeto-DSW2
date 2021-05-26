package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.service.spec.ICidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private ICidadeService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cidade cidade) {
		return "cidade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		return "cidade/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "redirect:/adminhoteis/cadastrar";
		}
		
		try {
			service.salvar(cidade);
			return "redirect:/adminhoteis/cadastrar";
		}
		catch (Exception error) {
			return "redirect:/adminhoteis/cadastrar";
		}
		// attr.addFlashAttribute("sucess", "Hotel inserido com sucesso.");
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		return "redirect:/adminhoteis/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
		return "redirect:/adminhoteis/cadastrar";
	}
	
	// @GetMapping("/excluir/{id}")
	// public String excluir(@PathVariable("id") Long id, ModelMap model) {
	// 	if (service.hotelTemPromo(id)) {
	// 		model.addAttribute("fail", "Hotel não excluído. Possui promo(s) vinculada(s).");
	// 	} else {
	// 		service.excluir(id);
	// 		model.addAttribute("sucess", "Hotel excluído com sucesso.");
	// 	}
	// 	return listar(model);
	// }
}