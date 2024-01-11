package br.com.DAO;

import javax.persistence.EntityManager;

import main.Cliente;
import main.Produto;

public class ProdutoDao {
private EntityManager em;
	
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void mostra(int i) {
		Produto produto = this.em.find(Produto.class, i);
		System.out.println(produto.getNome());
		this.em.close();
	}
	
	public void remove(int i) {
		Produto produto = this.em.find(Produto.class, i);
		this.em.getTransaction().begin();
		System.out.println("removido" + i);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void modifica(String nome, int id) {
		Produto produto = new Produto();
		
		produto.setId(id);
		produto.setNome(nome);
		this.em.getTransaction().begin();
		this.em.merge(produto);
		this.em.getTransaction().commit();
		this.em.close();
	}
}
