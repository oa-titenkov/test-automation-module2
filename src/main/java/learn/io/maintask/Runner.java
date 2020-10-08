package learn.io.maintask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Runner {

    public static void main(String[] args) {
        File root = new File(args[0]);
        File file = new File("src\\main\\resources\\file_tree.txt");
        TreeNode node = new TreeNode(root);
        if (root.isFile()) {
            createDirectoryTree(root.getParentFile(), node);
            System.out.println(node.getProperties());
        }
        else  {
            createDirectoryTree(root, node);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(node.toString());
        } catch (IOException e) {
            e.printStackTrace();
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

}
