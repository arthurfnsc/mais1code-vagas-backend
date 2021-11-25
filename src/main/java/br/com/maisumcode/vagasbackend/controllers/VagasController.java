package br.com.maisumcode.vagasbackend.controllers;

import br.com.maisumcode.vagasbackend.models.Vaga;
import br.com.maisumcode.vagasbackend.services.VagaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VagasController {

    private VagaService service = new VagaService();

    @GetMapping(value = "v1/vagas", produces = { "application/json" })
    public List<Vaga> listar() {
        return service.listar();
    }

    @PostMapping(value = "v1/vagas", produces = { "application/json" })
    public Vaga cadastrar(@RequestBody Vaga vaga) {
        return service.cadastrar(vaga);
    }
}
