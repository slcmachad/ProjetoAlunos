package Atualizacoes;
import Bases.Aluno;

import java.util.List;

import Interfaces.PersistenciaAluno;

public class CadastroAlunos {
    private PersistenciaAluno persistencia;

    private List<Aluno> listaAlunos;

    public CadastroAlunos(PersistenciaAluno persistencia) {
        this.persistencia = persistencia;
        listaAlunos = persistencia.carregarAlunos();
    }

    public void cadastrarAluno(String nome, int idade, String curso) {
        Aluno aluno = new Aluno(nome, idade, curso);
        listaAlunos.add(aluno);
        persistencia.salvarAlunos(listaAlunos);
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public PersistenciaAluno getPersistencia() {
        return persistencia;
    }
}
