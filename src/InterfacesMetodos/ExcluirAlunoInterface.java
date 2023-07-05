package InterfacesMetodos;

import Atualizacoes.ExcluirAluno;
import Bases.Aluno;
import Interfaces.PersistenciaAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExcluirAlunoInterface extends JFrame {
    private ExcluirAluno excluirAluno;
    private List<Aluno> listaAlunos;

    private JTextField txtNome;
    private JButton btnExcluir;

    public ExcluirAlunoInterface(List<Aluno> listaAlunos, PersistenciaAluno persistencia) {
        this.listaAlunos = listaAlunos;
        this.excluirAluno = new ExcluirAluno(persistencia);

        setTitle("Excluir Aluno");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 150));

        txtNome = new JTextField(30);
        btnExcluir = new JButton("Excluir");

        setLayout(new FlowLayout());

        add(new JLabel("Nome:"));
        add(txtNome);
        add(btnExcluir);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirAluno();
            }
        });

        pack();
        setVisible(true);
    }

    private void excluirAluno() {
        String nome = txtNome.getText();
        excluirAluno.excluirAluno(nome, listaAlunos);

        txtNome.setText("");
    }
}
