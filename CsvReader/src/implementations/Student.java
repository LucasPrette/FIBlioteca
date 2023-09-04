package implementations;

public class Student {
    private String name;
    private int age;
    private int ra;

    public Student() {

    };

    public Student
            (
                    String name,
                    int age,
                    int ra
            )
    {
        this.name = name;
        this.age = age;
        this.ra = ra;

    };

    public String getName() {
        return this.name;

    }

    public int getAge() {
        return this.age;
    }

    public int getRa() {
        return this.ra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public void showStudent() {
        System.out.println("___Student___");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("RA: " + this.ra);
    }

}