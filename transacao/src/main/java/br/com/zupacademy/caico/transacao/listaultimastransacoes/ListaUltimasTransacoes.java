package br.com.zupacademy.caico.transacao.listaultimastransacoes;

import br.com.zupacademy.caico.transacao.exceptionhandler.ApiErroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListaUltimasTransacoes {

    @Autowired
    private TransacoesRepository transacoesRepository;


    @GetMapping("/cartoes/{numCartao}/ultimascompras")
    public Page<TransacoesResponse> ultimasCompras(
            @PathVariable String numCartao,
            @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, size = 10)
            Pageable paginacao){
        Page<Transacoes> transacoes = transacoesRepository.findByNumCartao(numCartao, paginacao);

        if(transacoes.isEmpty()) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
        }

        Page<TransacoesResponse> response = transacoes.map(TransacoesResponse::new);

        return response;
    }
}
