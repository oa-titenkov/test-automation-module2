package learn.io.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task1.txt");
        writeRandomNumbersToFile(file);
        sortFileAscending(file);

    }

    public static void writeRandomNumbersToFile(File file) {
        try(PrintWriter writer = new PrintWriter(file, "UTF-8")) {
            for(int i = 0; i < 100; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 10001);
                writer.write(String.valueOf(randomNumber));
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sortFileAscending(File file) {
        List<String> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(line);
            }
            numbers.sort(Comparator.comparingInt(Integer::valueOf));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(file, numbers);

    }

}
