public class TestePolimorfismo {
    public static void main(String[] args) {
        Livro livro1 = new LivroFisico();
        Livro livro2 = new LivroDigital();
        Livro livro3 = new Livro();

        System.out.println(livro1.toString());
        System.out.println(livro2.toString());
        System.out.println(livro3.toString());
    }
}