package br.com.maisumcode.vagasbackend.dtos;

import java.util.List;

public class VagasPaginadas {
    public List<VagaCriada> conteudo;
    public int pagina;
    public int tamanho;
    public boolean ultimaPagina;
    public int totalPaginas;
}
