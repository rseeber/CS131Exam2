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
    //creates a vacant tree
    public Tree(){
        this.vacant = true;
        this.parent = null;
        this.leftNode = null;
        this.rightNode = null;
    }
    public Tree(Tree parent){
        this();
        this.parent = parent;
    }

    //initializes a node with a value, and creates 2 vacant (empty) nodes as left and right children
    public void init(int key){
        this.vacant = false;
        this.key = key;
        //initialize any non-vacant nodes with 2 vacant child nodes, which makes insert() implimentation easier
        this.leftNode = new Tree(this);
        this.rightNode = new Tree(this);
    }
    //overload, which assigns a parent node
    public void init(Tree parent, int key){
        init(key);
        this.parent = parent;
    }
    //overload, which assigns parent and child values, this time NOT setting the children to vacant
    public void init(Tree parent, Tree leftNode, Tree rightNode, int key){
        init(parent, key);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //inserts a key into the tree, placing it in one of the vacant leaf nodes
    public void insert(int key){
        Tree t = this;
        //climb down until we find a vacant slot that can hold our key
        while(!t.vacant){
            //move left if key is smaller than parent
            if(key < t.key){
                t = t.leftNode;
            }
            //move right if key is bigger (or equal to) parent
            else{
                t = t.rightNode;
            }
            t.parent = t;
        }
        //when we find a vacant node, initialize it with the key
        t.init(key);
    }

    //reverses the left-right ordering of the entire tree
    public void reverse(){
        //base case
        if(this.vacant){
            return;
        }
        //recursive case
        //swap left and right nodes
        Tree buf;
        buf = this.leftNode;
        this.leftNode = this.rightNode;
        this.rightNode = buf;
        //now swap all the children of the left and right nodes
        this.leftNode.reverse();
        this.rightNode.reverse();
    }

    //prints the tree
    public void printTree(){
        //base case
        if(this.vacant){
            return;
        }
        //recursive case
        //print the key
        System.out.print(key);
        //if you have at least 1 child, print parenthesis
        if(!leftNode.vacant || !rightNode.vacant){
            System.out.print("(");
            //now determine which child(s)
            //print left
            if(!leftNode.vacant){
                leftNode.printTree();
                System.out.print(", ");
            }
            //print right
            if(!rightNode.vacant){
                rightNode.printTree();
            }
            System.out.print(")");
        }
    }
}
