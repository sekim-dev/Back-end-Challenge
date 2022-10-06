package br.me.desafio.backendchallenge.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @JsonProperty("pedido")
    private String id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("Itens")
    private Set<Item> items = new HashSet<>();  //Set (interface) representa um conjunto != de List. impede repetir o mesmo item.

//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonProperty("Status")
//    private Status status;

    public Order(String id) {
        this.id = id;
    }

    public Order(String id, Set<Item> items) {
        this.id = id;
        this.items = items;
    }

    public Order() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Order item) {
        items.remove(item);
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void ListItems(Set<Item> items) {
        this.items = items;
    }

    public double valorTotal() {
        double sum = 0.0;
        for (Item i : items) {
            sum += i.getSubtotal();
        }
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


