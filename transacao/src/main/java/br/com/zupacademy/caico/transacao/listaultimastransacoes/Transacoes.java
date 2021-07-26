package br.com.zupacademy.caico.transacao.listaultimastransacoes;

import br.com.zupacademy.caico.transacao.buscatransacoes.CartaoResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacoes {

    @Id
    private UUID id = UUID.randomUUID();

    @NotBlank
    @Column(nullable = false)
    private String idTransacao;

    @NotNull
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(nullable = false)
    private String numCartao;

    @NotBlank
    private String estabelecimento;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacoes() {
    }

    /**
     *
     * @param idTransacao
     * @param valor
     * @param numCartao
     * @param estabelecimento
     * @param efetivadaEm
     */



    public Transacoes(String idTransacao, BigDecimal valor, String numCartao, String estabelecimento, LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.numCartao = numCartao;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
