package learn.io;

import java.io.*;
import java.util.List;

public class WriteToFile {

  public static void writeListToFile(File file, List<String> list) {
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      for (String line : list) {
        writer.write(line);
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
