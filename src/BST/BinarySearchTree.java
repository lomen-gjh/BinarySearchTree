package BST;

import myQueue.Queue;

public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root=null;
    }

    public void insert(int data){
        if (root==null)
            root=new Node(data);
        else root.insert(data);
    }
    public void inorder(){
        if (root!=null)
        {
            root.inorder();
            System.out.println();
        }
    }
    public void preorder(){
        if (root!=null)
        {
            root.preorder();
            System.out.println();
        }
    }
    public void postorder(){
        if (root!=null)
        {
            root.postorder();
            System.out.println();
        }
    }

    public void bfs(){
        //Okomentujem doma
        Queue<Node> q=new Queue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
             q.enqueue(q.head.data.left);
             q.enqueue(q.head.data.right);
             System.out.print(q.dequeue().data.data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree b=new BinarySearchTree();
        b.insert(50);
        b.insert(40);
        b.insert(60);
        b.insert(90);
        b.insert(35);
        b.insert(100);
        b.insert(-3);
        b.bfs();
        //b.inorder();
        //b.preorder();
        //b.postorder();
    }



}
