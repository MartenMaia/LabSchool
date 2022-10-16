package org.devinhouse.labschool.model;

public enum MenuEnum {
    CADASTRAR_NOVO_ALUNO(1),
    ATUALIZAR_SITUACAO_DA_MATRICULA(2),
    RELATORIO_DE_ALUNOS(3),
    CADASTRAR_NOVO_PROFESSOR(4),
    ATUALIZAR_STATUS_DO_PROFESSOR(5),
    RELATORIO_DE_PROFESSORES(6),
    CADASTRAR_NOVO_PEDAGOGO(7),
    REALIZAR_UM_ATENDIMENTO_PEDAGOGICO(8),
    LISTAGEM_DE_PESSOAS(9),
    ALUNOS_COM_MAIS_ATENDIMENTOS(10),
    PEDAGOGOS_COM_MAIS_ATENDIMENTOS(11),
    SAIR(00);

    private int opcao;

    MenuEnum( int opcao){
        this.opcao = opcao;
    }

    public int getOpcao(){
        return opcao;
    }
}
