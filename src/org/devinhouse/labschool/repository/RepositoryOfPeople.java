package org.devinhouse.labschool.repository;

import org.devinhouse.labschool.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RepositoryOfPeople{

    private List<Aluno> listaAlunos = new ArrayList<>();
    private List<Professor> listaProfessores = new ArrayList<>();
    private List<Pedagogo> listaPedagogos = new ArrayList<>();

    public Integer tamanhaBase(){
        Integer tamanho = 0;
        tamanho += listaAlunos.isEmpty() ? 0 : listaAlunos.size();
        tamanho += listaProfessores.isEmpty() ? 0 : listaProfessores.size();
        tamanho += listaPedagogos.isEmpty() ? 0 : listaPedagogos.size();
        return tamanho;
    }

    public void addListaAlunos(Aluno alunos) {
        listaAlunos.add(alunos);
    }

    public void addListaProfessores(Professor professor) {
        this.listaProfessores.add(professor);
    }

    public void addListaPedagogos(Pedagogo pedagogo) {
        this.listaPedagogos.add(pedagogo);
    }

    public List<Pessoa> getListaCompleta(){
        List<Pessoa> lista = new ArrayList<>();
        for(Aluno al : listaAlunos){
            lista.add(al);
        }
        for(Professor prof : listaProfessores){
            lista.add(prof);
        }
        for(Pedagogo ped : listaPedagogos){
            lista.add(ped);
        }
        return lista;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    public List<Aluno> getListaAlunos(MatriculaEnum filtro) {
        List<Aluno> novaLista = new ArrayList<>();
        for (Aluno a : listaAlunos){
            if(a.getStatusMatricula().equals(filtro)){
                novaLista.add(a);
            }
        }
        return novaLista;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }
    public List<Professor> getListaProfessores(ExperienciaEnum filtro) {
        List<Professor> novaLista = new ArrayList<>();
        for (Professor p : listaProfessores){
            if(p.getExperiencia().equals(filtro)){
                novaLista.add(p);
            }
        }
        return novaLista;
    }

    public List<Pedagogo> getListaPedagogos() {
        return listaPedagogos;
    }

    public List<Pessoa> getListaProfessoresPedagogos(){
        List<Pessoa> lista = new ArrayList<>();
        for(Professor prof : listaProfessores){
            lista.add(prof);
        }
        for(Pedagogo ped : listaPedagogos){
            lista.add(ped);
        }
        return lista;
    }

    public void ordenar(List a){
        Collections.sort(a);
    }

}

