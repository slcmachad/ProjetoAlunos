package Atualizacoes;

import Bases.Aluno;

import java.util.List;

public class ExcluirAluno {
    public void excluirAluno(String nome, List<Aluno> listaAlunos){
        boolean alunoRemovido = false;
        for(Aluno aluno : listaAlunos){
            if(aluno.getNome().equalsIgnoreCase(nome)){
                listaAlunos.remove(aluno);
                alunoRemovido = true;
                break;
            }
        }
        if(alunoRemovido){
            System.out.println("Bases.Aluno removido com sucesso!");
        }else {
            System.out.println("Bases.Aluno não foi encontrado");
        }
    }
}
