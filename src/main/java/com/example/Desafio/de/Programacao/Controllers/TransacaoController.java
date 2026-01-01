package com.example.Desafio.de.Programacao.Controllers;

import com.example.Desafio.de.Programacao.Repositories.TransacaoRepository;
import com.example.Desafio.de.Programacao.model.Transacao;
import jakarta.validation.Valid;
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
    public ResponseEntity<Void> salvar(@RequestBody @Valid Transacao transacao){
        transacaoRepository.salvar(transacao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Object> deletar(){
        transacaoRepository.deletar();
        return ResponseEntity.ok().build();
    }
}
