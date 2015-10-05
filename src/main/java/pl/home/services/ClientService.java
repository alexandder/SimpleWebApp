package pl.home.services;

import config.FacesMessageHelper;
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
        FacesMessageHelper.addFacesMessage("Dodano nowego klienta do bazy danych!");
    }

    public Client find(Long id) {                
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    public void delete(Client client) {
        Client toRemove = entityManager.merge(client);
        entityManager.remove(toRemove);
    }
    
    public void edit(Client client) {
        entityManager.merge(client);
        FacesMessageHelper.addFacesMessage("Zmieniono dane klienta!");
    }
}
