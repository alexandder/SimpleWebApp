/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.home.entities.ClientOrder;
import pl.home.services.OrderService;

@ManagedBean
@RequestScoped
public class OrdersController {
    
    @EJB
    OrderService orderService;
    
    private List<ClientOrder> orderList;
    
    @PostConstruct
    public void init() {
        orderList = orderService.getAll();
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<ClientOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ClientOrder> orderList) {
        this.orderList = orderList;
    }
    
    
    
}
