import javax.swing.*;
import java.awt.*;
import java.util.List;

import Atualizacoes.AtualizarDados;
import Atualizacoes.BuscaAlunoPorNome;
import Atualizacoes.CadastroAlunos;
import Atualizacoes.ExcluirAluno;
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

        // Campo de busca

        JLabel buscaLabel = new JLabel("Buscar por nome: ");
        frame.add(buscaLabel);
        JTextField buscaTextField = new JTextField();
        frame.add(buscaTextField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> {
            String nomeBusca = buscaTextField.getText();
            List<Aluno> alunosEncontrados = busca.buscaAlunoPorNome(nomeBusca, cadastro.getListaAlunos());

            StringBuilder resultado = new StringBuilder();
            for (Aluno aluno : alunosEncontrados) {
                resultado.append("Nome: ").append(aluno.getNome())
                        .append("\nIdade: ").append(aluno.getIdade())
                        .append("\nCurso: ").append(aluno.getCurso())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(frame, resultado.toString(), "Resultados da busca", JOptionPane.INFORMATION_MESSAGE);
        });
        frame.add(buscarButton);

        // campo para Excluir alunos

        JButton excluirButton = new JButton("Excluir aluno");
        frame.add(excluirButton);
        excluirButton.addActionListener(e -> {
            String nomeExclusao = JOptionPane.showInputDialog(
                    frame,
                    "Digite o nome do aluno a ser excluído:",
                    "Excluir aluno",
                    JOptionPane.PLAIN_MESSAGE
                    );
            if(nomeExclusao != null){
                ExcluirAluno excluir = new ExcluirAluno();
                excluir.excluirAluno(nomeExclusao, cadastro.getListaAlunos());
                JOptionPane.showMessageDialog(
                        frame,
                        "Aluno excluido com sucesso",
                        "Exclusão do aluno",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                atualizarExibiçãoDosAlunos(listaAlunosTextArea, cadastro);
            }
        });

        // campo para atualizar alunos

        JButton atualizarButton = new JButton("Atualizar aluno");
        frame.add(atualizarButton);
        atualizarButton.addActionListener(e -> {
            String nomeAtualiza = JOptionPane.showInputDialog(frame, "Digite o nome do aluno que deverá ser atualizado:");
            List<Aluno> alunosEncontrados = busca.buscaAlunoPorNome(nomeAtualiza, cadastro.getListaAlunos());

            if(!alunosEncontrados.isEmpty()){
                String[] opcoes = {"Alterar nome do aluno", "Alterar idade do aluno", "Alterar curso do aluno"};
                int opcaoEscolhida = JOptionPane.showOptionDialog(
                        frame, "Selecione o dado a ser atualizado:",
                        "Atualizar dados do aluno", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]
                );
                if(opcaoEscolhida >= 0){
                    for(Aluno aluno : alunosEncontrados){
                        atualizarDados.atualizar(aluno, opcaoEscolhida +1);
                    }
                    JOptionPane.showMessageDialog(frame, "Dados Atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(frame, "Nenhum aluno encontrado com esse nome!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private static void atualizarExibiçãoDosAlunos(JTextArea listaAlunosTextArea, CadastroAlunos cadastro) {
        StringBuilder listaAlunos = new StringBuilder();
        for (Aluno aluno : cadastro.getListaAlunos()) {
            listaAlunos.append(aluno.getNome()).append(" - ")
                    .append(aluno.getIdade()).append(" anos - ")
                    .append(aluno.getCurso()).append("\n");
        }
        listaAlunosTextArea.setText(listaAlunos.toString());
    }
}