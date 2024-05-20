# Exercício: Cadastro de Livros

Tema: **Cadastro de Livros**

Objetivo: Desenvolver um sistema para gerenciar um cadastro de livros, que permita adicionar, buscar, listar e excluir livros de um arquivo de texto.

Requisitos:

### Classe Console

 - Esta classe será responsável pela entrada de dados e deve conter métodos estáticos para ler valores inteiros (lerInt), strings (lerString), e floats (lerFloat). Tratar exceções para evitar que valroes lidos sejam diferentes do tipo permitido.

### Classe Livro

- **Atributos:**
   - codigo (int)
   - titulo (String)
   - autor (String)
   - anoPublicacao (int)
   - genero (String)
- **Métodos:**
   - Construtor parametrizado.
   - Getters e setters.
   - Método toString que retorna uma representação textual dos dados do livro.
   - Método estático fromString que cria um objeto Livro a partir de uma string.

### Classe GerenciadorLivros

- **Métodos estáticos:**
   - salvarLivro(Livro livro): salva os dados de um livro em um arquivo de texto.
   - buscarLivro(int codigo): busca um livro pelo código no arquivo e retorna um objeto Livro com esses dados. Lança uma exceção se o livro não for encontrado ou o arquivo estiver vazio.
   - listarLivros(): lê o arquivo e retorna todos os livros em uma lista de Livro. Lança uma exceção se o arquivo estiver vazio.
   - apagarLivro(int codigo): recebe um código, procura um livro no arquivo com esse código e, se encontrar, apaga-o do arquivo. Lança uma exceção se o livro não for encontrado.

### Classe Sistema

- **Métodos estáticos:**
   - exibirMenu(): exibe um menu de opções:

            1. Cadastrar livro
            2. Buscar livro
            3. Excluir livro
            4. Listar todos os livros
            0. Sair

   - verificarOpcao(int opcao): recebe o valor digitado e executa a ação de acordo com o valor.
   - executar(): concentra as chamadas dos métodos exibirMenu e verificarOpcao.

### Classe Principal

- Contém apenas o método main, que chama o método executar da classe Sistema.
