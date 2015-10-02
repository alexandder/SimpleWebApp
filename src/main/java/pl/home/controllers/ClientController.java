package pl.home.controllers;

import javax.annotation.PostConstruct;
import pl.home.entities.Client;
import pl.home.services.ClientService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    
    public void add() {
        clientService.add(newClient);
        addFacesMessage("Dodano nowego klienta do bazy danych!");
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        this.newClient = newClient;
    }
    
    public static void addFacesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
        
    }
}
