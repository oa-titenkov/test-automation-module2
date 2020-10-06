usual comment
package learn.io.maintask;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    public File fakePublic;
    private TreeNode pa = null;
    public List<TreeNode> children;
    private int folderCount = 1;
    private int publics;
    public double averageFileCount;
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
