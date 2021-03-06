package pl.home.controllers;

import pl.home.entities.Client;
import pl.home.services.ClientService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.faces.bean.ManagedBean;

@RequestScoped
@ManagedBean
public class ClientsController {

    @EJB
    ClientService clientService;

    private List<Client> clients;

    @PostConstruct
    public void init() {
        clients = clientService.getAll();
    }

    public String newClient() {
        return "addClient?faces-redirect=true";
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
