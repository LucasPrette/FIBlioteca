import java.time.LocalDate;

public class Emprestimo {

    //#########
    //ATRIBUTOS
    //#########

    private Aluno aluno;
    private Livro livro;
    private LocalDate retirada;
    private LocalDate devolucao;
    private Status status;

    //############
    //CONSTRUTORES
    //############

    public Emprestimo(Aluno aluno,
                      Livro livro
    ){
        this.aluno = aluno;
        this.livro = livro;
        this.retirada = LocalDate.now();
        this.devolucao = LocalDate.now().plusWeeks(1);
        this.status = Status.ATIVO;
    }

    public Emprestimo(Aluno aluno,
                      Livro livro,
                      LocalDate retirada,
                      LocalDate devolucao,
                      Status status
    ){
        this.aluno = aluno;
        this.livro = livro;
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.status = status;
    }

    //################
    //MÉTODOS PÚBLICOS
    //################

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getRetirada() {
        return retirada;
    }

    public void setRetirada(LocalDate retirada) {
        this.retirada = retirada;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void showLoan() {
        System.out.println("Loans: ");
        System.out.println("RA: " + this.aluno.getRa());
        System.out.println("ISBN: " + this.livro.getIsbn());
        System.out.println("Data emprestimo: " + this.getRetirada());
        System.out.println("Data Devolucao: " + this.getDevolucao());
        System.out.println("Status: " + this.getStatus());
    };

    //################
    //MÉTODOS PRIVADOS
    //################


}
