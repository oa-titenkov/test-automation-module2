package learn.io.maintask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        createFolderTree(args[0]);
    }

    public static void createFolderTree(String dirPath){
        File root = new File(dirPath);
        if(root.isDirectory()) {
            TreeNode node = new TreeNode(root);
            createFolderTree(root, node);
            File file = new File("src\\main\\resources\\file_tree.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(node.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(root.isFile()) {
            printProperties(root);
        }

    }

    public static void createFolderTree(File folder, TreeNode node){
        File[] files = folder.listFiles();
        Arrays.sort(Objects.requireNonNull(files), Comparator.comparing(File::isDirectory));
        for (File file : files) {
            if (file.isDirectory()) {
                createFolderTree(file, node.addChild(file));
            } else {
                node.addChild(file);
            }
        }

    }

    public static void printProperties(File filePath) {
        TreeNode node = new TreeNode(filePath.getParentFile());
        createFolderTree(filePath.getParentFile(), node);
        System.out.println(node.getProperties());

    }
    
}
