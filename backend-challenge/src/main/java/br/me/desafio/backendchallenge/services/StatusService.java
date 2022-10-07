package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.dto.StatusDtoRequest;
import br.me.desafio.backendchallenge.dto.StatusDtoResponse;
import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.entities.enums.OrderStatus;
import br.me.desafio.backendchallenge.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderStatus itemValidation(int qntItensTotalOrder, int qntItensAprovados) {
        OrderStatus status = OrderStatus.APROVADO;
        if (qntItensTotalOrder > qntItensAprovados) {
            status = OrderStatus.APROVADO_QTD_A_MENOR;
        }
        if (qntItensTotalOrder < qntItensAprovados) {
            status = OrderStatus.APROVADO_QTD_A_MAIOR;
        }
        return status;
    }

    public OrderStatus valorValidation(double valortTotalOrder, double valorAprovados) {
        OrderStatus status = OrderStatus.APROVADO;
        if (valortTotalOrder > valorAprovados) {
            status = OrderStatus.APROVADO_VALOR_A_MENOR;
        }
        if (valortTotalOrder < valorAprovados) {
            status = OrderStatus.APROVADO_VALOR_A_MAIOR;
        }
        return status;
    }

    public StatusDtoResponse getStatus(StatusDtoRequest payload) {
        StatusDtoResponse response = new StatusDtoResponse(payload.getId());
        if (payload.getStatus() == OrderStatus.REPROVADO) {
            response.setStatus(List.of(OrderStatus.REPROVADO));
            return response;
        }
        Optional<Order> obj = orderRepository.findById(payload.getId());  //getById

        if (obj.isEmpty()) {
            response.setStatus(List.of(OrderStatus.CODIGO_PEDIDO_INVALIDO));
            return response;
        }

        Order order = obj.get();
        double valorTotal = order.valorTotal();
        int quantidadeTotal = order.quantidadeTotal();

        List<OrderStatus> statusX = new ArrayList<>();
        OrderStatus itemStatus = itemValidation(quantidadeTotal, payload.getItensAprovados());

        if (itemStatus != OrderStatus.APROVADO)
            statusX.add(itemStatus);

        OrderStatus valorStatus = valorValidation(valorTotal, payload.getValorAprovado());
        if (valorStatus != OrderStatus.APROVADO)
            statusX.add(valorStatus);

        if (valorStatus == OrderStatus.APROVADO && itemStatus == OrderStatus.APROVADO)
            statusX.add(OrderStatus.APROVADO);


        response.setStatus(statusX);
        return response;
    }


}
