import Atualizacoes.AtualizarDados;
import Atualizacoes.BuscaAlunoPorNome;
import Atualizacoes.CadastroAlunos;
import Atualizacoes.ExcluirAluno;
import Bases.Aluno;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();
        Scanner scanner = new Scanner(System.in);
        AtualizarDados atualizar = new AtualizarDados();

        System.out.println("=== CADASTRO DE ALUNOS ===");
        while(true){
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar um novo aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar Bases.Aluno por Nome");
            System.out.println("4 - Excluir Bases.Aluno");
            System.out.println("5 - Atualizar dados do aluno");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            if(opcao == 1){
                System.out.println("=== CADASTRO DO ALUNO ===");

                System.out.println("Nome: ");
                String nome = scanner.next();

                System.out.println("Idade: ");
                int idade = scanner.nextInt();

                System.out.println("Curso: ");
                String curso = scanner.next();

                cadastro.cadastrarAluno(nome, idade, curso);
                System.out.println("Bases.Aluno cadastrado com sucesso!\n");
            } else if (opcao == 2) {
                System.out.println("=== LISTA DE ALUNOS ===");
                cadastro.listarAlunos();
                System.out.println();
            } else if (opcao == 3) {
                System.out.println("=== BUSCAR ALUNOS POR NOME ===");
                System.out.println("Digite o nome do aluno:");
                String nomeBusca = scanner.next();
                BuscaAlunoPorNome busca = new BuscaAlunoPorNome();
                busca.buscaAlunoPorNome(nomeBusca, cadastro.getListaAlunos());
                System.out.println();
            } else if (opcao == 4) {
                System.out.println("=== EXCLUIR ALUNO ===");
                System.out.println("Digite o nome do aluno a ser excluido:");
                String nomeExclusao = scanner.next();

                ExcluirAluno excluir = new ExcluirAluno();
                excluir.excluirAluno(nomeExclusao, cadastro.getListaAlunos());
            } else if (opcao == 5) {
                System.out.println("=== ATUALIZAR DADOS DO ALUNO");
                System.out.println("Digite o nome do aluno:");
                String nomeAtualiza = scanner.next();

                Aluno aluno = BuscaAlunoPorNome.buscaAlunoPorNome(nomeAtualiza, cadastro.getListaAlunos()) ;
                System.out.println("O que gostaria de fazer?");
                System.out.println("1 - Alterar o nome do aluno");
                System.out.println("2 - Alterar a idade do aluno");
                System.out.println("3 - Alterar o curso do aluno");
                int digito = scanner.nextInt();
                atualizar.atualizar(aluno, digito);


            } else if (opcao == 0) {
                System.out.println("Saindo do programa...");
                break;
            }else{
                System.out.println("Opção invalida!\n");
            }
        }
        scanner.close();
    }
}
