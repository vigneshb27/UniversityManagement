package stuff.classes;

public class Stuff extends StuffBase {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double salary;

    public Stuff() {
    }

    public Stuff(String id, String name, int age, String gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    void setId(String id) {
        this.id = id;
    }

    @Override
    String getId() {
        return id;
    }

    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void setAge(int age) {
        this.age = age;
    }

    @Override
    int getAge() {
        return age;
    }

    @Override
    void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    String getGender() {
        return gender;
    }

    @Override
    void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    double getSalary() {
        return salary;
    }

    @Override
    void showDetails() {
        System.out.println("\n-----//-----//-----");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + salary);
    }

    String stuffToStr() {
        return id + "\r\n" + name + "\r\n" + age + "\r\n" + gender + "\r\n" + salary;
    }
}
