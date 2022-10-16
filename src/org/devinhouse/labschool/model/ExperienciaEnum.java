package org.devinhouse.labschool.model;

public enum ExperienciaEnum {
    FRONT_END(1),
    BACK_END(2),
    FULL_STACK(3);

    private int opcao;

    ExperienciaEnum( int opcao){
        this.opcao = opcao;
    }

    public int getOpcao(){
        return opcao;
    }
}
