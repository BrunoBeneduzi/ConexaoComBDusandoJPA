package dao;

import java.util.List;

import javax.persistence.EntityManager;

import classes.Categoria;


public class CategoriaDao {
	private EntityManager em;
	
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		categoria = this.em.merge(categoria);
		this.em.getTransaction().begin();
		this.em.persist(categoria);
		this.em.getTransaction().commit();
		this.em.clear();	
	}
	
	public void mostra(int i) {
		Categoria categoria = this.em.find(Categoria.class, i);//find retorna o objeto do tipo da classe que estou passando com o id colocado
		System.out.println(categoria.getNome());
		this.em.clear();	
	}
	
	public List<Categoria> buscarTodos(){//exibe todas as informações do banco de dados
		String jpql = "SELECT p FROM Categoria p";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	public List<Categoria> buscarPorNome(String nome){//exibe todas as informações do banco de dados
		String jpql = "SELECT p FROM Categoria p WHERE p.nome = ?1";
		return em.createQuery(jpql, Categoria.class).setParameter(1, nome).getResultList();//set parameter pega o nome que está depois do sinal de = e substitui o nome pelo atributo "nome"
	}
		
	public void remove(int i) {
		Categoria categoria = this.em.find(Categoria.class, i);
		categoria = this.em.merge(categoria);
		this.em.getTransaction().begin();
		this.em.remove(categoria);
		System.out.println("removido" + i);
		this.em.getTransaction().commit();
		this.em.clear();
		
	}
	
	public void modifica(String nome, int id) {
		Categoria categoria = new Categoria();
		
		categoria.setId(id);
		categoria.setNome(nome);
		
		this.em.getTransaction().begin();
		this.em.merge(categoria);
		this.em.getTransaction().commit();
		this.em.clear();
	}
}