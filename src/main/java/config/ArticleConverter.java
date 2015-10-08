/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import pl.home.entities.Article;
import pl.home.services.ArticleService;

@FacesConverter("articleConverter")
public class ArticleConverter implements Converter {

    @EJB
    ArticleService articleService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.valueOf(value);
        Article article = articleService.find(id);
        return article;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Article)) {
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji obiektu Article do String!"));
        }
        Article article = (Article) value;
        return article.getId().toString();
    }

}
