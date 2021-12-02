package br.com.maisumcode.vagasbackend.controllers;

import br.com.maisumcode.vagasbackend.models.Vaga;
import br.com.maisumcode.vagasbackend.services.VagaService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagasController {

    private VagaService service;

    public VagasController(VagaService service) {
        this.service = service;
    }

    @GetMapping(value = "v1/vagas", produces = { "application/json" })
    public Page<Vaga> listar(@RequestParam int pagina, @RequestParam int tamanho) {
        return service.listar(pagina, tamanho);
    }

    @PostMapping(value = "v1/vagas", produces = { "application/json" })
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        return service.cadastrar(vaga);
    }
}
