package org.devinhouse.labschool.model;

public enum FormacaoEnum {
    GRADUACAO_IMCOMPLETA(1),
    GRADUACAO_COMPLETA(2),
    MESTRADO(3),
    DOUTORADO(4);

    private int opcao;

    FormacaoEnum( int opcao){
        this.opcao = opcao;
    }

    public int getOpcao(){
        return opcao;
    }
}
