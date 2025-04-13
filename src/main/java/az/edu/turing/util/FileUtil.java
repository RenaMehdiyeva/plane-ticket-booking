package az.edu.turing.util;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static void writeToFile(String fileName, List<?> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFromFile(String fileName) {
        List<T> data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            data = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
