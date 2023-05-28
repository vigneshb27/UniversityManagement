package stuff.classes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.FileReadWriteException;

import java.io.BufferedReader;

public class StuffIO {
    private String fileName = "Database/StuffData.txt";
    private File file;
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader bfr;

    public void writeIntoFile(Stuff stuff) throws Exception {

        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file, true);
            writer.write(stuff.getId() + "\r\n");
            writer.write(stuff.getName() + "\r\n");
            writer.write(stuff.getAge() + "\r\n");
            writer.write(stuff.getGender() + "\r\n");
            writer.write(stuff.getSalary() + "\r\n");
            writer.write("\r\n");
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File read error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Stuff searchFromFile(String stuffId) throws Exception {
        Stuff stuff = new Stuff();

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int counter = 0;

            while ((temp = bfr.readLine()) != null) {

                if (temp.contains(stuffId) && temp.length() == stuffId.length()) {
                    stuff.setId(temp);
                    counter++;
                } else {
                    switch (counter) {
                        case 1: {
                            stuff.setName(temp);
                            counter++;
                        }
                            ;
                            break;
                        case 2: {
                            stuff.setAge(Integer.parseInt(temp));
                            counter++;
                        }
                            ;
                            break;
                        case 3: {
                            stuff.setGender(temp);
                            counter++;
                        }
                            ;
                            break;

                        case 4: {
                            stuff.setSalary(Double.parseDouble(temp));
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

        return stuff;
    }

    public void updateData(String oldData, String newData) throws Exception {

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            String oldstuffData = "";
            String temp;

            while ((temp = bfr.readLine()) != null) {
                oldstuffData += temp + "\r\n";
            }

            String newstuffData = oldstuffData.replace(oldData, newData);

            bfr.close();
            reader.close();

            writer = new FileWriter(file);
            writer.write(newstuffData);
            writer.flush();
            writer.close();

        } catch (IOException error) {
            throw new FileReadWriteException("File update error");
        } catch (Exception error) {
            throw new Exception("Some error occurred");
        }
    }

    public Stuff[] getAllStuff() throws Exception {
        Stuff[] stuff = new Stuff[] {};

        try {
            file = new File(fileName);
            reader = new FileReader(file);
            bfr = new BufferedReader(reader);
            String temp;
            int wordCount = 0;
            int stuffCount = 0;

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0)
                    wordCount++;
            }

            stuff = new Stuff[wordCount / 5];
            wordCount = 0;

            bfr.close();
            reader.close();

            reader = new FileReader(file);
            bfr = new BufferedReader(reader);

            while ((temp = bfr.readLine()) != null) {
                if (temp.length() > 0) {
                    if (stuff[stuffCount] == null) {
                        stuff[stuffCount] = new Stuff();
                    }
                    switch (wordCount) {
                        case 0:
                            stuff[stuffCount].setId(temp);
                            break;
                        case 1:
                            stuff[stuffCount].setName(temp);
                            break;
                        case 2:
                            stuff[stuffCount].setAge(Integer.parseInt(temp));
                            break;
                        case 3:
                            stuff[stuffCount].setGender(temp);
                            break;
                        case 4:
                            stuff[stuffCount].setSalary(Double.parseDouble(temp));
                            break;
                    }

                    wordCount++;

                } else {
                    stuffCount++;
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

        return stuff;
    }
}
