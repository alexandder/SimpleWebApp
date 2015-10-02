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
        Query query = entityManager.createNamedQuery("Article.findAll");
        return (List<Article>) query.getResultList();
    }
    
    public void edit(Article article) {
        System.out.println("Przekazano artykul o id = " + article.getId() + " do edycji w metodzie edit w articleService.");
        entityManager.merge(article);
    }
    
    public void add(Article a) {
        entityManager.persist(a);
    }

    public void delete(Article a) {
        entityManager.remove(a);
    }

    public Article find(Long id) {
        Query query = entityManager.createNamedQuery("Article.findById");
        query.setParameter("id", id);
        return (Article) query.getSingleResult();
    }
        

}
