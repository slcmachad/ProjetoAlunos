package Atualizacoes;
import Bases.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Interfaces.PersistenciaAluno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CadastroAlunos {
    private PersistenciaAluno persistencia;

    private final String bancoDeDados = "dbAluno.json";

    private List<Aluno> listaAlunos;

    public CadastroAlunos(PersistenciaAluno persistencia) {
        this.persistencia = persistencia;
        listaAlunos = persistencia.carregarAlunos();
//        carregarDoArquivo();
    }

    public void cadastrarAluno(String nome, int idade, String curso) {
        Aluno aluno = new Aluno(nome, idade, curso);
        listaAlunos.add(aluno);
        persistencia.carregarAlunos();
    }

    public void listarAlunos() {
//        if(listaAlunos.isEmpty()){
//            System.out.println("Não há alunos cadastrados no momento");
//        }else{
//            System.out.println("Lista de alunos");
//            for(Aluno aluno: listaAlunos){
//                System.out.println("Nome: " + aluno.getNome());
//                System.out.println("Idade: " + aluno.getIdade());
//                System.out.println("Curso: " + aluno.getCurso());
//                System.out.println("--------------------------");
//            }
//        }
    }

//    public void salvarNoBD(){
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        try(FileWriter writer = new FileWriter(bancoDeDados)){
//            gson.toJson(listaAlunos, writer);
//            System.out.println("Aluno cadastrado no banco de dados");
//        } catch (IOException e) {
//            System.out.println("Erro ao salvar os alunos no arquivo: " + e.getMessage());
//        }
//    }
//
//    public void carregarDoArquivo(){
//        Gson gson = new Gson();
//        try{
//            File file = new File(bancoDeDados);
//            if(file.exists()) {
//                FileReader reader = new FileReader(bancoDeDados);
//                Aluno[] alunosArray = gson.fromJson(reader, Aluno[].class);
//                listaAlunos.addAll(Arrays.asList(alunosArray));
//                reader.close();
//                System.out.println("Dados dos alunos carregados do arquivo.");
//            }
//        } catch (IOException e) {
//            System.out.println("Erro ao carregar os dados dos alunos do arquivo: " + e.getMessage());
//        }
//    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
