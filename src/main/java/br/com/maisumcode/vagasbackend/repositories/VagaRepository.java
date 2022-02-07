package br.com.maisumcode.vagasbackend.repositories;

import br.com.maisumcode.vagasbackend.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {}
