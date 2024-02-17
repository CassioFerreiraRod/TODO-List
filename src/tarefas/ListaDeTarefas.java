package tarefas;

import java.util.*;

public class ListaDeTarefas {
    List<Tarefa> listaTarefa;

    public ListaDeTarefas() {
        this.listaTarefa = new ArrayList<>();
        Tarefa tarefa1 = new Tarefa("nome", "descrição", "16/02/2024", 4, "Casa");
        tarefa1.setStatus(StatusTarefa.DONE);
        Tarefa tarefa2 = new Tarefa("tarefa", "descrição", "16/02/2024", 2, "Trabalho");
        Tarefa tarefa3 = new Tarefa("nome", "descrição", "16/02/2024", 5, "Casa");
        tarefa3.setStatus(StatusTarefa.DOING);
        listaTarefa.add(tarefa2);
        listaTarefa.add(tarefa1);
        listaTarefa.add(tarefa3);
    }

    public void adicionarTarefa() {
        Scanner scan = new Scanner(System.in);

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
        scan.nextLine();

        Tarefa tarefa = new Tarefa(nome, descricao, dataDeTermino, prioridade, categoria);
        listaTarefa.add(tarefa);
        System.out.println("Tarefa criada com sucesso.");

    }

    public void listarTarefas() {
        if (!listaTarefa.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Como deseja listar as tarefas");
            System.out.println("1. Por Categoria");
            System.out.println("2. Por Prioridade");
            System.out.println("3. Por Status");
            System.out.println("4. Para listar todas");

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
                case 4:
                    listarTodasTarefas();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    private void listarTodasTarefas() {
        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                System.out.println(tarefa);
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    private void listarPorStatus() {
        System.out.println("Digite o status que deseja ver: (ToDo, Doing ou Done): ");
        String entrada = new Scanner(System.in).nextLine().toUpperCase();
        List<Tarefa> tarefasPorStatus = new ArrayList<>();
        if (!listaTarefa.isEmpty()) {
            try {
                StatusTarefa status = StatusTarefa.valueOf(entrada);
                listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
                for (Tarefa tarefa : listaTarefa) {
                    if (tarefa.getStatus().equals(status)) {
                        tarefasPorStatus.add(tarefa);
                    }
                }
                for (Tarefa porStatus : tarefasPorStatus) {
                    System.out.println(porStatus);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Opção '" + entrada + "' inválida.");
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    private void listarPorCategoria() {
        System.out.println("Digite a categoria que deseja ver: (Casa, Trabalho ou Faculdade): ");
        String categoria = new Scanner(System.in).nextLine();
        List<Tarefa> tarefasPorCategoria = new ArrayList<>();
        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                    tarefasPorCategoria.add(tarefa);
                }
            }
            for (Tarefa porStatus : tarefasPorCategoria) {
                System.out.println(porStatus);
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }

    }

    private void listarPorPrioridade() {
        System.out.println("Digite o nível de prioridade que deseja (1-5)");
        Integer prioridade = new Scanner(System.in).nextInt();
        List<Tarefa> tarefasPorPrioridade = new ArrayList<>();
        if (!listaTarefa.isEmpty()) {
            listaTarefa.sort(Comparator.comparingInt(Tarefa::getPrioridade).reversed());
            for (Tarefa tarefa : listaTarefa) {
                if (tarefa.getPrioridade() == prioridade) {
                    tarefasPorPrioridade.add(tarefa);
                }
            }
            for (Tarefa tarefaPorPrioridade : tarefasPorPrioridade) {
                System.out.println(tarefaPorPrioridade);
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

    public void excluirTarefas() {
        listarTodasTarefas();
        System.out.println("Digite o nome da tarefa que deseja excluir: ");
        String entrada = new Scanner(System.in).nextLine();
        boolean encontrou = false;
        if (!listaTarefa.isEmpty()) {
            Iterator<Tarefa> iterator = listaTarefa.iterator();
            while (iterator.hasNext()) {
                Tarefa tarefaAExcluir = iterator.next();
                if (tarefaAExcluir.getNome().equalsIgnoreCase(entrada)) {
                    iterator.remove();
                    System.out.println("Tarefa excluída.");
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou) {
                System.out.println("Não encontrado.");
            }
        } else {
            System.out.println("Nenhuma tarefa");
        }
    }

}
