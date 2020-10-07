package learn.io.maintask;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    private File data;
    private TreeNode parent = null;
    private List<TreeNode> children;
    private int folderCount = 1;
    private int fileCount ;
    private double averageFileCount;
    private int allFileLength;
    private double averageFileNameLength;

    public TreeNode(File data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public TreeNode addChild(File child) {
        TreeNode childNode = new TreeNode(child);
        childNode.setParent(this);
        this.children.add(childNode);
        return childNode;
    }

    public void printTree(StringBuilder builder, String indent, String childrenIndent) {
        builder.append(indent);
        builder.append(data.getName());
        builder.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                if (next.data.isFile() && isFolder(next.getParent())){
                    next.printTree(builder, childrenIndent + "|   ", childrenIndent + "│   ");
                }
                else if (next.data.isFile() && !isFolder(next.getParent())){
                    next.printTree(builder, childrenIndent + "    ", childrenIndent + "│   ");
                }
                else next.printTree(builder, childrenIndent + "├───", childrenIndent + "│   ");
            } else {
                if (next.data.isFile() && isFolder(next.getParent())){
                    next.printTree(builder, childrenIndent + "|   ", childrenIndent + "│   ");
                }
                else if (next.data.isFile() && !isFolder(next.getParent())){
                    next.printTree(builder, childrenIndent + "    ", childrenIndent + "│   ");
                }
                else next.printTree(builder, childrenIndent + "└───", childrenIndent + "    ");
            }
        }
    }

    public boolean isFolder(TreeNode treenode) {
        if (treenode.getChildren().size() == 0) return false;
        for(int i = 0; i < treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i).getData().isDirectory()) return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        printTree(builder, "", "");
        return builder.toString();
    }

    public String getProperties() {
        for(int i = 0; i < this.getChildren().size(); i++) {
            if (this.getChildren().get(i).getData().isFile()){
                allFileLength = allFileLength + this.getChildren().get(i).data.getName().length();
                fileCount++;
            }
            else {
                this.getChildren().get(i).getProperties();
                fileCount = fileCount + this.getChildren().get(i).getFileCount();
                folderCount = folderCount + this.getChildren().get(i).getFolderCount();
                allFileLength = allFileLength + this.getChildren().get(i).getAllFileLength();
                folderCount++;
            }
        }
        averageFileCount = (double) fileCount / folderCount;
        averageFileNameLength = (double) allFileLength / fileCount;
        return "Folders: " + folderCount + "\n" +
                "Files: " + fileCount + "\n" +
                "Average files in folder: " + String.format("%.2f", averageFileCount) + "\n" +
                "Average file name length: " + String.format("%.2f", averageFileNameLength) + "\n";
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getFolderCount() {
        return folderCount;
    }

    public void setFolderCount(int folderCount) {
        this.folderCount = folderCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public double getAverageFileCount() {
        return averageFileCount;
    }

    public void setAverageFileCount(double averageFileCount) {
        this.averageFileCount = averageFileCount;
    }

    public int getAllFileLength() {
        return allFileLength;
    }

    public void setAllFileLength(int allFileLength) {
        this.allFileLength = allFileLength;
    }

    public double getAverageFileNameLength() {
        return averageFileNameLength;
    }

    public void setAverageFileNameLength(double averageFileNameLength) {
        this.averageFileNameLength = averageFileNameLength;
    }
}
