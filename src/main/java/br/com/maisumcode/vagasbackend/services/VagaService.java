package br.com.maisumcode.vagasbackend.services;

import br.com.maisumcode.vagasbackend.models.Vaga;
import java.util.ArrayList;
import java.util.List;

public class VagaService {

    private List<Vaga> vagas = new ArrayList<>();

    public Vaga cadastrar(Vaga vaga) {
        if (vaga.salario < 0) {
            vaga.salario = 0;
        } else {
            vaga.salario += 100;
        }
        vaga.titulo = "Título: " + vaga.titulo;
        vagas.add(vaga);
        return vaga;
    }

    public List<Vaga> listar() {
        return vagas;
    }
}
