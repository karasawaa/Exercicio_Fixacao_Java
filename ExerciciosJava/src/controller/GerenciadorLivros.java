package controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Livro;

public abstract class GerenciadorLivros {

    private static final String ARQUIVO = "livros.txt";
    


    public static void salvarLivro(Livro livro) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(livro + "\n");

        }

    }

    public static ArrayList<Livro> listarLivros() throws IOException, Exception {

        ArrayList<Livro> listaLivros = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    Livro livro = Livro.fromString(linha);
                    listaLivros.add(livro);
                }
        } 

        if (listaLivros.isEmpty()) {
            throw new Exception("\nNão há livros cadastrados");
        }

        return listaLivros;

    }

    public static Livro buscarLivro(int codigo) throws Exception {

        ArrayList<Livro> listaLivros = listarLivros();

        for (Livro tempLivro : listaLivros) {

            if(tempLivro.getCodigo() == codigo) {

                return tempLivro;
            }
        }

        throw new Exception("\nLivro com o código " + codigo + " não localizado!");

    }

    public static void apagarLivro(int codigo) throws Exception{

        ArrayList<Livro> listaLivros = listarLivros();       
    
        boolean encontrou = false;
        for (Livro temp : listaLivros) {

            if(temp.getCodigo() == codigo) {
                listaLivros.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nLivro com o código " + codigo + " não localizado!");
        }

        // sobrescrever arquivo com array list atualizado:
        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (Livro l : listaLivros) {

                bw.write(l + "\n");
            }
        }
    }

}