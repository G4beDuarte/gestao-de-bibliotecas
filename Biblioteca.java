import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception{
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("Não é permido cadastrar livro sem título");
        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo()));
                throw new Exception("Já existe cadastrado com esse título: ");
                
        }
        acervo.add(livro);
    }
    
    public List<Livro> pesquisarPorTitulo(String titulo){
        List<Livro> livroEncontrados = new ArrayList<>();

        for (Livro livro : acervo) {
            if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                livroEncontrados.add (livro);
            }
        }
        return livroEncontrados;
    }

    public void removerPorTitulo(String titulo){
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo));
                acervo.remove(livro);
                break;
        }
    }
    

    public List<Livro> pesquisarTodos(){
        return this.acervo;
    }
}
