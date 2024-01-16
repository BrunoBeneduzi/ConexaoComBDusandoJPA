package main;

import javax.persistence.EntityManager;

import classes.Categoria;
import classes.Produto;
import dao.CategoriaDao;
import dao.ProdutoDao;
import util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("CELULARES");
		
		Produto produto = new Produto("Samsung", 1500, "legal", categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		String nome = null;
		
		for(Categoria i: categoriaDao.buscarTodos()) {
			nome = i.getNome();
			break;
		}
		
		System.out.println(nome);
	}

}
