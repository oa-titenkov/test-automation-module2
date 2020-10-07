package learn.io.maintask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        File root = new File(args[0]);
        if(root.isDirectory()) {
            TreeNode node = new TreeNode(root);
            createDirectoryTree(root, node);
            File file = new File("src\\main\\resources\\file_tree.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(node.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(root.isFile()) {
            printFileProperties(root);
        }
    }

    public static void createDirectoryTree(File folder, TreeNode node){
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

    public static void printFileProperties(File filePath) {
        TreeNode node = new TreeNode(filePath.getParentFile());
        createDirectoryTree(filePath.getParentFile(), node);
        System.out.println(node.getProperties());

    }
    
}
