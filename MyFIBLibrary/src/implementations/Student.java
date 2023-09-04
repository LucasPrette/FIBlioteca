package implementations;

public class Student {
    private String name;
    private int ra;

    public Student () {};

    public Student
            (
            int ra,
            String name
            )
            {
                this.ra = ra;
                this.name = name;
            };

    public Student
            (
                    String name,
                    int ra
            )
            {
                this.name = name;
                this.ra = ra;
            };


    public String getName() {
        return this.name;
    };

    public int getRa() {
        return this.ra;
    };

    public void setName(String name) {
        this.name = name;
    };

    public void setRa(int ra) {
        this.ra = ra;
    };

    public void showStudent() {
        System.out.println("____Student____ ");
        System.out.println("RA: " + this.ra);
        System.out.println("Name: " + this.name);

    };

};