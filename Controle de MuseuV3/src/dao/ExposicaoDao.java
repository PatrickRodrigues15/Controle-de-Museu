package dao;

import java.util.List;

import entidade.Exposicao;


public interface ExposicaoDao {
	public void adicionar(Exposicao e);

	public List<Exposicao> pesquisar(String nome);
	
	 public boolean atualiza(Exposicao nome);

	 public boolean deletar(Exposicao nome);
	 	
}
