package com.educandoweb2.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToMany                 //"tb_product_category": nome da tabela relacional no banco de dados // "product_id": nome da chave estrangeira // inverseJoinColumns: define a chave estrangeira da outra entidade "category"
    @JoinTable (name = "tb_product_category", joinColumns = @JoinColumn (name = "product_id"), inverseJoinColumns = @JoinColumn (name = "category_id"))
    private Set <Category> categories = new HashSet<>(); //Set: representa um conjunto, para garantir que não vou ter um produto com a mesma ocorrencia
                                                         //new: Já precisamos instanciar o conjunto para garantir que a coleção não começe valendo "nulo"
                                                        //HashSet<>: O "Set" é uma interface,não pode ser instanciado, se utiliza uma classe correspondente que no caso é a HashSet<>

    @OneToMany (mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>(); //Declara a coleção de "itens"


    public Product (){

    }

        public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders (){ //O método "Get" vai retorna uma lista de "Order" e não de "OrderItem"
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items){
            set.add(x.getOrder());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
