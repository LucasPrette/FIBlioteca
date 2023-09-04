import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        int opcao;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("0 - SAIR");
            System.out.println("1 - LISTAR ALUNOS");
            System.out.println("2 - LISTAR LIVROS");
            System.out.println("3 - LISTAR EMPRESTIMOS");
            System.out.println("4 - LISTAR EMPRESTIMOS N/ DEVOLVIDOS");
            System.out.println("5 - EMPRESTAR LIVRO");
            System.out.println("6 - DEVOLVER LIVRO");
            System.out.print("--> ");
            opcao = sc.nextInt();
            switch (opcao){
                case 1 : biblioteca.listarAlunos(); break;
                case 2 : biblioteca.listarLivros(); break;
                case 3 : biblioteca.listarEmprestimos(); break;
                case 4 : biblioteca.listarEmprestimosNaoDevolvidos(); break;
                case 5 : biblioteca.emprestarLivro(); break;
                case 6 : biblioteca.devolverLivro(); break;
            }
        }while(opcao != 0);

    }
}