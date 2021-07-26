package br.com.zupacademy.caico.transacao.listaultimastransacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacoesResponse {

    private String estabelecimento;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;

    public TransacoesResponse(Transacoes transacao) {
        this.estabelecimento = transacao.getEstabelecimento();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
