package com.example.Desafio.de.Programacao.Controllers;

import com.example.Desafio.de.Programacao.dtos.EstatisticaDTO;
import com.example.Desafio.de.Programacao.services.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    public ResponseEntity<EstatisticaDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca){
        return ResponseEntity.ok(estatisticaService.calcularEstatisticasTransacoes(intervaloBusca));
    }
}
