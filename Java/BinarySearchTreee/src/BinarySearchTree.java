import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    public Node root;
    public int[] vals;

    public BinarySearchTree(int[] values){
        this.root = createBST(values);
        this.vals = values;
    }

    public Node createBST(int[] values){
        Node BSTroot = new Node(values[0], 0, null, null, null);

        for (int value : Arrays.copyOfRange(values, 1, values.length)){
            insertNode(BSTroot, value);
        }
        return BSTroot;
    }

    public void insertNode(Node rootNode, int value){
        Node newNode = new Node (value, 0,null, null, null);
        Node currNode = rootNode;

        int depth = 0;
        while (newNode.parent == null){
            depth++;
            if (currNode.value >= newNode.value){
                if (currNode.childLeft != null){
                    currNode = currNode.childLeft;
                } else {
                    newNode.depth = depth;
                    newNode.parent = currNode;
                    currNode.childLeft = newNode;
                }
            } else{
                if (currNode.childRight != null){
                    currNode = currNode.childRight;
                } else {
                    newNode.depth = depth;
                    newNode.parent = currNode;
                    currNode.childRight = newNode;
                }
            }
        }
    }

    //TODO
    public Node recursiveCreateBST (int[] values){
        //Arrays.sort(values);
        return root;
    }

    //TODO
    public int[] recursiveInsertNode(int[] values){
        return vals;
    }

    public void printBST(){
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        Node currNode;
        int currDepth = 0;

        while(!queue.isEmpty()){
            currNode = queue.get(0);
            if(currNode.depth > currDepth){
                System.out.print("\n");
                currDepth = currNode.depth;
            }
            System.out.print(currNode.value);
            if (currNode.parent != null){System.out.print("("+currNode.parent.value+")");}
            System.out.print(" ");
            queue.remove(currNode);
            if(currNode.childLeft != null){
                queue.add(currNode.childLeft);
            }
            if(currNode.childRight != null){
                queue.add(currNode.childRight);
            }
        }

    }

    public boolean isBalanced(){
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        Node currNode;
        int minDepth = Integer.MAX_VALUE;
        int maxDepth = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            currNode = queue.get(0);

            if(currNode.childLeft == null && currNode.childRight == null){
                if (currNode.depth < minDepth){ minDepth = currNode.depth;}
                if (currNode.depth > maxDepth){ maxDepth = currNode.depth;}
            }
            if(currNode.childLeft != null){
                queue.add(currNode.childLeft);
            }
            if(currNode.childRight != null){
                queue.add(currNode.childRight);
            }
            queue.remove(currNode);
        }
        return Math.abs(maxDepth - minDepth) <= 1;
    }

    public Node balanceBST(){
        return recursiveCreateBST(this.vals);
    }

}
