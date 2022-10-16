package org.devinhouse.labschool.model;

import org.devinhouse.labschool.exception.InsercaoInvalidaException;

import java.security.spec.ECField;
import java.util.Scanner;

public class Professor extends Pessoa{
    private FormacaoEnum formacao;
    private ExperienciaEnum experiencia;
    private boolean estado; //True = Ativo | False = Inativo

    public FormacaoEnum getFormacao() {
        return formacao;
    }

    public void setFormacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   ➤ Informe o nivel de formação do professor:");
        System.out.println("      ➤ 1 - Graduação Incompleta ");
        System.out.println("      ➤ 2 - Graduação Completa ");
        System.out.println("      ➤ 3 - Mestrado ");
        System.out.println("      ➤ 4 - Doutorado ");
        System.out.print("   ➤ Opçao: ");
        boolean loop = true;
        while (loop){
            try {
                Integer opcao = scanner.nextInt();
                this.formacao = formacao(opcao);
                loop = false;
            }catch (InsercaoInvalidaException e){
                System.out.println("      ➤ Digite uma das opção validas :");
            }catch (Exception e){
                System.out.println("      OPÇÃO INVALIDA\n      ➤ Digite uma das opção validas :");
            }
        }
    }

    public FormacaoEnum formacao(Integer opcao) throws InsercaoInvalidaException {
        if(opcao <0 || opcao > 4){
            throw new InsercaoInvalidaException();
        }else {
            switch (opcao){
                case 1:
                    return FormacaoEnum.GRADUACAO_IMCOMPLETA;
                case 2:
                    return FormacaoEnum.GRADUACAO_COMPLETA;
                case 3:
                    return FormacaoEnum.MESTRADO;
                case 4:
                    return FormacaoEnum.DOUTORADO;
                default:
                    throw new InsercaoInvalidaException();
            }
        }

    }

    public ExperienciaEnum getExperiencia() {
        return experiencia;
    }

    public void setExperiencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   ➤ Informe a experiencia do professor");
        System.out.println("      ➤ 1 - FRONT_END ");
        System.out.println("      ➤ 2 - BACK_END ");
        System.out.println("      ➤ 3 - FULL_STACK ");
        System.out.print("   ➤ Opçao: ");
        boolean loop = true;
        while (loop) {
            try {
                Integer opcao = scanner.nextInt();
                this.experiencia = experiencia(opcao);
                loop = false;
            } catch (InsercaoInvalidaException e) {
                System.out.println("      ➤ Digite uma das opção validas :");
            } catch (Exception e) {
                System.out.println("      OPÇÃO INVALIDA\n      ➤ Digite uma das opção validas :");
            }
        }
    }

    public ExperienciaEnum experiencia(Integer opcao) throws InsercaoInvalidaException {
        if (opcao < 0 || opcao > 3) {
            throw new InsercaoInvalidaException();
        } else {
            return switch (opcao) {
                case 1 -> ExperienciaEnum.FRONT_END;
                case 2 -> ExperienciaEnum.BACK_END;
                case 3 -> ExperienciaEnum.FULL_STACK;
                default -> throw new InsercaoInvalidaException();
            };
        }
    }

    public String getEstado() {
        if(estado){
            return "Ativo";
        }else {
            return "Inativo";
        }
    }

    public void setEstado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("   ➤ O professor se encontra ativo? (Y/N) :");
        boolean loop = true;
        while (loop){
            boolean situacao = false;
            try {
                String opcao = scanner.next();
                if(opcao.equalsIgnoreCase("Y")){
                    this.estado = true;
                } else if(opcao.equalsIgnoreCase("N")) {
                    this.estado = false;
                }else {
                    throw new InsercaoInvalidaException();
                }
            }catch (InsercaoInvalidaException e){
                System.out.println("      INSERÇÃO INVALIDA\n      ➤ Digite apenas (Y ou N): ");
            }catch (Exception e) {
                System.out.println("      ➤ Digite (Y/N): ");
            }
            loop = false;
        }
    }
}
