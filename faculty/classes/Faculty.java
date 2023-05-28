package faculty.classes;

public class Faculty extends FacultyBase {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double salary;

    public Faculty() {
    }

    public Faculty(String id, String name, int age, String gender, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
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
    void setDepartment(String department) {
        this.department = department;
    }

    @Override
    String getDepartment() {
        return department;
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
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    String facultyToStr() {
        return id + "\r\n" + name + "\r\n" + age + "\r\n" + gender + "\r\n" + department + "\r\n" + salary;
    }
}
