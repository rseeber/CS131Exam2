package exam2;


public class Genesis extends Tree{



  Genesis(int key){
  this.init(key);
    }
}

class Function {

static Genesis invertTree(Genesis root){
  if(root == null || root.vacant){
    return null;
 }

 Genesis leftNode = invertTree((Genesis) root.leftNode);
 Genesis rightNode = invertTree((Genesis) root.rightNode);

root.leftNode = rightNode;
root.rightNode = leftNode;

return root;
    }

    static void printTree(Genesis root){
      if(root == null || root.vacant){
        return;
      }
    printTree((Genesis) root.leftNode);
    System.out.print(root.key + " ");
    printTree((Genesis) root.rightNode);
    

    }

public static void main(String[] args){
  Genesis root = new Genesis(4);
  root.leftNode.init(root, 2);
  root.rightNode.init(root, 7);
  root.leftNode.leftNode.init(root.leftNode, 1);
  root.leftNode.leftNode.init(root.rightNode, 3);
  root.rightNode.leftNode.init(root.rightNode, 8);
  root.rightNode.rightNode.init(root.rightNode, 9);

  root = invertTree(root);

  printTree(root);

 }
}
