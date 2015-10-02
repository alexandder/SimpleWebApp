package pl.home.services;

import pl.home.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientService {

    @PersistenceContext(name = "app")
    EntityManager entityManager;

    public List<Client> getAll() {
        Query query = entityManager.createNamedQuery("Client.findAll");
        return (List<Client>) query.getResultList();
    }

    public void add(Client client) {
        entityManager.persist(client);
    }

    public Client find(Long id) {
        Query query =  entityManager.createNamedQuery("Article.findById");
        query.setParameter("id", id);
        return (Client) query.getSingleResult();
    }

    public void delete(Client client) {
        entityManager.remove(client);
    }
}
