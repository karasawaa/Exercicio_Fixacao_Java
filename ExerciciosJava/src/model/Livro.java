package model;

public class Livro {

    private int codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    
    public Livro(int codigo, String titulo, String autor, int anoPublicacao, String genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /* @Override
    public String toString() {
        return "Codigo: " + codigo +
               "\nTitulo: " + titulo +
               "\nAutor: " + autor +
               "\nAno de Publicacao: " + anoPublicacao +
               "\nGnero: " + genero;
    } */

    @Override
    public String toString() {
        return codigo + ", " + titulo + ", " + autor + ", " + anoPublicacao + ", " + genero;
    }

    public static Livro fromString(String linha) {

        String[] dadosLivro = linha.split(", ");

        return new Livro(Integer.parseInt(dadosLivro[0]), 
                        dadosLivro[1], 
                        dadosLivro[2],
                        Integer.parseInt(dadosLivro[3]),
                        dadosLivro[4]);

    }
}
