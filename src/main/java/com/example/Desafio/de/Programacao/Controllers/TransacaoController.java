package com.example.Desafio.de.Programacao.Controllers;

import com.example.Desafio.de.Programacao.Repositories.TransacaoRepository;
import com.example.Desafio.de.Programacao.model.Transacao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping()
    public ResponseEntity<Object> salvar(@RequestBody @Valid Transacao transacao){
        transacaoRepository.salvar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }

    @DeleteMapping()
    public ResponseEntity<Object> deletar(@RequestBody @Valid Transacao transacao){
        transacaoRepository.deletar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
