import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Não é permido cadastrar livro sem título");
        } else if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new Exception("Não é permitido cadastrar livro sem autor");
        } else if (livro.getAnoPublicacao() < 1400 || livro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new Exception(
                    "Não é permitido cadastrar livro com uma data antes de 1400 e maior que a data do ano atual");
        } else if (livro.getnPaginas() <= 0) {
            throw new Exception("Para cadastrar um livro o número de paginas deve ser maior que 0");
        }
        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                throw new Exception("Já existe cadastrado com esse título: ");
            }
        }
        acervo.add(livro);
    }

    public List<Livro> pesquisar(String titulo){
        return pesquisar(titulo,null);
    }

    public List<Livro> pesquisar(String titulo, String autor) {
        List<Livro> livroEncontrados = new ArrayList<>();

        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                if (autor == null || livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                    livroEncontrados.add(livro);
                }
            }
        }
        return livroEncontrados;
    }

    public void removerPorTitulo(String titulo) throws Exception {
        boolean removeLivro = false;
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo))
                ;
            {
                acervo.remove(livro);
                removeLivro = true;
                break;
            }
        }
        if (!removeLivro) {
            throw new Exception("Este livro não foi encontrado");
        }
    }

    public List<Livro> pesquisarTodos() {
        return this.acervo;
    }
}
