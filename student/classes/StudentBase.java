package student.classes;

public abstract class StudentBase {
    abstract String getId();

    abstract void setId(String id);

    abstract String getName();

    abstract void setName(String name);

    abstract int getAge();

    abstract void setAge(int age);

    abstract String getGender();

    abstract void setGender(String gender);

    abstract double getCGPA();

    abstract void setCGPA(double cgpa);

    abstract int getCreditPassed();

    abstract void setCreditPassed(int creditPassed);

    abstract void showDetails();
}
