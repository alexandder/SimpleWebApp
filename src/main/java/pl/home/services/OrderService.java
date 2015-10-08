/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.home.entities.ClientOrder;

@Stateless
public class OrderService {
    
    @PersistenceContext(name = "app")
    EntityManager entityManager;
    
    public void add(ClientOrder order) {
        entityManager.persist(order);
    }
    
    public ClientOrder find(Long id) {
        return entityManager.find(ClientOrder.class, id);
    }
    
    public List<ClientOrder> getAll() {
        List<ClientOrder> orderList = (List<ClientOrder>) entityManager.createNamedQuery("Order.findAll").getResultList();
        return orderList;
    }
    
}
