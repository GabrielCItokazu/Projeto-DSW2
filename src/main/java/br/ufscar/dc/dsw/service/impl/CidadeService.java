package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ICidadeDAO;
import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.service.spec.ICidadeService;

@Service
@Transactional(readOnly = false)
public class CidadeService implements ICidadeService {

	@Autowired
	ICidadeDAO dao;
	
	public void salvar(Cidade cidade) {
		dao.save(cidade);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Cidade> buscarTodas() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Cidade> burcarPorId(Long id) {
		return dao.findById(id);
	}
}