package br.com.maisumcode.vagasbackend.models;

import java.time.LocalDate;

public class Vaga {
    public String titulo;
    public double salario;
    private LocalDate dataCriacao = LocalDate.now();

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
