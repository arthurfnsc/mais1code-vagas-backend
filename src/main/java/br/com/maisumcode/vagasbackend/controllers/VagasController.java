package br.com.maisumcode.vagasbackend.controllers;

import br.com.maisumcode.vagasbackend.dtos.CriarVaga;
import br.com.maisumcode.vagasbackend.dtos.VagaCriada;
import br.com.maisumcode.vagasbackend.dtos.VagasPaginadas;
import br.com.maisumcode.vagasbackend.models.Vaga;
import br.com.maisumcode.vagasbackend.services.VagaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @DeleteMapping(value = "v1/vagas/{id}")
    public void remover(@PathVariable("id") int id) {
        service.remover(id);
    }

    @GetMapping(value = "v1/vagas", produces = { "application/json" })
    public VagasPaginadas listar(@RequestParam int pagina, @RequestParam int tamanho) {
        Page<Vaga> listar = service.listar(pagina, tamanho);

        VagasPaginadas vagasPaginadas = new VagasPaginadas();
        List<Vaga> content = listar.getContent();
        vagasPaginadas.conteudo = new ArrayList<>();

        for (Vaga vaga : content) {
            VagaCriada vagaCriada = new VagaCriada();
            vagaCriada.id = vaga.getId();
            vagaCriada.dataCriacao = vaga.getDataCriacao();
            vagaCriada.titulo = vaga.titulo;
            vagaCriada.salario = vaga.salario;

            vagasPaginadas.conteudo.add(vagaCriada);
        }

        vagasPaginadas.pagina = listar.getPageable().getPageNumber();
        vagasPaginadas.totalPaginas = listar.getTotalPages();
        vagasPaginadas.ultimaPagina = listar.isLast();
        vagasPaginadas.tamanho = listar.getSize();

        return vagasPaginadas;
    }

    @PostMapping(value = "v1/vagas", produces = { "application/json" })
    public VagaCriada cadastrar(@RequestBody CriarVaga criarVaga) {
        Vaga vaga = new Vaga();
        vaga.salario = criarVaga.salario;
        vaga.titulo = criarVaga.titulo;

        Vaga vagaCadastrada = service.cadastrar(vaga);

        VagaCriada vagaCriada = new VagaCriada();
        vagaCriada.id = vagaCadastrada.getId();
        vagaCriada.dataCriacao = vagaCadastrada.getDataCriacao();
        vagaCriada.salario = vagaCadastrada.salario;
        vagaCriada.titulo = vagaCadastrada.titulo;
        return vagaCriada;
    }
}
