package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class OptionalTask5 {
  public static void main(String[] args) {
    File file = new File("src\\main\\resources\\optional_task5.txt");
    List<String> textList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        StringBuilder result = new StringBuilder();
        if(Integer.parseInt(line.split(" ")[1]) > 7){
          result.append(line.split(" ")[0].toUpperCase()).append(" ");
          result.append(line.split(" ")[1]);
        }
        else result.append(line);
        textList.add(result.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    io.WriteToFile.writeListToFile(file, textList);
  }
}
