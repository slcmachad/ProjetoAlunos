package Interfaces;

import Bases.Aluno;

import java.util.List;

public interface PersistenciaAluno {
    List<Aluno> carregarAlunos();

    void salvarAlunos(List<Aluno> alunos);
}
