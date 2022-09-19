public class Node {

    public int value;
    public int depth;
    public Node parent;
    public Node childLeft;
    public Node childRight;

    public Node(int value, int depth, Node parent, Node childLeft, Node childRight) {
        this.value = value;
        this.depth = depth;
        this.parent = parent;
        this.childLeft = childLeft;
        this.childRight = childRight;
    }
}
