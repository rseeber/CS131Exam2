package exam2;

public class Tree{
    //true when this node isn't holding anything
    boolean vacant;
    //a tree is just a node with 2 children left and right
    Tree leftNode;
    Tree rightNode;
    Tree parent;
    //each node has a key
    int key;

    public Tree(){
        this.vacant = true;
        this.parent = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void init(int key){
        this.vacant = false;
        this.key = key;
        //initialize any non-vacant nodes with 2 vacant child nodes, which makes insert() implimentation easier
        this.leftNode = new Tree();
        this.rightNode = new Tree();
    }

    public void init(Tree parent, int key){
        init(key);
        this.parent = parent;
    }

    public void init(Tree parent, Tree leftNode, Tree rightNode, int key){
        init(parent, key);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //inserts a key into the tree, placing it in one of the vacant leaf nodes
    public void insert(int key, Tree target, Tree parent){
        //climb down until we find a vacant slot that can hold our key
        while(!target.vacant){
            //move left if key is smaller than parent
            if(key < parent.key){
                target = parent.leftNode;
            }
            //move right if key is bigger (or equal to) parent
            else{
                target = parent.rightNode;
            }
        }
        //when we find a vacant node, initialize it with the key
        target.init(parent, key);
    }
}
