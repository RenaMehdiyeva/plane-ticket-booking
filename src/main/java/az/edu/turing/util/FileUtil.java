package az.edu.turing.util;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static void writeToFile(String fileName, List<?> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
        }
    }

    public static <T> List<T> readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }
}