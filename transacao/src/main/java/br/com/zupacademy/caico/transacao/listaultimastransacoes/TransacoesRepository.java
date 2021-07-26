package br.com.zupacademy.caico.transacao.listaultimastransacoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, UUID> {
    Page<Transacoes> findByNumCartao(String numCartao, Pageable paginacao);
}
