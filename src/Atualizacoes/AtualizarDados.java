package Atualizacoes;

import Bases.Aluno;

import java.util.Scanner;

public class AtualizarDados {
    Scanner scanner = new Scanner(System.in);
    public void atualizarDados(Aluno aluno, String nome, int idade,  String curso){
        aluno.setNome(nome);
        aluno.setCurso(curso);
        aluno.setIdade(idade);
        System.out.println("Dados do aluno atualizados com sucesso!");
    }

    public void atualizar(Aluno aluno, int digito){
        switch (digito) {
            case 1 -> {
                System.out.println("Digite a correção do nome do aluno:");
                String nome = scanner.next();
                aluno.setNome(nome);
            }
            case 2 -> {
                System.out.println("Digite idade do aluno:");
                int idade = scanner.nextInt();
                aluno.setIdade(idade);
            }
            case 3 -> {
                System.out.println("Digite o curso do aluno:");
                String curso = scanner.next();
                aluno.setCurso(curso);
            }
            default -> System.out.println("Opção inválida!");
        }
    }
}
