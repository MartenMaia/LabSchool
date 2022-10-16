package org.devinhouse.labschool.model;

import org.devinhouse.labschool.exception.InsercaoInvalidaException;

import java.util.Scanner;

public class Aluno extends Pessoa{

    private Double notaSeletivo; //Ser inserido no momento da inserção
    private MatriculaEnum statusMatricula;

    public Double getNotaSeletivo() {
        return notaSeletivo;
    }

    public void setNotaSeletivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("   ➤ Nota da Seletiva: ");
        boolean loop = true;
        while (loop){
            try {
                Double nota = scanner.nextDouble();
                if(nota.isNaN() || nota>10 || nota < 0){
                    throw new InsercaoInvalidaException();
                }
                this.notaSeletivo = nota;
                loop = false;
            }catch (Exception e){
                System.out.print("   NOTA INVALIDO\n   ➤ DIGITE APENAS NUMEROS: ");
            }
        }
    }

    public MatriculaEnum getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   ➤ Informe a situação da Matricula");
        System.out.println("      ➤ 1 - Ativo ");
        System.out.println("      ➤ 2 - Irregular ");
        System.out.println("      ➤ 3 - Atendimento Pegadogico ");
        System.out.println("      ➤ 4 - Inativo ");
        System.out.print("   ➤ Opçao: ");
        boolean loop = true;
        while (loop){
            try{
                Integer opcao = scanner.nextInt();
                this.statusMatricula = validacaoStatus(opcao);
                loop = false;
            }catch (InsercaoInvalidaException e){
                System.out.print("      ➤ Digite uma das opção validas :");
            }catch (Exception e){
                System.out.print("      OPÇÃO INVALIDA\n      ➤ Digite uma das opção validas :");
            }
        }
    }

    private MatriculaEnum validacaoStatus(Integer opcao) throws InsercaoInvalidaException {
        if(opcao>4 || opcao<0){
            throw new InsercaoInvalidaException();
        }else {
            switch (opcao) {
                case 1:
                    return MatriculaEnum.ATIVO;
                case 2:
                    return MatriculaEnum.IRREGULAR;
                case 3:
                    return MatriculaEnum.ATENDIMENTO_PEDAGOGICO;
                case 4:
                    return MatriculaEnum.INATIVO;
                default:
                    throw new InsercaoInvalidaException();
            }
        }
    }
}
