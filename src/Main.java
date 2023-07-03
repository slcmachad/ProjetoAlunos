import javax.swing.*;
import java.awt.*;
import java.util.List;

import Atualizacoes.AtualizarDados;
import Atualizacoes.BuscaAlunoPorNome;
import Atualizacoes.CadastroAlunos;
import Bases.Aluno;
public class Main {

    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();
        BuscaAlunoPorNome busca = new BuscaAlunoPorNome();
        AtualizarDados atualizarDados = new AtualizarDados();

        //Campo de cadastro

        JFrame frame = new JFrame("Cadastro de alunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        frame.add(nomeLabel);
        JTextField nomeTextField = new JTextField();
        frame.add(nomeTextField);

        JLabel idadeLabel = new JLabel("Idade:");
        frame.add(idadeLabel);
        JTextField idadeTextField = new JTextField();
        frame.add(idadeTextField);

        JLabel cursoLabel = new JLabel("Curso");
        frame.add(cursoLabel);
        JTextField cursoTextField = new JTextField();
        frame.add(cursoTextField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(e -> {
            String nome = nomeTextField.getText();
            int idade = Integer.parseInt(idadeTextField.getText());
            String curso = cursoTextField.getText();

            cadastro.cadastrarAluno(nome, idade, curso);
            System.out.println("Aluno cadastrado com sucesso!");

            nomeTextField.setText("");
            idadeTextField.setText("");
            cursoTextField.setText("");
        });

        frame.add(cadastrarButton);

        frame.pack();
        frame.setVisible(true);

        // campo de listagem
        JTextArea listaAlunosTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(listaAlunosTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        JButton listarButton = new JButton("Listar alunos");
        listarButton.addActionListener(e -> {
            StringBuilder listaAlunos = new StringBuilder();
            for (Aluno aluno : cadastro.getListaAlunos()) {
                listaAlunos.append(aluno.getNome()).append(" - ")
                        .append(aluno.getIdade()).append(" anos - ")
                        .append(aluno.getCurso()).append("\n");
            }
            listaAlunosTextArea.setText(listaAlunos.toString());
        });
        frame.add(listarButton);

    }
}