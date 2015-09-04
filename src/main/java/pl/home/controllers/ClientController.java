package pl.home.controllers;

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

    private Client newClient = new Client();

    public String add() {
        clientService.add(newClient);
        return "index?faces-redirect=true";
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }
}
