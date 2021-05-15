package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.annotation.XmlTransient;

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
	
	public List<Object> getVIPCustomer() {		
		getEntityManager().getTransaction().begin();
		List<Object> list =	getEntityManager().createNamedQuery("select  c.IDCLIENT, c.CLIENTNAME, sum(q.QUOTE)"
			+ "from quote q inner join client c on (c.IDCLIENT = q.idclient)"
			+ "group by c.IDCLIENT").getResultList();
		getEntityManager().getTransaction().commit();
		return list;
	}
	
	
}
