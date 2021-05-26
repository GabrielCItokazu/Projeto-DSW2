package br.ufscar.dc.dsw.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.service.spec.ICidadeService;

@Component
public class CidadeConversor implements Converter<String, Optional<Cidade>> {

	@Autowired
	private ICidadeService service;
	
	@Override
	public Optional<Cidade> convert(String text) {
		
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.burcarPorId(id);
	}
}