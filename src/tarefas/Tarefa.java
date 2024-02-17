package tarefas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate dataDeTermino;
    private int prioridade;
    private String categoria;
    private StatusTarefa status;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa(String nome, String descricao, String dataDeTermino, int prioridade, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = LocalDate.parse(dataDeTermino, formatter);
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = StatusTarefa.TODO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(String dataDeTermino) {
        this.dataDeTermino = LocalDate.parse(dataDeTermino, formatter);
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "Nome: " + nome +
                ", Descrição: " + descricao +
                ", Data do Término: " + dataDeTermino +
                ", Prioridade: " + prioridade +
                ", Categoria: " + categoria +
                ", Status: " + status +
                '}';
    }
}

enum StatusTarefa{
    TODO,
    DOING,
    DONE
}