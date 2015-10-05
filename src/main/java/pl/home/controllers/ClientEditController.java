/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.home.entities.Client;
import pl.home.services.ClientService;

@SessionScoped
@ManagedBean
public class ClientEditController {
    
    @EJB
    private ClientService clientService;
    
    private Client toEditClient;
    
    @PostConstruct
    public void init() {
        this.toEditClient = new Client();
    }
    
    public String loadToEdit() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("clientID");
        toEditClient = clientService.find(Long.valueOf(id));
        return "editClient?faces-redirect=true";
    }
    
    public String edit() {
        clientService.edit(toEditClient);
        toEditClient = new Client();
        return "showClients?faces-redirect=true";
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client getToEditClient() {
        return toEditClient;
    }

    public void setToEditClient(Client toEditClient) {
        this.toEditClient = toEditClient;
    }
    
    
    
}
