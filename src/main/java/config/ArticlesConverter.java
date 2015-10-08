/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import pl.home.entities.Article;
import pl.home.entities.ClientOrder;
import pl.home.services.OrderService;

@FacesConverter("articlesConverter")
public class ArticlesConverter implements Converter {

    @EJB
    OrderService orderService;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.valueOf(value);
        ClientOrder order = orderService.find(id);
        Collection<Article> collection =  order.getOrderArticles();
        return collection;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (! (value instanceof Collection))
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji Collection do String!"));
        return "jakis String";
    }
    
    
}
