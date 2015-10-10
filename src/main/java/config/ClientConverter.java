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
import pl.home.entities.Client;
import pl.home.services.ClientService;

@FacesConverter("config.clientConverter")
public class ClientConverter implements Converter {

    @EJB
    ClientService clientService;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.valueOf(value);
        Client client = clientService.find(id);
        return client;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if ( !(value instanceof Client))
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji obiektu Client do String!"));
        Client client = (Client) value;
        return client.getId().toString();
    }
    
}
