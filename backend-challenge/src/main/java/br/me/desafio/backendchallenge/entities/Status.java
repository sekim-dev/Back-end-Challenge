package br.me.desafio.backendchallenge.entities;

import br.me.desafio.backendchallenge.entities.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Status implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedido;
    private int intensAprovados;
    private int valorAprovado;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private String orderStatus;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();   //Set (interface) representa um conjunto != de List. impede repetir o mesmo item.

    public Status() {
    }

    public Status(Long id, Long pedido, int intensAprovados, int valorAprovado, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.pedido = pedido;
        this.intensAprovados = intensAprovados;
        this.valorAprovado = valorAprovado;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public int getIntensAprovados() {
        return intensAprovados;
    }

    public void setIntensAprovados(int intensAprovados) {
        this.intensAprovados = intensAprovados;
    }

    public int getValorAprovado() {
        return valorAprovado;
    }

    public void setValorAprovado(int valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getOrderStatus();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<Item> getItems() {
        return items;
    }

}
