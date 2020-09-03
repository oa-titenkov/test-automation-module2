package learn.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalTask1 {

  public static void main(String[] args) {
      File file = new File("src\\main\\resources\\optional_task1.txt");
      writeRandomNumbersToFile(file);
      sortFileAscending(file);
  }

  public static void writeRandomNumbersToFile(File file) {
    try(PrintWriter writer = new PrintWriter(file, "UTF-8")) {
      for(int i = 0; i < 100; i++) {
        int num = ThreadLocalRandom.current().nextInt(0, 10001);
        writer.write(String.valueOf(num));
        writer.write(System.getProperty("line.separator"));
      }
    }catch (IOException e) {
      e.printStackTrace();
    }
}

  public static void sortFileAscending(File file) {
    List<Integer> numbers = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        numbers.add(Integer.parseInt(line));
      }
      numbers.sort(Comparator.comparingInt(Integer::intValue));
    } catch (IOException e) {
      e.printStackTrace();
    }
    try(FileWriter writer = new FileWriter(file)){
      for (Integer number : numbers) {
        writer.write(String.valueOf(number));
        writer.write(System.getProperty("line.separator"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
