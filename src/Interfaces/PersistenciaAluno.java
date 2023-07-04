package Interfaces;

import Bases.Aluno;

import java.util.List;

public interface PersistenciaAluno {
    void salvarAlunos(List<Aluno> alunos);

    List<Aluno> carregarAlunos();
}
