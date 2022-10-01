package br.me.desafio.backendchallenge.entities.enuns;

public enum OrderStatus {
    APROVADO("APROVADO"),
    REPROVADO("REPROVADO"),
    CODIGO_PEDIDO_INVALIDO("CODIGO_PEDIDO_INVALIDO"),
    APROVADO_QTD_A_MAIOR("APROVADO_QTD_A_MAIOR"),
    APROVADO_QTD_A_MENOR("APROVADO_QTD_A_MENOR"),
    APROVADO_VALOR_A_MAIOR("APROVADO_VALOR_A_MAIOR"),
    APROVADO_VALOR_A_MENOR("APROVADO_VALOR_A_MENOR");


    private String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /*private String  code;

    private OrderStatus(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
*/
/*    public static OrderStatus valueOf(String code){
        for (OrderStatus value : OrderStatus.values()){
            if (code == value.getCode()){
                return value;

            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }*/
}
