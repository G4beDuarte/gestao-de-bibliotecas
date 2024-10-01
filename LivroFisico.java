public class LivroFisico extends Livro{
    private int nExemplares;
    private String dimensoes;
    public int getnExemplares() {
        return nExemplares;
    }
    public void setnExemplares(int nExemplares) {
        this.nExemplares = nExemplares;
    }
    public String getDimensoes() {
        return dimensoes;
    }
    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
    
    @Override
    public String toString() {
        String descricao = "Titulo: " + this.getTitulo() + " - Autor: " + this.getAutor() + " - Ano: " + this.getAnoPublicacao();
        return "Livro Físico: " + descricao + " - Dimensões: " + this.getDimensoes();
    }
}