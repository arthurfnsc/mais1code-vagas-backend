package br.com.maisumcode.vagasbackend.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tbl_vaga")
public class Vaga {
    @Id
    @GeneratedValue
    private Integer id;
    public String titulo;
    public double salario;
    private LocalDate dataCriacao;

    public Vaga() {
        dataCriacao = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
