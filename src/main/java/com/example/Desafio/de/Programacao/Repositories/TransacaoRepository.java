package com.example.Desafio.de.Programacao.Repositories;

import com.example.Desafio.de.Programacao.model.Transacao;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<Transacao> listaTransacao = new ArrayList<>();

    public void salvar(Transacao transacao){
        listaTransacao.add(transacao);
    }

    public void deletar(){
        listaTransacao.clear();
    }

    public List<Transacao> buscarTransacoes(Integer intervaloBusca) {

        OffsetDateTime dataLimite = OffsetDateTime.now().minusDays(intervaloBusca);

        return listaTransacao.stream()
                .filter(t -> t.getDataHora().isAfter(dataLimite)
                        || t.getDataHora().isEqual(dataLimite))
                .toList();
    }
}
