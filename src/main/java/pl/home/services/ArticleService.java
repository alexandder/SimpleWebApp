/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.services;

import config.FacesMessageHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Logger logger = Logger.getLogger("articleService");
        logger.log(Level.INFO, "Koncze edycje artykulu o id = {0}", article.getId());
        entityManager.merge(article);
        FacesMessageHelper.addFacesMessage("Zmieniono dane artykułu!");
    }
    
    public void add(Article a) {
        entityManager.persist(a);
        FacesMessageHelper.addFacesMessage("Dodano nowy artykuł!");
    }

    public void delete(Article article) {
        Article toRemove = entityManager.merge(article);
        entityManager.remove(toRemove);
    }

    public Article find(Long id) {
        Article a = entityManager.find(Article.class, id);        
        return a;
    }
        

}
