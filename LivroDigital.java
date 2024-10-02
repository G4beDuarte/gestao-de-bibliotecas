public final class LivroDigital extends Livro {
    private double tamanhoArquivo;
    private String formatoArquivo;
    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public String getFormatoArquivo() {
        return formatoArquivo;
    }
    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }
    
    @Override
    public String toString() {
        String descricao = super.toString();
        return descricao + " - Formato do arquivo: " + this.getFormatoArquivo();
    }
    @Override
    public String getFormato() {
        return "Livro Digital";
    }
}
