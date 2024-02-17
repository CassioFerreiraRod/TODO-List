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
    private String status;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa(String nome, String descricao, String dataDeTermino, int prioridade, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = LocalDate.parse(dataDeTermino, formatter);
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = "ToDo";
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "Nome: " + nome +
                ", Descricao: " + descricao +
                ", DataDeTermino: " + dataDeTermino +
                ", Prioridade: " + prioridade +
                ", Categoria: " + categoria +
                ", Status: " + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(categoria, tarefa.categoria) && Objects.equals(status, tarefa.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, status);
    }
}