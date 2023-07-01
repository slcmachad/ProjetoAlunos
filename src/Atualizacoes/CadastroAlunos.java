package Atualizacoes;

import Bases.Aluno;

import java.util.ArrayList;
import java.util.List;

public class CadastroAlunos {

    private List<Aluno> listaAlunos;

    public CadastroAlunos(){
        listaAlunos = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, int idade, String curso){
        Aluno aluno = new Aluno(nome, idade, curso);
        listaAlunos.add(aluno);
    }

    public void listarAlunos(){
        if(listaAlunos.isEmpty()){
            System.out.println("Não há alunos cadastrados no momento");
        }else{
            System.out.println("Lista de alunos");
            for(Aluno aluno: listaAlunos){
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("--------------------------");
            }
        }
    }
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

}
