package BST;

public class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
    public void insert(int data){
        if (data>this.data){  //doprava
            if (this.right!=null){  //ak ma prave dieta
                this.right.insert(data);  // tak rekurzia
            }
            else{
                right=new Node(data); //inak vytvor prave dieta
            }
        }
        if (data<this.data){  //do lava
            if (this.left!=null){
                this.left.insert(data);
            }
            else{
                left=new Node(data);
            }
        }
    }
    public void inorder(){
        if (left!=null)
            left.inorder();
        System.out.print(this.data+" ");
        if (right!=null)
            right.inorder();
    }

    public void preorder(){
        System.out.print(this.data+" ");
        if (left!=null)
            left.preorder();
        if (right!=null)
            right.preorder();
    }
    public void postorder(){
        if (left!=null)
            left.postorder();
        if (right!=null)
            right.postorder();
        System.out.print(this.data+" ");
    }

}
