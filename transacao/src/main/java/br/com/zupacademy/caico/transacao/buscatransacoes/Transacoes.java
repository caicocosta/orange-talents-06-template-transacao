package br.com.zupacademy.caico.transacao.buscatransacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacoes {

    private String id;
    private BigDecimal valor;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
