package learn.io.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Task5 {

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task5.txt");
        File fileEdited = new File("src\\main\\resources\\optional_task5_edited.txt");
        List<String> textList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder result = new StringBuilder();
                String[] nameAndMarks = line.split(" ", 2);
                if (getAverageMark(nameAndMarks[1]) > 7) {
                    result.append(nameAndMarks[0].toUpperCase()).append(" ");
                    result.append(nameAndMarks[1]);
                }
                else result.append(line);
                textList.add(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(fileEdited, textList);

    }

    public static double getAverageMark(String marksLine) {
        double sumOfMarks = 0;
        String[] marks = marksLine.split(" ");
        for (String mark : marks) {
            sumOfMarks = sumOfMarks + Integer.parseInt(mark);
        }
        return sumOfMarks / marks.length;

    }
}
