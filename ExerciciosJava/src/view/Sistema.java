package view;
import java.io.IOException;
import controller.GerenciadorLivros;
import model.Livro;

public class Sistema {

    private static void exibirMenu() {

        System.out.println("\nGERENCIADOR DE LIVROS");
        System.out.println("1) Cadastrar livro");
        System.out.println("2) Buscar livro");
        System.out.println("3) Excluir livro");
        System.out.println("4) Listar todos os livros");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");

    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                salvarLivro();
                break;
            case 2:
                buscarLivro(); 
                break;
            case 3:
                apagarLivro();
                break;
            case 4:
                listarTodos();
                break;
            case 0:
                System.out.println("\nO sistema foi finalizado...");
                break;
            default:
                System.out.println("\nOpção inválida. Digite novamente");
                break;
        }
    }

     private static void salvarLivro() {

        System.out.println("\nNovo Livro:");
        
        System.out.print("Informe o código: ");
        int codigo = Console.lerInt();

        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o autor: ");
        String autor = Console.lerString();

        System.out.print("Informe o ano de publicação: ");
        int anoPublicacao = Console.lerInt();

        System.out.print("Informe o gênero: ");
        String genero = Console.lerString();

        Livro livro = new Livro(codigo, titulo, autor, anoPublicacao, genero);

        try {

            GerenciadorLivros.salvarLivro(livro);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }

    private static void buscarLivro() {

        System.out.println("\nBuscar Livro");
        System.out.print("Informe o código: ");
        int codigo = Console.lerInt();

        try {

            Livro livro = GerenciadorLivros.buscarLivro(codigo);
            System.out.println("\nLivro encontrado: " + livro);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void apagarLivro() {

        System.out.println("\nApagar Livro");
        System.out.print("Informe o código do livro que deseja apagar: ");
        int codigo = Console.lerInt();

        try {

            GerenciadorLivros.apagarLivro(codigo);
            System.out.println("\nLivro excluído com sucesso!");
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    private static void listarTodos() {

        System.out.println("\nLivros Cadastrados:");

        try {

            for (Livro tempLivro : GerenciadorLivros.listarLivros())
            {
                System.out.println(tempLivro);
            }
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public static void executar() {

        int op;

        do {

            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while (op != 0);

    }

}
