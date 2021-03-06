package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import java.util.Optional;

import br.ufscar.dc.dsw.domain.Cidade;

public interface ICidadeService {
	public void salvar(Cidade cidade);
	public void excluir(Long id);
	public List<Cidade> buscarTodas();
	public Optional<Cidade> burcarPorId(Long id);
}