package learn.io.maintask;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Runner {

    public static void main(String[] args) {
        File root = new File(args[0]);
        File file = new File("src\\main\\resources\\file_tree.txt");
        TreeNode node = new TreeNode(root);
        if (root.getAbsolutePath().equals(file.getAbsolutePath())) {
            System.out.println(parseFileTree());
        }
        else {
            if (root.isFile()) {
                createDirectoryTree(root.getParentFile(), node);
                System.out.println(node.getProperties());
            }
            else if (root.isDirectory())  {
                createDirectoryTree(root, node);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(node.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createDirectoryTree(File folder, TreeNode node) {
        File[] directoryFiles = folder.listFiles();
        Arrays.sort(Objects.requireNonNull(directoryFiles), Comparator.comparing(File::isDirectory));
        for (File file : directoryFiles) {
            if (file.isDirectory()) {
                createDirectoryTree(file, node.addChild(file));
            } else {
                node.addChild(file);
            }
        }

    }

    public static String parseFileTree() {
        File file = new File("src\\main\\resources\\file_tree.txt");
        int folderCount = 0;
        int fileCount = 0;
        double averageFileCount;
        int allFileLength = 0;
        double averageFileNameLength;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line
                        .replaceAll("│", "")
                        .replaceAll("\\|", "")
                        .replaceAll("├───", "")
                        .replaceAll("└───", "")
                        .trim();
                if (trimmedLine.split("\\.").length > 1) {
                    fileCount++;
                    allFileLength = allFileLength + trimmedLine.split("\\.")[0].length();
                }
                else folderCount++;
            }
            averageFileCount = (double) fileCount / folderCount;
            averageFileNameLength = (double) allFileLength / fileCount;
            return "Folders: " + folderCount + "\n" +
                    "Files: " + fileCount + "\n" +
                    "Average files in folder: " + String.format("%.2f", averageFileCount) + "\n" +
                    "Average file name length: " + String.format("%.2f", averageFileNameLength) + "\n";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
