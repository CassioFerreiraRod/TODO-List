package tarefas;

import java.util.*;

public class ListaDeTarefas {
    List<Tarefa> listaTarefa;

    public ListaDeTarefas() {
        this.listaTarefa = new ArrayList<>();
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
        int prioridade = new Scanner(System.in).nextInt();
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

    public void editarTarefa() {
        listarTodasTarefas();
        System.out.println("Digite o nome da tarefa que deseja editar: ");
        String entrada = new Scanner(System.in).nextLine();
        Tarefa tarefaParaEdicao = null;
        for (Tarefa tarefa : listaTarefa) {
            if (tarefa.getNome().equalsIgnoreCase(entrada)) {
                tarefaParaEdicao = tarefa;
            }
        }
        int opcao;
        System.out.println("O que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. Descrição");
        System.out.println("3. Data do término");
        System.out.println("4. Prioridade");
        System.out.println("5. Categoria");
        System.out.println("6. Status");
        Scanner scanner = new Scanner(System.in);
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome: ");
                String novoNome = new Scanner(System.in).nextLine();
                if (tarefaParaEdicao != null) {
                    tarefaParaEdicao.setNome(novoNome);
                }
                System.out.println("Tarefa editada");
                break;
            case 2:
                System.out.println("Digite a nova descrião: ");
                String novaDescricao = new Scanner(System.in).nextLine();
                if (tarefaParaEdicao != null) {
                    tarefaParaEdicao.setDescricao(novaDescricao);
                }
                System.out.println("Tarefa editada");
                break;
            case 3:
                System.out.println("Digite a nova data (dd/MM/yyyy): ");
                String navaData = new Scanner(System.in).nextLine();
                if (tarefaParaEdicao != null) {
                    tarefaParaEdicao.setDataDeTermino(navaData);
                }
                System.out.println("Tarefa editada");
                break;
            case 4:
                System.out.println("Digite a nova prioridade: ");
                int novaPrioridade = new Scanner(System.in).nextInt();
                if (tarefaParaEdicao != null) {
                    tarefaParaEdicao.setPrioridade(novaPrioridade);
                }
                System.out.println("Tarefa editada");
                break;
            case 5:
                System.out.println("Digite a nova categoria: ");
                String novaCategoria = new Scanner(System.in).nextLine();
                if (tarefaParaEdicao != null) {
                    tarefaParaEdicao.setCategoria(novaCategoria);
                }
                System.out.println("Tarefa editada");
                break;
            case 6:
                System.out.println("Digite o novo status (ToDo, Doing, Done): ");
                String novoStatus = new Scanner(System.in).nextLine().toUpperCase();
                try {
                    StatusTarefa statusTarefa = StatusTarefa.valueOf(novoStatus);
                    if (tarefaParaEdicao != null) {
                        tarefaParaEdicao.setStatus(statusTarefa);
                    }
                    System.out.println("Tarefa editada");
                } catch (IllegalArgumentException e) {
                    System.out.println("Opção '" + novoStatus + "' inválida.");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        atualizaTarefa(tarefaParaEdicao);

    }
    private void atualizaTarefa(Tarefa tarefaAtualizada) {
        listaTarefa.removeIf(t -> t.getNome().equalsIgnoreCase(tarefaAtualizada.getNome()));
        listaTarefa.add(tarefaAtualizada);
    }
}
