package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AcervoDao;
import dao.AcervoDaoImpl;
import entidade.Acervo;
import entidade.Visitantes;

public class AcervoController {
	
	private List<Acervo> listaGeral = new ArrayList<Acervo>();
	private AcervoDao aDao = new AcervoDaoImpl();
	
	public void adicionar(Acervo a) {		
		listaGeral.add(a);
		aDao.Adicionar( a );
	}

	public List<Acervo> pesquisar(String nome) {
		return aDao.pesquisar(nome);
		
	}
	public void deletar(Acervo a) {
		 aDao.deletar(a);
		
	}

	public void alterar(Acervo a) {
		 aDao.atualiza(a);
		
		
	}
}
