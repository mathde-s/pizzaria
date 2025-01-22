```
class Pagamento {
- Long id
- Long pedidoId
- Double valorPago
- LocalDateTime data
- FormaPagamento formaPagamento

        + Pagamento(Double valorPago, FormaPagamento formaPagamento)
        + Long getId()
        + void setId(Long id)
        + Long getPedidoId()
        + void setPedidoId(Long pedidoId)
        + Double getValorPago()
        + void setValorPago(Double valorPago)
        + FormaPagamento getFormaPagamento()
        + void setFormaPagamento(FormaPagamento formaPagamento)
        + LocalDateTime getData()
        + void setData(LocalDateTime data)
    }
```
