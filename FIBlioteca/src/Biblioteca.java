import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    //#########
    //ATRIBUTOS
    //#########

    private ArrayList<Livro> livros;
    private ArrayList<Aluno> alunos;
    private ArrayList<Emprestimo> emprestimos;

    //############
    //CONSTRUTORES
    //############

    public Biblioteca(){
        livros = new ArrayList<>();
        alunos = new ArrayList<>();
        emprestimos = new ArrayList<>();
        carregarAlunos();
        carregarLivros();
        carregarEmprestimos();
    }

    //################
    //MÉTODOS PÚBLICOS
    //################

    public void listarAlunos(){
        for(Aluno aluno : alunos){
            aluno.exibir();
        }
    }

    public void listarLivros(){
        for(Livro livro : livros){
            livro.exibir();
        }
    }

    public void listarEmprestimos() {
        for(Emprestimo emprestimo : emprestimos) {
            emprestimo.showLoan();
        }
    }

    public void listarEmprestimosNaoDevolvidos() {
        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getStatus() != Status.DEVOLVIDO) {
             emprestimo.showLoan();
            }
        }
    }

    public void emprestarLivro(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ISBN --> ");
        int isbn = sc.nextInt();
        if (!emprestado(isbn)){
            System.out.print("Digite o RA --> ");
            int ra = sc.nextInt();
            if(alunoEmDia(ra))
            {
                emprestar(ra, isbn);
            }
            else{
                System.err.println("Aluno não cadastrado ou em atraso!");
            }
        }
        else{
            System.err.println("Livro indisponível!");
            System.err.println("Devolução: " + buscarEmprestimoAtivo(isbn).getDevolucao());
        }
    }

    public void devolverLivro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type Isbn: ");
        int isbn = scanner.nextInt();

        if(emprestado(isbn))
        {
            Emprestimo emprestimo = buscarEmprestimoAtivo(isbn);
            if (emprestimo.getStatus() == Status.ATRASADO) {
                System.out.println("COBRAR MULTA");
            }
            emprestimo.setStatus(Status.DEVOLVIDO);
            atualizarArquivoEmprestimos();
        }

    }

    public void cadastrarAluno(){

    }

    public void removerAluno(){

    }

    public void adicionarLivro(){

    }

    public void removerLivro(){

    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    //################
    //MÉTODOS PRIVADOS
    //################

    private void atualizarAtrasados() {
        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getStatus() == Status.ATIVO) {

                if(LocalDate.now().isAfter(emprestimo.getDevolucao())) {
                    emprestimo.setStatus(Status.ATRASADO);
                    atualizarArquivoEmprestimos();
                }
            }
        }
    }

    private void emprestar(int ra, int isbn){
        Aluno aluno = buscarAluno(ra);
        Livro livro = buscarLivro(isbn);
        Emprestimo emprestimo = new Emprestimo(aluno, livro);
        emprestimos.add(emprestimo);
        atualizarArquivoEmprestimos();
        System.out.println("EMPRESTIMO REALIZADO COM SUCESSO!");
    }

    private void atualizarArquivoEmprestimos(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Win 10\\Downloads\\FIBlioteca\\FIBlioteca\\emprestimos.txt"))){
            for(Emprestimo emprestimo : emprestimos) {
                bw.write(String.valueOf(emprestimo.getAluno().getRa()));
                bw.newLine();
                bw.write(String.valueOf(emprestimo.getLivro().getIsbn()));
                bw.newLine();
                bw.write(emprestimo.getRetirada().toString());
                bw.newLine();
                bw.write(emprestimo.getDevolucao().toString());
                bw.newLine();
                bw.write(emprestimo.getStatus().toString());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.err.println("Erro ao gravar arquivo emprestimos.txt");
            e.printStackTrace();
        }
    }

    private Aluno buscarAluno(int ra){
        for(Aluno aluno : alunos){
            if (aluno.getRa() == ra){
                return aluno;
            }
        }
        return null;
    }

    private Livro buscarLivro(int isbn){
        for(Livro livro : livros){
            if (livro.getIsbn() == isbn){
                return livro;
            }
        }
        return null;
    }

    private boolean alunoEmDia(int ra){
        return alunoCadastrado(ra) && alunoSemAtraso(ra);
    }

    private boolean alunoCadastrado(int ra){
        for(Aluno aluno : alunos){
            if (aluno.getRa() == ra){
                return true;
            }
        }
        return false;
    }

    private boolean alunoSemAtraso(int ra){
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getAluno().getRa() == ra){
                if (emprestimo.getStatus() == Status.ATRASADO){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean emprestado(int isbn){
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getLivro().getIsbn() == isbn){
                if (emprestimo.getStatus() != Status.DEVOLVIDO){
                    return true;
                }
            }
        }
        return false;
    }

    private Emprestimo buscarEmprestimoAtivo(int isbn){
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getLivro().getIsbn() == isbn)
            {
                if (emprestimo.getStatus() == Status.ATIVO){
                    return emprestimo;
                }
            }
        }
        return null;
    }

    private Emprestimo buscarEmprestimoAtrasado(int isbn) {
        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getLivro().getIsbn() == isbn)
            {
                if(emprestimo.getStatus() == Status.ATRASADO) {
                    return emprestimo;
                }
            }
        }
        return null;
    }

    private void carregarAlunos(){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Win 10\\Downloads\\FIBlioteca\\FIBlioteca\\alunos.txt")))
        {
            String ra;
            while( (ra = br.readLine()) != null ){
                String nome = br.readLine();
                alunos.add(new Aluno(Integer.parseInt(ra), nome));
            }
        }
        catch (IOException e){
            System.err.println("Problema ao ler arquivo alunos.txt");
            e.printStackTrace();
        }
    }

    private void carregarLivros(){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Win 10\\Downloads\\FIBlioteca\\FIBlioteca\\livros.txt")))
        {
            String isbn;
            while( (isbn = br.readLine()) != null ){
                String titulo = br.readLine();
                String autor = br.readLine();
                livros.add(new Livro(Integer.parseInt(isbn), titulo, autor));
            }
        }
        catch (IOException e){
            System.err.println("Problema ao ler arquivo alunos.txt");
            e.printStackTrace();
        }
    }

    private void carregarEmprestimos() {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Win 10\\Downloads\\FIBlioteca\\FIBlioteca\\emprestimos.txt")))
        {
            String ra = br.readLine();
            System.out.println(ra);
            // while( (ra = br.readLine()) != null) {
            //     Aluno aluno = buscarAluno(Integer.parseInt(ra));

            //     Livro livro = buscarLivro(Integer.parseInt(br.readLine()));
            //     LocalDate retirada = dateFormatter(br.readLine());
            //     LocalDate devolucao = dateFormatter(br.readLine());
            //     Status status = Status.valueOf(br.readLine());

            //     emprestimos.add(new Emprestimo(
            //             aluno,
            //             livro,
            //             retirada,
            //             devolucao,
            //             status));
            // }

        } catch(IOException e) {
            System.err.println("Error reading the file 'emprestimos.txt' ");
            e.printStackTrace();
        }
    }

    private LocalDate dateFormatter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(date, formatter);
    }

}
