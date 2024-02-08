package dao;

import java.util.List;

import entidade.Exposicao;
import entidade.Visitantes;



public interface VisitantesDao {

	public void adicionar(Visitantes e);

	public List<Visitantes> pesquisar(String nome);

	public boolean atualiza(Visitantes nome);
	 
	public boolean deletar(Visitantes nome);
	 
	
}
