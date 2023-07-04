package Atualizacoes;

import Bases.Aluno;

import javax.swing.*;


public class AtualizarDados {


    public void atualizar(Aluno aluno, int digito) {
        switch (digito) {
            case 1 -> {
                String novoNome = JOptionPane
                        .showInputDialog(null,
                                "Digite o nome corrigido: ",
                                "Atualizar Nome",
                                JOptionPane.PLAIN_MESSAGE
                        );
                if (novoNome != null) {
                    aluno.setNome(novoNome);
                }
            }
            case 2 -> {
                String novaIdade = JOptionPane.showInputDialog(
                        null,
                        "Digite a idade correta do aluno: ",
                        "Atualizar idade",
                        JOptionPane.PLAIN_MESSAGE
                );
                if (novaIdade != null) {
                    try {
                        int idade = Integer.parseInt(novaIdade);
                        aluno.setIdade(idade);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Valor invalido, digite apenas numeros!",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
            case 3 -> {
                String curso = JOptionPane.showInputDialog(
                        null,
                        "Digite o curso do aluno:",
                        "Atualizar curso",
                        JOptionPane.PLAIN_MESSAGE
                );
                if (curso != null) {
                    aluno.setCurso(curso);
                }
            }
            default -> {
                JOptionPane.showMessageDialog(
                        null,
                        "Opção inválida!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
