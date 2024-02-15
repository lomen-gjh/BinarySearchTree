package binaryNoParent;

import java.awt.*;

public class Node {
    private int data,x,y;
    public Node left, right;
    Node(int x, int y, int d){
        this.x=x; this.y=y;
        data=d;
        left=null;
        right=null;
    }


    int getX(){return x;}
    int getY(){return y;}
    void setX(int x){this.x=x;}
    void setY(int y){this.y=y;}
    void drawNode(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x-14,y-14,28,28);
        g.setColor(Color.BLACK);
        g.drawOval(x-15,y-15,30,30);
        g.drawString(Integer.toString(data), x-((g.getFontMetrics().stringWidth(Integer.toString(data)))/2),y);
    }
    int getData(){
        return data;
    }
    Node getLeft(){
        return left;
    }
    Node getRight(){
        return right;
    }
    void setData(int d){ data=d;}
    void setLeft(Node l){left=l;}
    void setRight(Node r){right=r;}

    void preorder(){
        System.out.print(data+" ");
        if (left!=null)
            left.preorder();
        if (right!=null)
            right.preorder();
    }

    void inorder(){
        if (left!=null)
            left.inorder();
        System.out.print(data+" ");
        if (right!=null)
            right.inorder();
    }

    void postorder(){
        if (left!=null)
            left.postorder();
        if (right!=null)
            right.postorder();
        System.out.print(data+" ");
    }


    void insert(int d){
        if (d>data){
            if(right==null)
                right=new Node(x+15,y+25,d);
            else
                right.insert(d);
        }
        else if (d<data){
            if (left==null)
                left=new Node(x-15,y+25,d);
            else
                left.insert(d);
        }
    }

    Node findParent(int val){
        if (data==val)
            return null; //If we are root, we return null
        if (right.data==val || left.data==val)
            return this;
        else
        {
            if (val>data){
                return right.findParent(val);
            }
            else {
                return left.findParent(val);
            }
        }
    }

    Node findMaxParent(){
        if (right==null)
            return null;
        if (right.right==null)
            return this;
        return right.findMaxParent();

    }

    Node findMinParent(){
        if (left==null){
            return null;
        }
        if (left.left==null)
            return this;

        return left.findMinParent();

    }

    Node delete(int val){
        Node parent=findParent(val);
        System.out.println(parent.data);
        if (parent==null){
            return null; //solve in BST class
        }

        if (parent.left!=null && parent.left.data==val){
            //we go to the left
            Node deleted=parent.left;
            if (deleted.left==null && deleted.right==null)
            {

                parent.left=null;
                return deleted;
            }
            if (deleted.right==null)
            {
                parent.left=deleted.left;
                return deleted;
            }
            else
            {
                //replace minimum in the right SUBTREE
                Node replacement;
                if (deleted.right.left==null)
                {
                    //if there is no right.left subree than the replacement is right node
                    replacement=deleted.right;
                    deleted.right=deleted.right.right;
                }

                else{
                    //if there is right.left subree, find minimumParent
                    Node minP=deleted.right.findMinParent();
                    replacement=minP.left;
                    minP.left=minP.left.right;
                }

                //the actual deletion
                //parent.left is the node we want to DELETE
                replacement.left=parent.left.left;
                replacement.right=parent.left.right;
                parent.left=replacement;

                System.out.println(parent.data+" "+ parent.left.data+" "+parent.right.data);
                return deleted;
            }
        }
        if (parent.right!=null && parent.right.data==val){
            //FINISH THIS PART
            Node deleted=parent.right;
            if (deleted.left==null && deleted.right==null)
            {
                parent.right=null;
                return deleted;
            }

            if (deleted.left==null)
            {
                parent.right=deleted.right;
                return deleted;
            }
            else {
                //find max in the LEFT SUBTREE
                Node replacement;
                if (deleted.left.right==null)
                {
                    replacement=deleted.left;
                    deleted.left=deleted.left.left;
                }

                else{
                    Node maxP=deleted.left.findMaxParent();
                    replacement=maxP.right;
                    maxP.right=maxP.right.left;
                }

                //actual deletion

                replacement.left=parent.right.left;
                replacement.right=parent.right.right;
                parent.right=replacement;

                return deleted;

            }

        }
        return null;
    }

    void fixAndDraw(int x, int y, Graphics g){
        setX(x);
        setY(y);
        drawNode(g);
        if (left!=null){
            g.drawLine(x,y,x-50,y+30);
            left.fixAndDraw(x-50,y+30,g);
        }
        if (right!=null) {
            g.drawLine(x,y,x+50,y+30);
            right.fixAndDraw(x+50,y+30,g);
        }
    }




}
