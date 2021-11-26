package br.com.maisumcode.vagasbackend.services;

import br.com.maisumcode.vagasbackend.models.Vaga;
import br.com.maisumcode.vagasbackend.repositories.VagaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    private VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public Vaga cadastrar(Vaga vaga) {;
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listar() {
        return null;
    }
}
