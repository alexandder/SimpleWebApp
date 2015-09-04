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
import javax.persistence.Query;
import pl.home.entities.Article;

@Stateless
public class ArticleService {

    @PersistenceContext(name = "app")
    EntityManager entityManager;

    public List<Article> getAll() {
        Query query = entityManager.createQuery("SELECT a from Article a");
        return (List<Article>) query.getResultList();
    }
    /*
    public void editArticle(Long id, String name, Float price, String description) {
        Query query = entityManager.createQuery("UPDATE Article a SET a.name = :id, a.price = :price, a.description = :description WHERE id = :id");
        query.setParameter("id", id);
        query.setParameter("name", id);
        query.setParameter("price", id);
        query.setParameter("description", id);
    }
    */
    public void add(Article a) {
        entityManager.persist(a);
    }

    public void delete(Article a) {
        entityManager.remove(a);
    }

    public Article find(Long id) {
        Query query = entityManager.createQuery("SELECT a from Article a WHERE a.id = :id");
        query.setParameter("id", id);
        return (Article) query.getSingleResult();
    }
        

}
