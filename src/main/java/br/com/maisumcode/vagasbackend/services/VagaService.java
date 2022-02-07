package br.com.maisumcode.vagasbackend.services;

import br.com.maisumcode.vagasbackend.models.Vaga;
import br.com.maisumcode.vagasbackend.repositories.VagaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Vaga> listar(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        return vagaRepository.findAll(pageable);
    }

    public void remover(int id) {
        vagaRepository.deleteById(id);
    }
}
