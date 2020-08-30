package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainTask {
    public static void main(String[] args) {
        writeToFile(args[0]);
    }

    public static void writeToFile(String dirPath){
        File root = new File(dirPath);
        if(root.isDirectory()) {
            TreeNode node = new TreeNode(root);
            writeFolderTree(root, node);
            File file = new File("src\\main\\resources\\file_tree.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(node.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(root.isFile()) {
            writeProperties(root);
        }

    }

    public static void writeFolderTree(File folder, TreeNode node){
        File[] files = folder.listFiles();
        Arrays.sort(Objects.requireNonNull(files), Comparator.comparing(File::isDirectory));
        for (File file : files) {
            if (file.isDirectory()) {
                writeFolderTree(file, node.addChild(file));
            } else {
                node.addChild(file);
            }
        }
    }

    public static void writeProperties(File filePath) {
        File file = new File("src\\main\\resources\\file_tree.txt");
        TreeNode node = new TreeNode(filePath.getParentFile());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writeFolderTree(filePath.getParentFile(), node);
            writer.write(node.getProperties());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
