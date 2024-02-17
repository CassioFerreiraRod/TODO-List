package tarefas;

import java.util.*;

public class ListaDeTarefas {
    List<Tarefa> listaTarefa;

    public ListaDeTarefas() {
        this.listaTarefa = new ArrayList<>();
        Tarefa tarefa1 = new Tarefa("nome", "descrição", "16/02/2024", 4, "Faculdade");
        tarefa1.setStatus("Done");
        Tarefa tarefa2 = new Tarefa("nome", "descrição", "16/02/2024", 2, "Trabalho");
        Tarefa tarefa3 = new Tarefa("nome", "descrição", "16/02/2024", 5, "Casa");
        tarefa3.setStatus("Doing");
        listaTarefa.add(tarefa2);
        listaTarefa.add(tarefa1);
        listaTarefa.add(tarefa3);
    }

    public void adicionarTarefa() {
        try (Scanner scan = new Scanner(System.in)) {

            System.out.println("Nome da tarefa: ");
            String nome = scan.nextLine();

            System.out.println("Descrição da tarefa: ");
            String descricao = scan.nextLine();

            System.out.println("Data de término da tarefa (dd/MM/yyyy): ");
            String dataDeTermino = scan.nextLine();

            System.out.println("Qual a categoria da tarefa (Casa Trabalho Faculdade): ");
            String categoria = scan.nextLine();

            System.out.println("Prioridade da tarefa valor entre (1-5): ");
            int prioridade = scan.nextInt();

            Tarefa tarefa = new Tarefa(nome, descricao, dataDeTermino, prioridade, categoria);
            listaTarefa.add(tarefa);
            System.out.println("Tarefa criada com sucesso.");
        }
    }

    public void listarTarefas() {
        if (!listaTarefa.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Como deseja listar as tarefas");
            System.out.println("1. Por Categoria");
            System.out.println("2. Por Prioridade");
            System.out.println("3. Por Status");

            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    listarPorCategoria();
                    break;
                case 2:
                    listarPorPrioridade();
                    break;
                case 3:
                    listarPorStatus();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    private void listarPorStatus() {
        System.out.println("Digite o status que deseja ver: (ToDo, Doing ou Done): ");
        String status = new Scanner(System.in).nextLine();
        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                if (tarefa.getStatus().equalsIgnoreCase(status)) {
                    System.out.println(tarefa);
                }
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    private void listarPorCategoria() {
        System.out.println("Digite a categoria que deseja ver: (Casa, Trabalho ou Faculdade): ");
        String categoria = new Scanner(System.in).nextLine();
        List<Tarefa> tarefasPorStatus = new ArrayList<>();
        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                    tarefasPorStatus.add(tarefa);
                }
            }
            for (Tarefa porStatus : tarefasPorStatus) {
                System.out.println(porStatus);
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }

    }

    private void listarPorPrioridade() {

        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                System.out.println(tarefa);
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }

    }

}
