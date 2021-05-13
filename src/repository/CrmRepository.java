package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Quote;
public class CrmRepository {

	private EntityManager entityManager;
	public EntityManager getEntityManager() {
		if(entityManager==null) {
			 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("crmSOAP");
			 entityManager =entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	public  Quote generateQuote(Quote quote) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(quote);		
		getEntityManager().getTransaction().commit();
		return getQuoteByID(quote.getIdquote());
	}
	
	public  Client generateClient(Client client) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(client);		
		getEntityManager().getTransaction().commit();
		return client;
	}
		
	
	public Quote getQuoteByID(int id) {		
		getEntityManager().getTransaction().begin();
	Quote quote =	getEntityManager().find(Quote.class, id);	
		getEntityManager().getTransaction().commit();
		return quote;
	}
	
	
	public Client getClientByID(int id) {		
		getEntityManager().getTransaction().begin();
	Client client =	getEntityManager().find(Client.class, id);	
		getEntityManager().getTransaction().commit();
		return client;
	}
	
	
}
