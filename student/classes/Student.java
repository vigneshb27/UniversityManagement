package student.classes;

public class Student extends StudentBase {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double cgpa;
    private int creditPassed;

    public Student() {
    }

    public Student(String id, String name, int age, String gender, double cgpa, int creditPassed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cgpa = cgpa;
        this.creditPassed = creditPassed;
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
    void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    double getCGPA() {
        return cgpa;
    }

    @Override
    void setCreditPassed(int creditPassed) {
        this.creditPassed = creditPassed;
    }

    @Override
    int getCreditPassed() {
        return creditPassed;
    }

    @Override
    void showDetails() {
        System.out.println("\n-----//-----//-----");
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Credit Passed: " + creditPassed);
    }

    String studentToStr() {
        return id + "\r\n" + name + "\r\n" + age + "\r\n" + gender + "\r\n" + cgpa + "\r\n" + creditPassed;
    }
}
