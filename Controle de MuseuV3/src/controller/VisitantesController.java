package controller;

import java.util.ArrayList;
import java.util.List;

import dao.VisitantesDao;
import dao.VisitantesDaoImpl;
import entidade.Visitantes;

public class VisitantesController {

	private List<Visitantes> lista = new ArrayList<Visitantes>();
	private VisitantesDao vDao = new VisitantesDaoImpl();	
	
	
	public void adicionar(Visitantes v) { 
		vDao.adicionar( v );
	}

	public void deletar(Visitantes v) {
		 vDao.deletar(v);
		
	}

	public void alterar(Visitantes v) {
		 vDao.atualiza(v);
		
		
	}
		
	public List<Visitantes> pesquisar(String nome) {

		return vDao.pesquisar(nome);
	}	

}
