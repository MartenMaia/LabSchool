package org.devinhouse.labschool.cli;

import org.devinhouse.labschool.exception.InsercaoInvalidaException;
import org.devinhouse.labschool.model.*;
import org.devinhouse.labschool.repository.RepositoryOfPeople;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class Display {

    /**
     * Código de boas vindas ao Lab School!
     */
    public void inicializar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("" +
                " __       ________    _______       ______   ______   ___   ___   ______   ______   __          \n" +
                "/_/\\     /_______/\\ /_______/\\     /_____/\\ /_____/\\ /__/\\ /__/\\ /_____/\\ /_____/\\ /_/\\         \n" +
                "\\:\\ \\    \\::: _  \\ \\\\::: _  \\ \\    \\::::_\\/_\\:::__\\/ \\::\\ \\\\  \\ \\\\:::_ \\ \\\\:::_ \\ \\\\:\\ \\        \n" +
                " \\:\\ \\    \\::(_)  \\ \\\\::(_)  \\/_    \\:\\/___/\\\\:\\ \\  __\\::\\/_\\ .\\ \\\\:\\ \\ \\ \\\\:\\ \\ \\ \\\\:\\ \\       \n" +
                "  \\:\\ \\____\\:: __  \\ \\\\::  _  \\ \\    \\_::._\\:\\\\:\\ \\/_/\\\\:: ___::\\ \\\\:\\ \\ \\ \\\\:\\ \\ \\ \\\\:\\ \\____  \n" +
                "   \\:\\/___/\\\\:.\\ \\  \\ \\\\::(_)  \\ \\     /____\\:\\\\:\\_\\ \\ \\\\: \\ \\\\::\\ \\\\:\\_\\ \\ \\\\:\\_\\ \\ \\\\:\\/___/\\ \n" +
                "    \\_____\\/ \\__\\/\\__\\/ \\_______\\/     \\_____\\/ \\_____\\/ \\__\\/ \\::\\/ \\_____\\/ \\_____\\/ \\_____\\/ \n" +
                "                                                                                                ");
        System.out.println("                                                                          Desing by Dev. MartenMaia ");
        System.out.println();
        System.out.println("Pressione ENTER para ir ao MENU:");
        scanner.nextLine();
    }

    /**
     * Menu de apresentação de opções
     */

    public void abrirMenu() {
        System.out.println("      ==================== MENU - LAB SCHOOL ===================");
        System.out.println("     |   ALUNO                                                  |");
        System.out.println("     |      1 | Cadastrar novo aluno                            |");
        System.out.println("     |      2 | Atualizar situação de matricula                 |");
        System.out.println("     |      3 | Relatório de alunos                             |");
        System.out.println("     |   PROFESSOR                                              |");
        System.out.println("     |      4 | Cadastrar novo professor                        |");
        System.out.println("     |      5 | Relatório de professores                        |");
        System.out.println("     |   PEDAGOGO                                               |");
        System.out.println("     |      6 | Cadastrar novo pedagogo                         |");
        System.out.println("     |   ATENDIMENTO PEDAGÓGICO                                 |");
        System.out.println("     |      7 | Realizar um atendimento pedagógico              |");
        System.out.println("     |                                                          |");
        System.out.println("     |   RELATORIOS                                             |");
        System.out.println("     |      8 | Listagem de pessoas                             |");
        System.out.println("     |      9 | Alunos com mais atendimentos pedagógicos        |");
        System.out.println("     |     10 | Pedagogos com mais atendimentos                 |");
        System.out.println("     |                                                          |");
        System.out.println("     |                               00 | SAIR DO PROGRAMA      |");
        System.out.println("     |__________________________________________________________|");
    }

    public void cadastroAluno(RepositoryOfPeople base){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCADASTRO DE UM NOVO ALUNO");
        System.out.print("Digite as informações solicitadas abaixo\n\n");
        System.out.println("ATENÇÃO - Utilize apenas LETRAS E NUMEROS para efetuar o cadastro");

        while (true){
            Aluno aluno = new Aluno();
            System.out.println();
            aluno.setNome();
            aluno.setTelefone();
            aluno.setCpf();
            aluno.setDataNascimento();
            aluno.setCodigo(base);
            aluno.setNotaSeletivo();
            aluno.setStatusMatricula();
            base.addListaAlunos(aluno);
            System.out.println("\n"+aluno.getCodigo()+" | CADASTRO REALIZADO COM SUCESSO!");
            System.out.print("Deseja cadastrar um novo aluno? (Y/N) :");
            String novoCadastro = scanner.next();
            if(!novoCadastro.equalsIgnoreCase("y")){
                System.out.println();
                System.out.println("        CADASTRO FINALIZADO!\n");
                scanner.nextLine();
                break;
            }
        }
        System.out.println("Pressione ENTER para ir ao MENU:");
        scanner.nextLine();
    }

    public void atualizarMatricula(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMENU DE ATUALIZAÇÃO DE MATRICULO");
        System.out.print("Digite o codigo do aluno com 11 digitos e em seguida, atualize a sua situação de matricula\n\n");

        while (true){
            System.out.print("  ➤ Codigo do aluno: ");
            int cont = 0;
            Integer codigo = scanner.nextInt();
            for(Aluno aluno : base.getListaAlunos()){
                if(aluno.getCodigo().equals(codigo)){
                    System.out.print("Aluno: "+aluno.getNome()+" | Status atual: "+aluno.getStatusMatricula()+"\n");
                    aluno.setStatusMatricula();
                    cont++;
                }
            }
            if (cont == 0){
                System.out.println("CODIGO NÃO ENCONTRADO!");
            }else {
                System.out.println("AJUSTE FINALIZADO");
            }
            System.out.print("Deseja fazer um novo ajuste de matricula? (Y/N) :");
            String novoConsulta = scanner.next();
            if(!novoConsulta.equalsIgnoreCase("y")){
                System.out.println();
                System.out.println("Pressione ENTER para ir ao MENU:");
                scanner.nextLine();
                break;
            }
        }
        scanner.nextLine();
    }

    public void relatorioAlunos(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

                System.out.println("\nRELATORIO DE ALUNOS");
        while (true) {
            List<Aluno> alunos = new ArrayList<>();
            System.out.print("    ➤ Selecione uma opção de filtro abaixo: \n");
            System.out.println("      ➤ 1 - Alunos ativos ");
            System.out.println("      ➤ 2 - Alunos Irregulares ");
            System.out.println("      ➤ 3 - Alunos em Atendimento pedagógico ");
            System.out.println("      ➤ 4 - Alunos Inativos ");
            System.out.println("      ➤ 5 - Todos ");
            try {
                Integer opcao = scanner.nextInt();
                if (opcao < 0 || opcao > 5) {
                    throw new InsercaoInvalidaException();
                }
                switch (opcao) {
                    case 1 -> alunos = base.getListaAlunos(MatriculaEnum.ATIVO);
                    case 2 -> alunos = base.getListaAlunos(MatriculaEnum.IRREGULAR);
                    case 3 -> alunos = base.getListaAlunos(MatriculaEnum.ATENDIMENTO_PEDAGOGICO);
                    case 4 -> alunos = base.getListaAlunos(MatriculaEnum.INATIVO);
                    case 5 -> alunos = base.getListaAlunos();
                }

                if (!alunos.isEmpty()) {
                    for (Aluno aluno : alunos) {
                        System.out.println("Codigo: " + aluno.getCodigo());
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Nota Seletiva: " + aluno.getNotaSeletivo());
                        System.out.println("Atend. Pedagogicos: " + aluno.getQtdaAtendimento() + "\n");
                    }
                }else {
                    System.out.println("   ➤ LISTA VAZIA");
                }

                System.out.print("Deseja fazer uma nova consulta? (Y/N) :");
                String novoConsulta = scanner.next();
                if(!novoConsulta.equalsIgnoreCase("y")){
                    System.out.println();
                    System.out.println("Pressione ENTER para ir ao MENU:");
                    scanner.nextLine();
                    break;
                }

            }catch (InsercaoInvalidaException e){
                System.out.println("   OPÇÃO INVALIDO");
            }
        }
        scanner.nextLine();
    }

    public void cadastroProfessor(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCADASTRO DE UM NOVO PROFESSOR");
        System.out.print("Digite as informações solicitadas abaixo\n\n");
        System.out.println("ATENÇÃO - Utilize apenas LETRAS E NUMEROS para efetuar o cadastro");

        while (true){
            Professor professor = new Professor();
            System.out.println();
            professor.setNome();
            professor.setTelefone();
            professor.setCpf();
            professor.setDataNascimento();
            professor.setCodigo(base);
            professor.setFormacao();
            professor.setExperiencia();
            professor.setEstado();
            base.addListaProfessores(professor);
            System.out.println("\n"+professor.getCodigo()+" | CADASTRO REALIZADO COM SUCESSO!");
            System.out.print("Deseja cadastrar um novo professor? (Y/N) :");
            String novoCadastro = scanner.next();
            if(!novoCadastro.equalsIgnoreCase("y")){
                System.out.println();
                System.out.println("\n        CADASTRO FINALIZADO!");
                scanner.nextLine();
                break;
            }
        }

        System.out.println();
        System.out.println("Pressione ENTER para ir ao MENU:");
        scanner.nextLine();
    }

    public void relatorioProfessor(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRELATORIO DE PROFESSORES");
        while (true) {
            List<Professor> professores = new ArrayList<>();
            System.out.print("    ➤ Selecione uma opção de filtro abaixo: \n");
            System.out.println("      ➤ 1 - Professor Front-End ");
            System.out.println("      ➤ 2 - Professor Back-End ");
            System.out.println("      ➤ 3 - Professor Full Stack ");
            System.out.println("      ➤ 4 - Todos ");
            try {
                Integer opcao = scanner.nextInt();
                if (opcao < 0 || opcao > 4) {
                    throw new InsercaoInvalidaException();
                }
                switch (opcao) {
                    case 1 -> professores = base.getListaProfessores(ExperienciaEnum.FRONT_END);
                    case 2 -> professores = base.getListaProfessores(ExperienciaEnum.BACK_END);
                    case 3 -> professores = base.getListaProfessores(ExperienciaEnum.FULL_STACK);
                    case 4 -> professores = base.getListaProfessores();
                }

                if(!professores.isEmpty()) {
                    for (Professor professor : professores) {
                        System.out.println("Codigo: " + professor.getCodigo());
                        System.out.println("Nome: " + professor.getNome());
                        System.out.println("Formação Academica: " + professor.getFormacao());
                        System.out.println("Experiencia: " + professor.getExperiencia());
                        System.out.println("Estado: " + professor.getEstado() + "\n");
                    }
                }else {
                    System.out.println("   ➤ LISTA VAZIA");
                }

                System.out.print("Deseja fazer uma nova consulta? (Y/N) :");
                String novoConsulta = scanner.next();
                if(!novoConsulta.equalsIgnoreCase("y")){
                    System.out.println();
                    System.out.println("Pressione ENTER para ir ao MENU:");
                    scanner.nextLine();
                    break;
                }

            }catch (InsercaoInvalidaException e){
                System.out.println("   OPÇÃO INVALIDO");
            }
        }
        scanner.nextLine();
    }

    public void cadastroPedagogo(RepositoryOfPeople base){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println("\nCADASTRO DE UM NOVO PEDAGOGO");
        System.out.print("Digite as informações solicitadas abaixo\n\n");
        System.out.println("ATENÇÃO - Utilize apenas LETRAS E NUMEROS para efetuar o cadastro");

        while (loop) {
            Pedagogo pedagogo = new Pedagogo();
            System.out.println();
            pedagogo.setNome();
            pedagogo.setTelefone();
            pedagogo.setCpf();
            pedagogo.setDataNascimento();
            pedagogo.setCodigo(base);
            base.addListaPedagogos(pedagogo);
            System.out.println("\n"+pedagogo.getCodigo()+" | CADASTRO REALIZADO COM SUCESSO!");
            System.out.print("Deseja cadastrar um novo pedagogo? (Y/N) :");
            String novoCadastro = scanner.next();
            if(!novoCadastro.equalsIgnoreCase("y")){
                loop=false;
            }
        }

        System.out.println("\n        CADASTRO FINALIZADO!");
        System.out.println();
        System.out.println("        Pressione ENTER para ir ao MENU:");
        scanner.nextLine();
    }

    public void atendimentoPedagogico(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nATENDIMENTO PEDAGOGICO");
            while (true) {
                Pessoa selecao1 = null;
                Aluno selecao2 = null;

                System.out.println("Informe o CODIGO do pedagogo que realizou o ATENDIMENTO PEDAGOGICO");
                /**
                 * Seleção e verificação do pedagogo
                 */
                while (true) {
                    try {
                        System.out.print("   ➤ ");
                        Integer codigo = scanner.nextInt();
                        Boolean codValido = null;
                        Pessoa atendente = null;
                        for (Pedagogo ped : base.getListaPedagogos()) {
                            if (ped.getCodigo().equals(codigo)) {
                                atendente = ped;
                                codValido = false;
                            }
                        }
                        if (codValido == null) {
                            for (Professor prof : base.getListaProfessores()) {
                                if (prof.getCodigo().equals(codigo)) {
                                    atendente = prof;
                                    codValido = true;
                                }
                            }
                        }
                        if (codValido == null) {
                            throw new InsercaoInvalidaException();
                        } else {
                            System.out.println("   CODIGO VALIDO! - " + atendente.getNome() + "\n");
                            selecao1 = atendente;
                            break;
                        }
                    } catch (InsercaoInvalidaException e) {
                        System.out.println("CODIGO NÃO ENCONTRADO ENTRE OS PEDAGOGOS");
                        System.out.println("   ➤ Insirá um novo código: ");
                    }
                }

                System.out.println("Informe o CODIGO do aluno");
                /**
                 * Seleção e verificação do aluno
                 */
                while (true) {
                    try {
                        System.out.print("   ➤ ");
                        Integer codigo = scanner.nextInt();
                        Boolean codValido = null;
                        Aluno atendido = null;
                        for (Aluno aluno : base.getListaAlunos()) {
                            if (aluno.getCodigo().equals(codigo)) {
                                atendido = aluno;
                                codValido = false;
                            }
                        }
                        if (codValido == null) {
                            throw new InsercaoInvalidaException();
                        } else {
                            System.out.println("   CODIGO VALIDO! - " + atendido.getNome() + "\n");
                            selecao2 = atendido;
                            break;
                        }
                    } catch (InsercaoInvalidaException e) {
                        System.out.println("CODIGO NÃO ENCONTRADO ENTRE OS ALUNOS");
                        System.out.println("   ➤ Insirá um novo código: ");
                    }
                }

                System.out.println("ATENDIMENTO REALIZADO COM SUCESSO\n");

//                System.out.println("      O " + selecao1.getClass().getSimpleName() + " ➤ " + selecao1.getNome().toUpperCase()+" realizou");
//                System.out.println("      um atendimento pedagogico no ➤ " + selecao2.getNome().toUpperCase());

                //Adição do atendimento na base
                adicionaAtendimentos(base, selecao1, selecao2);

                /**
                 * Loop do fechamento
                 */
                System.out.print("Deseja fazer uma nova atendimento? (Y/N) :");
                String novoConsulta = scanner.next();
                if (!novoConsulta.equalsIgnoreCase("y")) {
                    System.out.println();
                    System.out.println("Pressione ENTER para ir ao MENU:");
                    scanner.nextLine();
                    break;
                }
                System.out.println();
            }
        scanner.nextLine();
    }

    public void listagemPessoas(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLISTAGEM DE PESSOAS");
        while (true) {
            System.out.print("    ➤ Selecione uma opção de filtro abaixo: \n");
            System.out.println("      ➤ 1 - Alunos");
            System.out.println("      ➤ 2 - Professores");
            System.out.println("      ➤ 3 - Pedagogos");
            System.out.println("      ➤ 4 - Todos ");
            try {
                System.out.println(" ➤ ");
                Integer opcao = scanner.nextInt();
                if(opcao <0 || opcao>4){
                    throw new InsercaoInvalidaException();
                }
                switch (opcao){
                    case 1:
                        List<Aluno> alunos = base.getListaAlunos();
                        if(!alunos.isEmpty()) {
                            for (Aluno al : alunos) {
                                System.out.println("Codigo: " + al.getCodigo() + " | Nome:" + al.getNome() + " | CPF:" + al.getCpf());
                            }
                        }else {
                            System.out.println("   ➤ LISTA VAZIA");
                        }
                        break;
                    case 2:
                        List<Professor> professores = base.getListaProfessores();
                        if(!professores.isEmpty()) {
                            for (Professor prof : professores) {
                                System.out.println("Codigo: " + prof.getCodigo() + " | Nome:" + prof.getNome() + " | CPF:" + prof.getCpf());
                            }
                        }else {
                            System.out.println("   ➤ LISTA VAZIA");
                        }
                        break;
                    case 3:
                        List<Pedagogo> pedagogos = base.getListaPedagogos();
                        if(!pedagogos.isEmpty()) {
                            for (Pedagogo ped : pedagogos) {
                                System.out.println("Codigo: " + ped.getCodigo() + " | Nome:" + ped.getNome() + " | CPF:" + ped.getCpf());
                            }
                        }else {
                            System.out.println("   ➤ LISTA VAZIA");
                        }
                        break;
                    case 4:
                        List<Pessoa> pessoas = base.getListaCompleta();
                        if(!pessoas.isEmpty()) {
                            for (Pessoa pessoa : pessoas) {
                                System.out.println("Codigo: " + pessoa.getCodigo() + " | Nome:" + pessoa.getNome() + " | CPF:" + pessoa.getCpf());
                            }
                        }else {
                            System.out.println("   ➤ LISTA VAZIA");
                        }
                        break;
                }
                /**
                 * Loop do fechamento
                 */
                System.out.print("    Deseja extrair uma nova listagem? (Y/N) :");
                String novoConsulta = scanner.next();
                System.out.println();
                if (!novoConsulta.equalsIgnoreCase("y")) {
                    System.out.println("Pressione ENTER para ir ao MENU:");
                    scanner.nextLine();
                    break;
                }

            }catch (InsercaoInvalidaException e){
                System.out.println(" Opção invalido!");
                System.out.print(" Escolha uma nova opção :");
            }
        }
        scanner.nextLine();
    }

    public void maisAtendimentoAlunos(RepositoryOfPeople base) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRELATORIO DE ALUNOS COM MAIS ATENDIMENTOS PEDAGOGICOS");
        while (true) {
            System.out.print("   ➤ Relação de alunos: \n");
            try {
                List<Aluno> listaOrdenada = base.getListaAlunos();
                if (!listaOrdenada.isEmpty()) {
                    Collections.sort(listaOrdenada);
                    Collections.reverse(listaOrdenada);
                    for (Aluno aluno : listaOrdenada) {
                        System.out.println("Codigo: " + aluno.getCodigo() + " | Nome: " + aluno.getNome() + " | Total de atendimentos: " + aluno.getQtdaAtendimento());
                    }
                }else {
                    throw new InsercaoInvalidaException();
                }
            }catch (InsercaoInvalidaException e){
                System.out.println("   ➤ LISTA VAZIA");
            }

            System.out.println();
            System.out.println("Pressione ENTER para ir ao MENU:");
            scanner.nextLine();
            break;

        }
    }

    public void maisAtendimentoPedagogos(RepositoryOfPeople base) { // PRECISA SER TERMINADO
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRELATORIO DE PEDAGOGOS COM MAIS ATENDIMENTOS");
        while (true) {
            System.out.print("   ➤ Relação de professores e pedagogos: \n");
            try {
                List<Pessoa> listaOrdenada = base.getListaProfessoresPedagogos();
                if (!listaOrdenada.isEmpty()) {
                    Collections.sort(listaOrdenada);
                    Collections.reverse(listaOrdenada);
                    for (Pessoa pessoa : listaOrdenada) {
                        System.out.println("Codigo: " + pessoa.getCodigo() + " | Nome: " + pessoa.getNome() + " | Total de atendimentos: " + pessoa.getQtdaAtendimento());
                    }
                }else {
                    throw new InsercaoInvalidaException();
                }
            }catch (InsercaoInvalidaException e){
                System.out.println("   ➤ LISTA VAZIA");
            }

            System.out.println();
            System.out.println("Pressione ENTER para ir ao MENU:");
            scanner.nextLine();
            break;
        }
    }

    /**
     * Adição de um atendimento ao selecionar Pedagogo/Professor e um Aluno validos
     * @param base
     * @param pessoa
     * @param aluno
     */
    private void adicionaAtendimentos(RepositoryOfPeople base,Pessoa pessoa, Aluno aluno){
        if(pessoa.getClass().getSimpleName().equals("Professor")) {
            for (Professor profBase : base.getListaProfessores()) {
                if (profBase.getCodigo() == pessoa.getCodigo()) {
                    profBase.addAtendimento();
                }
            }
        }else {
            for (Pedagogo pedBase : base.getListaPedagogos()) {
                if (pedBase.getCodigo() == pessoa.getCodigo()) {
                    pedBase.addAtendimento();
                }
            }
        }

        for(Aluno alunoBase : base.getListaAlunos()) {
            if (alunoBase.getCodigo() == aluno.getCodigo()) {
                alunoBase.addAtendimento();
            }
        }
    }

}
