package Atualizacoes;

import Bases.Aluno;

import java.util.ArrayList;
import java.util.List;

public class BuscaAlunoPorNome {
    public void buscaAlunoPorNome(String nome, List<Aluno> listaAlunos){
        List<Aluno> alunosEncontrados = new ArrayList<>();

        for(Aluno aluno: listaAlunos){
            if(aluno.getNome().equalsIgnoreCase(nome)){
                alunosEncontrados.add(aluno);
            }
        }

        if(alunosEncontrados.isEmpty()){
            System.out.println("Desculpe nenhum aluno com o nome "+ nome + " foi encontrado");
        }else{
            System.out.println("Alunos cadastrados: ");
            for(Aluno aluno : alunosEncontrados){
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("--------------------------");
            }
        }
    }
}
