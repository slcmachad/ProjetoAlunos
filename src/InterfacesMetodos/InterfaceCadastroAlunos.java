package InterfacesMetodos;

import Atualizacoes.CadastroAlunos;
import BancoDeDados.PersistenciaBancoDados;
import Interfaces.PersistenciaAluno;


import Bases.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCadastroAlunos extends JFrame {

    private CadastroAlunos cadastro;

    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtCurso;
    private JTextArea txtAlunos;
    private JButton btnCadastrar;
    private JButton btnListar;
    private JButton btnExcluir;

    public InterfaceCadastroAlunos(CadastroAlunos cadastro) {
        this.cadastro = cadastro;

        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));

        txtNome = new JTextField(30);
        txtIdade = new JTextField(30);
        txtCurso = new JTextField(30);
        txtAlunos = new JTextArea(10, 30);
        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar");
        btnExcluir = new JButton("Excluir");

        setLayout(new FlowLayout());

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Idade:"));
        add(txtIdade);
        add(new JLabel("Curso:"));
        add(txtCurso);
        add(btnCadastrar);
        add(btnListar);
        add(btnExcluir);
        add(new JScrollPane(txtAlunos));

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirCadastro();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirListaAlunos();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirExclusaoAluno();
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        PersistenciaAluno persistencia = new PersistenciaBancoDados();
        CadastroAlunos cadastro = new CadastroAlunos(persistencia);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceCadastroAlunos(cadastro);
            }
        });
    }

    private void exibirCadastro() {
        alterarVisibilidade(true, false, false);
    }

    private void exibirListaAlunos() {
        alterarVisibilidade(false, true, false);
        atualizarListaAluno();
    }

    private void exibirExclusaoAluno() {
        alterarVisibilidade(false, false, true);
    }

    private void atualizarListaAluno() {
        txtAlunos.setText("");

        for (Aluno aluno : cadastro.getListaAlunos()) {
            txtAlunos.append("Nome: " + aluno.getNome() + "\n");
            txtAlunos.append("Idade: " + aluno.getIdade() + "\n");
            txtAlunos.append("Curso: " + aluno.getCurso() + "\n");
            txtAlunos.append("------------------------------\n");
        }
    }

    private void alterarVisibilidade(boolean cadastrar, boolean listar, boolean excluir) {
        txtNome.setVisible(cadastrar);
        txtIdade.setVisible(cadastrar);
        txtCurso.setVisible(cadastrar);
        btnCadastrar.setVisible(cadastrar);
        btnListar.setVisible(listar);
        btnExcluir.setVisible(excluir);
    }
}
