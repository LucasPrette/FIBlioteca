public class Livro {

    //#########
    //ATRIBUTOS
    //#########

    private int isbn;
    private String titulo;
    private String autor;

    //############
    //CONSTRUTORES
    //############

    public Livro(int isbn,
                 String titulo,
                 String autor){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    //################
    //MÉTODOS PÚBLICOS
    //################

    public void exibir(){
        System.out.println("###");
        System.out.println("ISBN:   " + this.isbn);
        System.out.println("TITULO: " + this.titulo);
        System.out.println("AUTOR:  " + this.autor);
        System.out.println("###\n");
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    //################
    //MÉTODOS PRIVADOS
    //################

}
