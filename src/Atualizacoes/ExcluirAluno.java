package Atualizacoes;

import Bases.Aluno;
import CadastrosAlunos.PersistenciaBancoDados;
import Interfaces.PersistenciaAluno;

import java.util.List;

public class ExcluirAluno {
    private PersistenciaAluno persistencia;
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

            CadastroAlunos cadastro = new CadastroAlunos(new PersistenciaBancoDados());
            cadastro.setListaAlunos(listaAlunos);
            persistencia.salvarAlunos(listaAlunos);
        }else {
            System.out.println("Bases.Aluno não foi encontrado");
        }
    }
}
