/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "clientOrder")
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM ClientOrder o")
})
public class ClientOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderID")
    private Long id;

    @Column(name = "orderDescription")
    private String description;

    @JoinTable(name = "ORDER",
            joinColumns = {
                @JoinColumn(name = "orderID",
                        referencedColumnName = "orderID")},
            inverseJoinColumns = {
                @JoinColumn(name = "articleID",
                        referencedColumnName = "articleID")}
    )
    @ManyToMany
    private Collection<Article> orderArticles = new ArrayList<>();

    @JoinColumn(name = "clientID",
            referencedColumnName = "clientID")
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Article> getOrderArticles() {
        return orderArticles;
    }

    public void setOrderArticles(Collection<Article> orderArticles) {
        this.orderArticles = orderArticles;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.description);
        hash = 73 * hash + Objects.hashCode(this.orderArticles);
        hash = 73 * hash + Objects.hashCode(this.client);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientOrder other = (ClientOrder) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.orderArticles, other.orderArticles)) {
            return false;
        }
        return true;
    }
    
    

}
