package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Cidade;

@SuppressWarnings("unchecked")
public interface ICidadeDAO extends CrudRepository<Cidade, Long> {

	List<Cidade> findAll();
	Cidade save(Cidade cidade);
	void deleteById(Long id);
	Optional<Cidade> findById(Long id);
}