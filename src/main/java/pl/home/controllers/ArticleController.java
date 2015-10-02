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

    public void add() {
        articleService.add(newArticle);
        addFacesMessage("Dodano nowy artykul do bazy danych!");
    }
    
    public List getList() {
        return articleService.getAll();
    }

    public Article getNewArticle() {
        return newArticle;
    }

    public void setNewArticle(Article newArticle) {
        this.newArticle = newArticle;
    }
    
    public String loadToEditArticle() {
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        newArticle = articleService.find(Long.MIN_VALUE);
        return "editArticle?faces-redirect=true";
    }
    
    public void edit() {
        String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleID");
        Long id = Long.valueOf(ids);
        newArticle.setId(id);
        articleService.edit(newArticle);
        addFacesMessage("Zmieniono dane artykulu!");
    }
    
    public static void addFacesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

}
