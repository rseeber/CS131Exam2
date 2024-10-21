package exam2;

public class Main {
   
    public static void main(String[] args) {
        Tree t = new Tree();
        //insert all the following data points
        int data[] = {4, 2, 7, 1, 3, 6, 9};
        int dataLen = 7;
        //iterate through each index of the array
        for(int i = 0; i < dataLen; ++i){
            t.insert(data[i]);
        }
        //print the tree before and after reversing it
        t.printTree();
        t.reverse();
        t.printTree();
    }
   
}
