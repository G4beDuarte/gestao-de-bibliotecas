import java.time.LocalDate;


public abstract class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int nPaginas;

    public final int calcularTempoPublicacao(){
        int anoAtual = LocalDate.now().getYear();
        return anoAtual - this.anoPublicacao;
    }

    // Declaro o meodo mas não implemento
    public abstract String getFormato();

    public Livro(){

    }

    public Livro(String titulo){
        this.titulo = titulo;
    }

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
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
    public int getnPaginas() {
        return nPaginas;
    }
    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    @Override
    public String toString() {
        String descricao = "Titulo: " + this.getTitulo() + " - Autor: " + this.getAutor() + " - Ano: " + this.getAnoPublicacao();
        return descricao;
    }
    
    
}