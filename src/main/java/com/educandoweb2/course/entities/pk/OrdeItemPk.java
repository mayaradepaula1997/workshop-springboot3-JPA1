package com.educandoweb2.course.entities.pk;

import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

//CLASSE AUXILIAR PARA SER A CHAVE PRIMARIA


@Embeddable  //@Embeddable: Por ser uma classe auxiliar de chave composta
public class OrdeItemPk implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "order_id" )
    private Order order; //referencia Pedido/Order

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product; //referencia Produto/Product

    //ESSA CLASSE EM ESPECIAL NÃO TEM CONSTRUTOR

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //TENHO QUE COMPARAR TANTO O "ORDER" QUANTO O "PRODUCT"
    //PORQUE OS DOIS JUNTOS QUE IDENTIFICAM O ITEM

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdeItemPk that = (OrdeItemPk) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
