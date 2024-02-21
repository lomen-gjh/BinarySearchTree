package AdelsonVelskiLandis;

import java.awt.*;

public class Node {
    int data, depth, balance;
    Node left, right;
    public Node(int data){
        this.data=data;
        depth=0;
        balance=0;
        left=null;
        right=null;
    }
    public void updateBalance(){
        if (left!=null && right!=null){
            depth=Math.max(left.depth, right.depth)+1;
            balance=right.depth - left.depth;
        }
        else if (left!=null){
            depth=left.depth+1;
            balance=-left.depth-1;
        }
        else if (right!=null){
            depth = right.depth+1;
            balance= right.depth+1;
        }
        else {
            balance=0;
            depth=0;
        }
    }

    public void rightRotation(Node p){
        //rotate right without using Node temp
        if (p.data<this.data){
            p.right=this.left;
        }
        else{
            p.left=this.left;
        }
        this.left=this.left.right;
        this.updateBalance();
        if (p.data<this.data){
            p.right.right=this;
            p.right.updateBalance();
        }
        else{
            p.left.right=this;
            p.left.updateBalance();
        }
        p.updateBalance();
    }

    public void leftRotation(Node p){
        //rotate left without using Node temp
        if (p.data<this.data){
            p.right=this.right;
        }
        else{
            p.left=this.right;
        }
        this.right=this.right.left;
        this.updateBalance();
        if (p.data<this.data){
            p.right.left=this;
            p.right.updateBalance();
        }
        else{
            p.left.left=this;
            p.left.updateBalance();
        }
        p.updateBalance();
    }
    public void leftRightRotation(Node p){
        if (p.data<this.data){
           p.right=this.left.right;
        }
        else{
           p.left=this.left.right;
        }
        this.left.right=this.left.right.left;
        this.left.updateBalance();
        if (p.data<this.data){
           p.right.left=this.left;
           this.left=p.right.right;
           this.updateBalance();
           p.right.right=this;
           p.right.updateBalance();
        }
        else{
            p.left.left=this.left;
            this.left=p.left.right;
            this.updateBalance();
            p.left.right=this;
            p.left.updateBalance();
        }
        p.updateBalance();
    }
    public void rightLeftRotation(Node p){
        if (p.data<this.data){
            p.right=this.right.left;
        }
        else{
            p.left=this.right.left;
        }
        this.right.left=this.right.left.right;
        this.right.updateBalance();
        if (p.data<this.data){
            p.right.right=this.right;
            this.right=p.right.left;
            this.updateBalance();
            p.right.left=this;
            p.right.updateBalance();
        }
        else{
            p.left.right=this.right;
            this.right=p.left.left;
            this.updateBalance();
            p.left.left=this;
            p.left.updateBalance();
        }
        p.updateBalance();

    }

    public void drawNode(Graphics g, int x, int y){
        if (this.left!=null){
            g.drawLine(x+10,y+10,x-20,y+40);
            left.drawNode(g, x-30,y+30);
        }
        if (this.right!=null){
            g.drawLine(x+10,y+10,x+40,y+40);
            right.drawNode(g, x+30, y+30);
        }
        g.setColor(Color.CYAN);
        g.fillOval(x,y,20,20);
        String s=Integer.toString(this.data);
        g.setColor(Color.BLACK);
        g.drawString(s, x+10-g.getFontMetrics().stringWidth(s)/2,y+12);
        String s2=this.depth+" "+this.balance;
        g.drawString(s2, x+10-g.getFontMetrics().stringWidth(s2)/2,y);


    }
    public void insert(int data, Node p){  //second argument: parent node
        if (data>this.data){  //doprava
            if (this.right!=null){  //ak ma prave dieta
                this.right.insert(data,this);  // tak rekurzia
            }
            else{
                right=new Node(data); //inak vytvor prave dieta
            }
        }
        if (data<this.data){  //do lava
            if (this.left!=null){
                this.left.insert(data,this);
            }
            else{
                left=new Node(data);
            }
        }
        updateBalance();
        if (balance>1){
            if (right.balance>0){
                leftRotation(p);
            }
            else{
                rightLeftRotation(p);
            }
        }
        else if (balance<-1){
            if (left.balance<0){
                rightRotation(p);
            }
            else{
                leftRightRotation(p);
            }
        }
    }

    public Node delete(int data, Node p){
        if (this.left==null && this.right==null) {
            if (p.data < this.data) {
                p.right = null;
                p.updateBalance();
                return this;
            }
            p.left = null;
            p.updateBalance();
            return this;
        }
        return null; //placeholder
    }

    public Node findMax(Node p){
        if (right==null){
            p.right=this.left;
            this.left=null;
            p.updateBalance();
            return this;
        }
        Node a=right.findMax(this);
        p.updateBalance();
        return a;
    }

    public Node findMin(Node p){
        if (left==null){
            p.left=this.right;
            this.right=null;
            p.updateBalance();
            return this;
        }
        Node a= left.findMin(this);
        p.updateBalance();
        return a;
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
