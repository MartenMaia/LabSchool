package org.devinhouse.labschool;

import org.devinhouse.labschool.cli.Display;
import org.devinhouse.labschool.exception.InsercaoInvalidaException;
import org.devinhouse.labschool.repository.RepositoryOfPeople;

import java.util.Scanner;

public class Aplicacao {

    public void executar() {
        boolean execucao = true;
        String opcaoMenu;
        Display display = new Display();
        RepositoryOfPeople base = new RepositoryOfPeople();

        display.inicializar();

        while(execucao) {
            try {
                display.abrirMenu();
                opcaoMenu = opcao(); // Solicito a opção do menu
                execucao = menu(opcaoMenu,base,execucao); // Abro o menu correspondente
            }catch (Exception e){
                System.out.println("Erro");
            }
        }
    }

    private static String opcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("        ➤ Selecione a opção desejada: ");
        String opcao = scanner.next();
        return opcao;
    }

    private static boolean menu(String opcao, RepositoryOfPeople base, boolean execucao){
        Display display = new Display();

        switch (opcao) {
            case "1" -> display.cadastroAluno(base);
            case "2" -> display.atualizarMatricula(base);
            case "3" -> display.relatorioAlunos(base);
            case "4" -> display.cadastroProfessor(base);
            case "5" -> display.relatorioProfessor(base);
            case "6" -> display.cadastroPedagogo(base);
            case "7" -> display.atendimentoPedagogico(base);
            case "8" -> display.listagemPessoas(base);
            case "9" -> display.maisAtendimentoAlunos(base);
            case "10" -> display.maisAtendimentoPedagogos(base);// PRECISA SER TERMINADO
            case "00" -> {
                System.out.println("\n                    ==== FECHANDO APLICAÇÃO ====");
                System.out.println("\n");
                return  !execucao;
            }
            default -> System.out.println("OPÇÃO INVALIDO");
        }
        return true;
    }

}
