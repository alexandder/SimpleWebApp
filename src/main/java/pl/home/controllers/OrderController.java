/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.home.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.home.entities.ClientOrder;
import pl.home.services.OrderService;

@ManagedBean
@RequestScoped
public class OrderController {

    @EJB
    private OrderService orderService;

    private ClientOrder order;

    @PostConstruct
    public void init() {
        order = new ClientOrder();
    }

    public String add() {
        orderService.add(order);
        return "showOrders?faces-redirect=true";
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public ClientOrder getOrder() {
        return order;
    }

    public void setOrder(ClientOrder order) {
        this.order = order;
    }

}
