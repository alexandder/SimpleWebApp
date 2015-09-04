/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

@RequestScoped
@Named("articlesController")
public class ArticlesControllers {
    
    @EJB
    ArticleService articleService;
    
    private List<Article> articles;
    
    @PostConstruct
    public void init() {
        articles = articleService.getAll();
    }
    
    public String editArticle(Long id) {
        return "editArticle?id="+id.toString()+"faces-redirect=true";
    }
    
    public String newArticle() {
        return "addArticle?faces-redirect=true";
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    
}
