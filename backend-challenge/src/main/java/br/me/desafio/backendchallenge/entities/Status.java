
package br.me.desafio.backendchallenge.entities;


import br.me.desafio.backendchallenge.entities.enuns.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_status")
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int itensAprovados;
    private double valorAprovado;
    private OrderStatus mainStatus;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

//    private List<OrderStatus> statusList = new ArrayList<>();

    public Status(Long id, int itensAprovados, double valorAprovado, OrderStatus mainStatus) {
        this.id = id;
//        this.order = order;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.mainStatus = mainStatus;

    }

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getItensAprovados() {
        return itensAprovados;
    }

    public void setItensAprovados(int itensAprovados) {
        this.itensAprovados = itensAprovados;
    }

    public double getValorAprovado() {
        return valorAprovado;
    }

    public void setValorAprovado(double valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public OrderStatus getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(OrderStatus orderStatus) {
        this.mainStatus = orderStatus;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public List<OrderStatus> getStatusList() {
//        return statusList;
//    }
//
//    public void setStatusList(List<OrderStatus> statusList) {
//        this.statusList = statusList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status = (Status) o;
        return Objects.equals(getId(), status.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
