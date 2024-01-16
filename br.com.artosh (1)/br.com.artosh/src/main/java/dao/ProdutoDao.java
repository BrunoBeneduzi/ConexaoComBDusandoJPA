package dao;

import java.util.List;

import javax.persistence.EntityManager;

import classes.Produto;

public class ProdutoDao {
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		produto = this.em.merge(produto);
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		this.em.clear();	
	}
	
	public void mostra(int i) {
		Produto produto = this.em.find(Produto.class, i);//find retorna o objeto do tipo da classe que estou passando com o id colocado
		System.out.println(produto.getNome());
		this.em.clear();	
	}
	
	public List<Produto> buscarTodos(){//exibe todas as informações do banco de dados
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){//exibe todas as informações do banco de dados
		String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
		return em.createQuery(jpql, Produto.class).setParameter(1, nome).getResultList();//set parameter pega o nome que está depois do sinal de = e substitui o nome pelo atributo "nome"
	}
	
	public void remove(int i) {
		Produto produto = this.em.find(Produto.class, i);
		produto = this.em.merge(produto);
		this.em.getTransaction().begin();
		this.em.remove(produto);
		System.out.println("removido" + i);
		this.em.getTransaction().commit();
		this.em.clear();
		
	}
	
	public void modifica(String nome, int id) {
		Produto produto = new Produto();
		
		produto.setId(id);
		produto.setNome(nome);
		
		this.em.getTransaction().begin();
		this.em.merge(produto);
		this.em.getTransaction().commit();
		this.em.clear();
	}
}