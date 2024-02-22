package AdelsonVelskiLandis;

import java.awt.*;

public class AVL {
    public Node root;
    public AVL(){
        root=null;
    }

    public void insert(int data){
        if (root==null)
            root=new Node(data);
        else
        {
            Node fakeParent=new Node(-1000);
            fakeParent.right=root;
            root.insert(data,fakeParent);
            root=fakeParent.right;
        }

    }
    public void drawAVL(Graphics g, int x, int y){
        g.clearRect(0,0,600,400);
        if (root!=null){
            root.drawNode(g,x,y);
        }
    }

    public static void main(String[] args) {
        AVL a=new AVL();
        a.insert(50);
        a.insert(25);
        a.insert(11);
        a.insert(1);
        Node fake=new Node(-1000);
        fake.right=a.root;
        a.root.preorder();
        System.out.println();
        Node storeMin=a.root.removeMin(fake);
        a.root.preorder();
        a.insert(70);
        a.insert(60);
        a.root.right.removeMin(a.root);
    }
}
