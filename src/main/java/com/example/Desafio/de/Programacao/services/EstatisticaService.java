package com.example.Desafio.de.Programacao.services;

import com.example.Desafio.de.Programacao.Repositories.TransacaoRepository;
import com.example.Desafio.de.Programacao.dtos.EstatisticaDTO;
import com.example.Desafio.de.Programacao.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    public final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticaDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
        List<Transacao> transacoes = transacaoRepository.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes
                .stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new EstatisticaDTO(
                estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }
}
