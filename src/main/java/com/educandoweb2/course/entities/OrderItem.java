package com.educandoweb2.course.entities;

import com.educandoweb2.course.entities.pk.OrdeItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //O PRIMEIRO ATRIBUTO VAI SER O IDENTIFICADOR, QUE É CORRESPONDENTE A CHAVE PRIMARIA "private OrdeItemPk id;"

    @EmbeddedId // por esse ser um ID composto
    private OrdeItemPk id; //correspondente a chave primaria
    private Integer quantity;
    private Double price;

    public OrderItem (){

    }

    public OrderItem( Order order , Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder (Order order){ //estou informando um Pedido, ai o metodo vai lá no meu "Id" e vao  "jogar" o pedido lá dentro
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct (Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
