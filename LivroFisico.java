public final class LivroFisico extends Livro{
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
    
    @Override // annotations
    public String toString() {
        String descricao = super.toString();
        return descricao + " - Dimensões: " + this.getDimensoes();
    }
    @Override
    public String getFormato() {
        return "LivroFisico";
    }
}