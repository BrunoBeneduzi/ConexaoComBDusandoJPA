package main;
import javax.persistence.EntityManager;

import br.com.DAO.ClientesDao;
import br.com.DAO.ProdutoDao;
import br.com.Jpautil.JPAUtil;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ClientesDao dao = new ClientesDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		dao.modifica("Brunos", 1);
	}

}
