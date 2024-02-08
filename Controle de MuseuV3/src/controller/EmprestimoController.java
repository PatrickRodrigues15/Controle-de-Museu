package controller;

import java.util.ArrayList;
import java.util.List;

import dao.EmprestimoDAO;
import dao.EmprestimoDaoImpl;
import entidade.Emprestimo;
import entidade.Visitantes;

public class EmprestimoController {

	private List<Emprestimo> lista = new ArrayList<Emprestimo>();
	private EmprestimoDAO eDao = new EmprestimoDaoImpl();
	
	public void adicionar(Emprestimo e) { 
	
		eDao.adicionar( e );
	}
	
	public List<Emprestimo> pesquisar(String nome) {

		return eDao.pesquisar(nome);
	}		
	
	public void deletar(Emprestimo e) {
		 eDao.deletar(e);
		
	}

	public void alterar(Emprestimo v) {
		 eDao.atualiza(v);
		
		
	}
	
	
}
