package faculty.classes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.FileReadWriteException;

import java.io.BufferedReader;

public class FacultyIO {
    private String fileName = "Database/FacultyData.txt";
    private File file;
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader bfr;

    public void writeIntoFile(Faculty faculty) throws Exception {

        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file, true);
            writer.write(faculty.getId() + "\r\n");
            writer.write(faculty.getName() + "\r\n");
            writer.write(faculty.getAge() + "\r\n");
            writer.write(faculty.getGender() + "\r\n");
            writer.write(faculty.getDepartment() + "\r\n");
            writer.write(faculty.getSalary() + "\r\n");
            writer.write("\r\n");
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Faculty searchFromFile(String facultyId) throws Exception {
        Faculty faculty = new Faculty();

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int counter = 0;

            while ((temp = bfr.readLine()) != null) {

                if (temp.contains(facultyId) && temp.length() == facultyId.length()) {
                    faculty.setId(temp);
                    counter++;
                } else {
                    switch (counter) {
                        case 1: {
                            faculty.setName(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 2: {
                            faculty.setAge(Integer.parseInt(temp));
                            counter++;
                        }
                            ;
                            break;
                        case 3: {
                            faculty.setGender(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 4: {
                            faculty.setDepartment(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 5: {
                            faculty.setSalary(Double.parseDouble(temp));
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

        return faculty;
    }

    public void updateData(String oldData, String newData) throws Exception {

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            String oldFacultyData = "";
            String temp;

            while ((temp = bfr.readLine()) != null) {
                oldFacultyData += temp + "\r\n";
            }

            String newFacultyData = oldFacultyData.replace(oldData, newData);

            bfr.close();
            reader.close();

            writer = new FileWriter(file);
            writer.write(newFacultyData);
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File update error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Faculty[] getAllFaculty() throws Exception {
        Faculty[] faculty = new Faculty[] {};

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int wordCount = 0;
            int facultyCount = 0;

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0)
                    wordCount++;
            }

            faculty = new Faculty[wordCount / 6];
            wordCount = 0;

            bfr.close();
            reader.close();

            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0) {
                    if (faculty[facultyCount] == null) {
                        faculty[facultyCount] = new Faculty();
                    }
                    switch (wordCount) {
                        case 0:
                            faculty[facultyCount].setId(temp);
                            break;
                        case 1:
                            faculty[facultyCount].setName(temp);
                            break;
                        case 2:
                            faculty[facultyCount].setAge(Integer.parseInt(temp));
                            break;
                        case 3:
                            faculty[facultyCount].setGender(temp);
                            break;
                        case 4:
                            faculty[facultyCount].setDepartment(temp);
                            break;
                        case 5:
                            faculty[facultyCount].setSalary(Double.parseDouble(temp));
                            break;
                    }

                    wordCount++;

                } else {
                    facultyCount++;
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

        return faculty;
    }
}
