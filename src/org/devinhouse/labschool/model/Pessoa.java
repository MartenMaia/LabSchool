package org.devinhouse.labschool.model;

import org.devinhouse.labschool.exception.InsercaoInvalidaException;
import org.devinhouse.labschool.repository.RepositoryOfPeople;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private Long telefone;
    private LocalDate dataNascimento;
    private Long cpf;
    private Integer codigo;
    private Integer qtdaAtendimento = 0;

    public void addAtendimento() {
        this.qtdaAtendimento++;
    }

    public void setNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("   ➤ Nome completo: ");
        boolean loop = true;
        while (loop){
            try {
                String nome = scanner.nextLine();
                this.nome = nome;
                loop = false;
            }catch (Exception e){
                System.out.print("   Nome Invalido  - ➤ Insira novamente: ");
            }
        }
    }

    public void setTelefone(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("   ➤ Telefone: ");
        boolean loop = true;
        while (loop){
            try {
                String textoTel = scanner.nextLine();
                Long telefone = Long.parseLong(textoTel);
                if (telefoneValido(telefone)){
                    this.telefone = telefone;
                    loop = false;
                }else {
                    throw new InsercaoInvalidaException();
                }
            }catch (InsercaoInvalidaException e){
                System.out.print("   TELEFONE INVALIDO \n   ➤ DIGITE DD+NUMERO: ");
            }
            catch (Exception e){
                System.out.print("   TELEFONE INVALIDO \n   ➤ DIGITE DD+NUMERO | APENAS NUMEROS: ");
            }

        }
    }

    private boolean telefoneValido(Long tel) throws InsercaoInvalidaException{
        if(tel>99999999999L || tel.toString().contains(" ") || tel.toString().contains("-") || tel.toString().contains(")")){
             throw new InsercaoInvalidaException();
        }else {
            return true;
        }
    }

    public void setDataNascimento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("   ➤ Data de Nascimento: ");
        DateTimeFormatter formaData = DateTimeFormatter.ofPattern("ddMMyyyy");
        boolean loop = true;
        while (loop){
            try {
                String dataNasc = scanner.nextLine();
                this.dataNascimento = LocalDate.parse(dataNasc,formaData);
                loop = false;
            }catch (Exception e){
                System.out.print("   INSERÇÃO INVALIDA \n   ➤ DIGITE APENAS NUMEROS NO FORMATO(ddMMyyyy): ");
                continue;
            }
        }
    }

    public void setCpf() {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formaDecimal = new DecimalFormat("00000000000");
        System.out.print("   ➤ CPF: ");
        boolean loop = true;
        while (loop){
            try {
                Long cpf = scanner.nextLong();
                if(cpfValido(cpf)){
                    this.cpf = cpf;
                    loop = false;
                }else {
                    throw new InsercaoInvalidaException();
                }
            }catch (InsercaoInvalidaException e){
                System.out.print("   ➤ CPF COM MAIS DE 11 DIGITOS\n   ➤ DIGITE O CPF NOVAMENTE: ");
            }catch (Exception e){
                System.out.print("   CPF INVALIDO\n   ➤ DIGITE APENAS OS NUMEROS: ");
            }
        }
    }

    private boolean cpfValido(Long cpf) throws InsercaoInvalidaException{
        if(cpf > 99999999999L){
            throw new InsercaoInvalidaException();
        }else {
            return true;
        }
    }

    public void setCodigo(RepositoryOfPeople base) {
        LocalDate hoje = LocalDate.now();
        Integer anoInt = hoje.getYear();
        String ano = anoInt.toString().substring(2);
        Integer mesInt = hoje.getMonthValue();
        String mes = mesInt.toString();
        DecimalFormat formaDecimal = new DecimalFormat("0000");
        this.codigo = Integer.valueOf(ano+mes+(formaDecimal.format(base.tamanhaBase()+1)));
    }

    public Integer getQtdaAtendimento() {
        return qtdaAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Pessoa o) {
        return getQtdaAtendimento().compareTo(o.getQtdaAtendimento());
    }
}
