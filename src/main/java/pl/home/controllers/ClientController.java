package pl.home.controllers;

import javax.annotation.PostConstruct;
import pl.home.entities.Client;
import pl.home.services.ClientService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClientController {

    @EJB
    ClientService clientService;

    private Client newClient;

    @PostConstruct
    public void init() {
        this.newClient = new Client();
    }
    
    public String add() {
        clientService.add(newClient);      
        return "showClients?faces-redirect=true";
    }
    
    public String delete(Client client) {
        clientService.delete(client);
        return "showClients?faces-redirect=true";
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }
    
}
