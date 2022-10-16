package org.devinhouse.labschool.model;

public enum MatriculaEnum {
    ATIVO(1),
    IRREGULAR(2),
    ATENDIMENTO_PEDAGOGICO(3),
    INATIVO(4);

    private int opcao;

    MatriculaEnum(int opcao){
        this.opcao = opcao;
    }

    public int getOpcao(){
        return opcao;
    }
}
