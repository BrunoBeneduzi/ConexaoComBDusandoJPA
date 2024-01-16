package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("categoriaProdutos");//faz a monitoração das entidades no banco de dados escolhido
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}