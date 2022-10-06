
package br.me.desafio.backendchallenge.entities;


import br.me.desafio.backendchallenge.entities.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private OrderStatus Status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    //private List<OrderStatus> statusList;

    public Status(Long id, int itensAprovados, double valorAprovado, OrderStatus status) {
        this.id = id;
        this.order = order;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.Status = status;

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

    public OrderStatus getStatus() {
        return Status;
    }

    public void setStatus(OrderStatus orderStatus) {
        this.Status = orderStatus;
    }

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
