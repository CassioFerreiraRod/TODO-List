package menu;

import tarefas.ListaDeTarefas;

import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int entrada;
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        do {
            System.out.println("ToDo List");
            System.out.println("Digite uma opção do que deseja fazer:");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefa");
            System.out.println("3. Excluir Tarefa");
            System.out.println("4. Editar Tarefa");
            System.out.println("5. Para sair");
            entrada = scanner.nextInt();
            switch (entrada){
                case 1:
                    listaDeTarefas.adicionarTarefa();
                    break;
                case 2:
                    listaDeTarefas.listarTarefas();
                    break;
                case 3:
                    listaDeTarefas.excluirTarefas();
                    break;
                case 4:
                    listaDeTarefas.editarTarefa();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente\n");
                    break;
            }

        } while (entrada !=5);
    }
}
