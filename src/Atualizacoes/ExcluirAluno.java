package Atualizacoes;

import Bases.Aluno;
import Interfaces.PersistenciaAluno;

import java.util.List;

public class ExcluirAluno {
    private PersistenciaAluno persistencia;

    public ExcluirAluno(PersistenciaAluno persistencia) {
        this.persistencia = persistencia;
    }

    public void excluirAluno(String nome, List<Aluno> listaAlunos) {
        boolean alunoRemovido = false;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                listaAlunos.remove(aluno);
                alunoRemovido = true;
                break;
            }
        }
        if(alunoRemovido){
            System.out.println("Aluno removido com sucesso!");
            persistencia.salvarAlunos(listaAlunos);
        }else {
            System.out.println("Aluno não foi encontrado");
        }
    }
}
