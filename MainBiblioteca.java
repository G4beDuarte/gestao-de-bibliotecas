import java.util.Comparator;
import java.util.Scanner;

public class MainBiblioteca {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        do {
            System.out.println(mensagem);
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor informe um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void listar() {
        // List<Livro> livros = biblio.pesquisarTodos();
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));

        System.out.println("========== LISTA DE LIVROS ==========");
        for (Livro livro : livros) {
            System.out.println(livro.getFormato());
            System.out.println(livro.toString());
            System.out.println("--------------------------------------");
        }

    }

    private static void pesquisarPorTitulo() {
        System.out.println("========== LISTA DE LIVROS ==========");
        System.out.println("Digite o titulo do livro que está procurando: ");
        String titulo = input.nextLine();
        var livros = biblio.pesquisar(titulo);
        if (livros.isEmpty())
            System.out.println("Não foram encontrados livros com esta pesquisa.");
        else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoPublicacao());
                System.out.println("N. Paginas: " + livro.getnPaginas());
            }
        }
    }

    private static void adicionar() throws Exception {
        Livro novoLivro = null;
        System.out.println("========== ADICIONANDO NOVO LIVRO ==========");
        int tipoLivro;
        do {
            tipoLivro = inputNumerico("Qual o tipo de livro: (1) Físico - (2) Digital");
            if (tipoLivro == 1) {
                novoLivro = new LivroFisico();
            } else if (tipoLivro == 2) {
                novoLivro = new LivroDigital();
            } else {
                System.out.println("Opção inválida!");
            }
        } while (novoLivro == null);

        System.out.print("Informe o título do Livro: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de lançamento: ");
        novoLivro.setAnoPublicacao(input.nextInt());
        input.nextLine(); // buffer

        System.out.print("Informe o número de paginas: ");
        novoLivro.setnPaginas(input.nextInt());
        input.nextLine(); // buffer

        if (tipoLivro == 1) {
            int nExemplares = inputNumerico("Informe o nº de exemplares: ");
            ((LivroFisico) novoLivro).setnExemplares(nExemplares);
            System.out.print("Digite as dimensões: ");
            String dimensoes = input.nextLine();
            ((LivroFisico) novoLivro).setDimensoes(dimensoes);
        } else if (tipoLivro == 2) {
            System.out.print("Digite o formato do arquivo: ");
            String formatoArquivo = input.nextLine();
            ((LivroDigital) novoLivro).setFormatoArquivo(formatoArquivo);
        }

        try {
            biblio.adicionar(novoLivro);
            System.out.println("LIVRO ADICIONADO COM SUCESSO!!!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        input.nextLine();
    }

    public static void removerPorTitulo() {
        System.out.println("========== REMOVENDO LIVRO ==========");
        System.out.print("Digite o título do livro que deseja remover: ");
        String titulo = input.nextLine();
        try {
            biblio.removerPorTitulo(titulo);
            System.out.println("Livro removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        String menu = """
                SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
                Ecolha uma das opções:
                1- Adicionar novo livro;
                2- Listar todos os livros;
                3- Pesquisar livro;
                4- Remover livro;
                0- Sair;
                """;
        int opcao;
        do {
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    limparTela();
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    limparTela();
                    adicionar();
                    break;
                case 2:
                    limparTela();
                    listar();
                    input.nextLine();
                    limparTela();
                    break;
                case 3:
                    limparTela();
                    pesquisarPorTitulo();
                    input.nextLine();
                    limparTela();
                    break;
                case 4:
                    limparTela();
                    removerPorTitulo();
                    input.nextLine();
                    limparTela();
                    break;
                default:
                    limparTela();
                    System.out.println("Opção Inválida!!!");
                    input.nextLine();
                    break;
            }

        } while (opcao != 0);
    }
}
