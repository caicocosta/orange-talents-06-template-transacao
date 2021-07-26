package br.com.zupacademy.caico.transacao.buscatransacoes;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

        @KafkaListener(topics = "${spring.kafka.topic.transactions}")
        public void ouvir(Transacoes eventoDeTransacao) {
            System.out.println("Transacoes -----");
            System.out.println("Id: " + eventoDeTransacao.getId());
            System.out.println("Valor: " + eventoDeTransacao.getValor());
            System.out.println("Cartao: " + eventoDeTransacao.getCartao().getId());
            System.out.println("EfetivadaEm: " + eventoDeTransacao.getEfetivadaEm());
        }

}
