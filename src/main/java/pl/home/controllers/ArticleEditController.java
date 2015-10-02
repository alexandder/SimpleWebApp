/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

/**
 *
 * @author maciej
 */
@SessionScoped
@ManagedBean
public class ArticleEditController {

    private Article toEditArticle;

    @EJB
    private ArticleService articleService;

    public ArticleEditController() {
    }

    @PostConstruct
    public void init() {
        toEditArticle = new Article();
    }

    public void edit() {
        System.out.println("Rozpoczynam edycje artykulu o id = " + toEditArticle.getId());
        articleService.edit(toEditArticle);
        toEditArticle = new Article();
        addFacesMessage("Zmieniono dane artykulu!");
    }

    public String loadToEdit() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleID");
        toEditArticle = articleService.find(Long.valueOf(id));
        System.out.println("Zaladowano do edycji artykul o id = " + toEditArticle.getId());
        return "editArticle?faces-redirect=true";
    }

    public Article getToEditArticle() {
        return toEditArticle;
    }

    public void setToEditArticle(Article toEditArticle) {
        this.toEditArticle = toEditArticle;
    }

    public static void addFacesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }
}
