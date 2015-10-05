/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

@RequestScoped
@ManagedBean
public class ArticleController {

    @EJB
    ArticleService articleService;

    private Article newArticle;

    @PostConstruct
    public void initialize() {
        newArticle = new Article();
    }

    public String add() {
        articleService.add(newArticle);
        return "showArticles?faces-redirect=true";
    }

    public String delete(Article article) {
        articleService.delete(article);
        return "showArticles?faces-redirect=true";
    }

    public void edit() {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleID");
        newArticle.setId(Long.valueOf(ids));
        articleService.edit(newArticle);
    }

    public List<Article> getList() {
        return articleService.getAll();
    }

    public Article getNewArticle() {
        return newArticle;
    }

    public void setNewArticle(Article newArticle) {
        this.newArticle = newArticle;
    }

}
