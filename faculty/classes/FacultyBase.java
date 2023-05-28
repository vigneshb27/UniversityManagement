package faculty.classes;

public abstract class FacultyBase {
    abstract void setId(String id);

    abstract String getId();

    abstract void setName(String name);

    abstract String getName();

    abstract void setAge(int age);

    abstract int getAge();

    abstract void setGender(String gender);

    abstract String getGender();

    abstract void setDepartment(String department);

    abstract String getDepartment();

    abstract void setSalary(double salary);

    abstract double getSalary();

    abstract void showDetails();
}
