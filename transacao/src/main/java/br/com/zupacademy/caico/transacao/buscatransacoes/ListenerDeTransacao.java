package br.com.zupacademy.caico.transacao.buscatransacoes;

import br.com.zupacademy.caico.transacao.listaultimastransacoes.Transacoes;
import br.com.zupacademy.caico.transacao.listaultimastransacoes.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

        @Autowired
        private TransacoesRepository transacoesRepository;

        @KafkaListener(topics = "${spring.kafka.topic.transactions}")
        public void ouvir(TransacoesRetorno eventoDeTransacao) {
            Transacoes transacoes = new Transacoes(
                    eventoDeTransacao.getId(),
                    eventoDeTransacao.getValor(),
                    eventoDeTransacao.getCartao().getId(),
                    eventoDeTransacao.getEstabelecimento().getNome(),
                    eventoDeTransacao.getEfetivadaEm()
            );

            transacoesRepository.save(transacoes);
        }

}
