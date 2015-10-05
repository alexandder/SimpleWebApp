/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

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

    public String loadToEdit() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleID");
        toEditArticle = articleService.find(Long.valueOf(id));
        Logger logger = Logger.getLogger("articleEditController");                                  // dodalem zeby przetestowac, mozna usunac
        logger.log(Level.INFO, "Zaladowano do edycji artykul o id = {0}", toEditArticle.getId());   // dodalem zeby przetestowac, mozna usunac
        return "editArticle?faces-redirect=true";
    }

    public String edit() {
        Logger logger = Logger.getLogger("articleEditContoller");
        logger.log(Level.INFO, "Ropoczynam edycje artykulu o id = {0}", toEditArticle.getId());
        articleService.edit(toEditArticle);
        toEditArticle = new Article();
        return "showArticles?faces-redirect=true";
    }

    public Article getToEditArticle() {
        return toEditArticle;
    }

    public void setToEditArticle(Article toEditArticle) {
        this.toEditArticle = toEditArticle;
    }

}
