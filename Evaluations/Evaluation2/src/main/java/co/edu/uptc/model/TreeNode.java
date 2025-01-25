package co.edu.uptc.model;

public class TreeNode <Car>{
    private Car info;
    private TreeNode<Car> left;
    private TreeNode<Car> right;

    public TreeNode(Car info){
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Car getInfo() {
        return info;
    }

    public void setInfo(Car info) {
        this.info = info;
    }

    public TreeNode<Car> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<Car> left) {
        this.left = left;
    }

    public TreeNode<Car> getRight() {
        return right;
    }

    public void setRight(TreeNode<Car> right) {
        this.right = right;
    }
}