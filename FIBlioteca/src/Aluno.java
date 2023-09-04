public class Aluno {

    //#########
    //ATRIBUTOS
    //#########

    private int ra;
    private String nome;

    //############
    //CONSTRUTORES
    //############

    public Aluno(int ra, String nome){
        this.ra = ra;
        this.nome = nome;
    }

    //################
    //MÉTODOS PÚBLICOS
    //################

    public void exibir(){
        System.out.println("###");
        System.out.println("RA:   " + this.ra);
        System.out.println("NOME: " + this.nome);
        System.out.println("###\n");
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //################
    //MÉTODOS PRIVADOS
    //################
}
