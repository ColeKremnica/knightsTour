package Code;

public class Node {
    private int data;
    private Node right, left, down, up; // References to adjacent nodes
    private Node path1, path2, path3, path4, path5, path6, path7, path8; // Knights Movement
    private int freedom;

    // Getter and setter for freedom
    public int getFreedom() {
        return freedom;
    }

    public void setFreedom(int freedom) {
        this.freedom = freedom;
    }

    // Default constructor
    public Node() {
        data = 0;
        right = left = up = down = null;
    }

    // Getter and setter methods for each path variable
    public Node getPath1() { return path1; }
    public void setPath1(Node path1) { this.path1 = path1; }
    public Node getPath2() { return path2; }
    public void setPath2(Node path2) { this.path2 = path2; }
    public Node getPath3() { return path3; }
    public void setPath3(Node path3) { this.path3 = path3; }
    public Node getPath4() { return path4; }
    public void setPath4(Node path4) { this.path4 = path4; }
    public Node getPath5() { return path5; }
    public void setPath5(Node path5) { this.path5 = path5; }
    public Node getPath6() { return path6; }
    public void setPath6(Node path6) { this.path6 = path6; }
    public Node getPath7() { return path7; }
    public void setPath7(Node path7) { this.path7 = path7; }
    public Node getPath8() { return path8; }
    public void setPath8(Node path8) { this.path8 = path8; }

    // Getter and setter for data
    public int getData() { return data; }
    public void setData(int data) { this.data = data; }

    // Getters and setters for four main directional links
    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }
    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }
    public Node getUp() { return up; }
    public void setUp(Node up) { this.up = up; }
    public Node getDown() { return down; }
    public void setDown(Node down) { this.down = down; }
}
