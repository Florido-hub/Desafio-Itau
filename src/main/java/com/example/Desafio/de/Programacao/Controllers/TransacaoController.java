package com.example.Desafio.de.Programacao.Controllers;

import com.example.Desafio.de.Programacao.Repositories.TransacaoRepository;
import com.example.Desafio.de.Programacao.model.Transacao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping()
    public ResponseEntity<Transacao> salvar(@RequestBody @Valid Transacao transacao){
        transacaoRepository.salvar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }
}
