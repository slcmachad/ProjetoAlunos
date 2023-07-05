package InterfacesMetodos;

import Atualizacoes.CadastroAlunos;
import Bases.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaces.PersistenciaAluno;

public class InterfaceCadastroAlunos extends JFrame {
    private CadastroAlunos cadastro;
    private PersistenciaAluno persistencia;

    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtCurso;
    private JTextArea txtAlunos;
    private JButton btnCadastrar;
    private JButton btnListar;

    public InterfaceCadastroAlunos(CadastroAlunos cadastro) {
        this.cadastro = cadastro;

        setTitle("Cadastro de alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        txtNome = new JTextField(30);
        txtIdade = new JTextField(30);
        txtCurso = new JTextField(30);
        txtAlunos = new JTextArea(10, 30);
        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar ");

        setLayout(new FlowLayout());

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Idade:"));
        add(txtIdade);
        add(new JLabel("Curso"));
        add(txtCurso);
        add(btnCadastrar);
        add(btnListar);
        add(new JScrollPane(txtAlunos));

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAlunos();
            }
        });

        btnListar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaAluno();
            }
        }));

        pack();
        setVisible(true);
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

    public void cadastrarAlunos() {
        String nome = txtNome.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        String curso = txtCurso.getText();

        cadastro.cadastrarAluno(nome, idade, curso);

        txtNome.setText("");
        txtIdade.setText("");
        txtCurso.setText("");
    }
}
