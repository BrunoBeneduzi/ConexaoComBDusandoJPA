package br.com.DAO;

import javax.persistence.EntityManager;

import main.Cliente;


public class ClientesDao {//classe que realiza as modificações no banco de dados
	private EntityManager em;
	
	
	public ClientesDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.getTransaction().begin();
		this.em.persist(cliente);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void mostra(int i) {
		Cliente cliente = this.em.find(Cliente.class, i);
		System.out.println(cliente.getNome());
		this.em.close();
	}
	
	public void remove(int i) {
		Cliente cliente = this.em.find(Cliente.class, i);
		this.em.getTransaction().begin();
		System.out.println("removido" + i);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void modifica(String nome, int id) {
		Cliente cliente = new Cliente();
		
		cliente.setId(id);
		cliente.setNome(nome);
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();
		this.em.close();
	}
}