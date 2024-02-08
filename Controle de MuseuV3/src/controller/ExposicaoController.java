package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ExposicaoDao;
import dao.ExposicaoDaoImpl;
import entidade.Exposicao;
import entidade.Visitantes;



public class ExposicaoController {
	private List<Exposicao> lista = new ArrayList<Exposicao>();
	private ExposicaoDao eDao = new ExposicaoDaoImpl();
	
	public void adicionar(Exposicao e) { 	
		eDao.adicionar( e );
	}
	
	public List<Exposicao> pesquisar(String nome) {

		return eDao.pesquisar(nome);
	}	
	
	public void alterar(Exposicao e) {
		 eDao.atualiza(e);			
	}
	
	
	public void deletar(Exposicao e) {
		 eDao.deletar(e);		 			
	}

}
