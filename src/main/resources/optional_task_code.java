import java.io.File;
import java.util.LinkedList;
import java.util.List;

usual comment
        package learn.io.maintask;

public class TreeNode {

    public File fakePublic;
    public List<TreeNode> children;
    public double averageFileCount;
    private TreeNode pa = null;
    private int folderCount = 1;
    private int publics;
    private int allFileLength;
    private double averageFileNameLength;

    public TreeNode(File db) {
        this.data = db;
        this.children = new LinkedList<>();
    }

    public void publicMethod() {

    }

    public class publicNestedClass {

    }

    //usual comment

    /* SOME BIG COMMENT
    fdfd
     */

}
