package BancoDeDados;

import Bases.Aluno;
import Interfaces.PersistenciaAluno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersistenciaBancoDados implements PersistenciaAluno {
    private final String bancoDeDados = "dbAluno.json";

    @Override
    public void salvarAlunos(List<Aluno> listaAlunos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter(bancoDeDados)){
            gson.toJson(listaAlunos, writer);
            System.out.println("Aluno cadastrado no banco de dados");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os alunos no arquivo: " + e.getMessage());
        }
    }

    @Override
    public List<Aluno> carregarAlunos() {
        List<Aluno> listaAlunos = new ArrayList<>();
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(bancoDeDados)){
            File file = new File(bancoDeDados);
            if(file.exists()) {
                Aluno[] alunosArray = gson.fromJson(reader, Aluno[].class);
                listaAlunos.addAll(Arrays.asList(alunosArray));
                reader.close();
                System.out.println("Dados dos alunos carregados do arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados dos alunos do arquivo: " + e.getMessage());
        }
        return listaAlunos;
    }
}
