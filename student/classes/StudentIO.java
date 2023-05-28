package student.classes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.FileReadWriteException;

import java.io.BufferedReader;

public class StudentIO {
    private String fileName = "Database/StudentData.txt";
    private File file;
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader bfr;

    public void writeIntoFile(Student student) throws Exception {

        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file, true);
            writer.write(student.getId() + "\r\n");
            writer.write(student.getName() + "\r\n");
            writer.write(student.getAge() + "\r\n");
            writer.write(student.getGender() + "\r\n");
            writer.write(student.getCGPA() + "\r\n");
            writer.write(student.getCreditPassed() + "\r\n");
            writer.write("\r\n");
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Student searchFromFile(String studentId) throws Exception {
        Student student = new Student();

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int counter = 0;

            while ((temp = bfr.readLine()) != null) {

                if (temp.contains(studentId) && temp.length() == studentId.length()) {
                    student.setId(temp);
                    counter++;
                } else {
                    switch (counter) {
                        case 1: {
                            student.setName(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 2: {
                            student.setAge(Integer.parseInt(temp));
                            counter++;
                        }
                            ;
                            break;
                        case 3: {
                            student.setGender(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 4: {
                            student.setCGPA(Double.parseDouble(temp));
                            counter++;
                        }
                            ;
                            break;
                        case 5: {
                            student.setCreditPassed(Integer.parseInt(temp));
                            counter++;
                        }
                    }
                }
            }

            bfr.close();
            reader.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }

        return student;
    }

    public void updateData(String oldData, String newData) throws Exception {

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            String oldStudentData = "";
            String temp;

            while ((temp = bfr.readLine()) != null) {
                oldStudentData += temp + "\r\n";
            }

            String newStudentData = oldStudentData.replace(oldData, newData);

            bfr.close();
            reader.close();

            writer = new FileWriter(file);
            writer.write(newStudentData);
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File update error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Student[] getAllStudent() throws Exception {
        Student[] students = new Student[] {};

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int wordCount = 0;
            int studentCount = 0;

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0)
                    wordCount++;
            }

            students = new Student[wordCount / 6];
            wordCount = 0;

            bfr.close();
            reader.close();

            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0) {
                    if (students[studentCount] == null) {
                        students[studentCount] = new Student();
                    }
                    switch (wordCount) {
                        case 0:
                            students[studentCount].setId(temp);
                            break;
                        case 1:
                            students[studentCount].setName(temp);
                            break;
                        case 2:
                            students[studentCount].setAge(Integer.parseInt(temp));
                            break;
                        case 3:
                            students[studentCount].setGender(temp);
                            break;
                        case 4:
                            students[studentCount].setCGPA(Double.parseDouble(temp));
                            break;
                        case 5:
                            students[studentCount].setCreditPassed(Integer.parseInt(temp));
                            break;
                    }

                    wordCount++;

                } else {
                    studentCount++;
                    wordCount = 0;
                }
            }

            bfr.close();
            reader.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }

        return students;

    }
}
