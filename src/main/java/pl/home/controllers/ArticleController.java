/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

@RequestScoped
@ManagedBean
public class ArticleController {

    @EJB
    ArticleService articleService;

    private Article newArticle = new Article();

    public String add() {
        articleService.add(newArticle);
        return "index?faces-redirect=true";
    }
    /*
    public String editArticle(Long id, String name, Float price, String description) {
        articleService.editArticle(id, name, price, description);
        return "index?faces-redirect=true";
    }
    */
    public Article getNewArticle() {
        return newArticle;
    }

    public void setNewArticle(Article newArticle) {
        this.newArticle = newArticle;
    }

}
