package binaryNoParent;

import java.awt.*;

public class BSTree {
    public Node root;
    public BSTree(){
        root=null;
    }

    public void insert(int x, int y, int d){
        if (root!=null)
            root.insert(d);
        else
            root=new Node(x,y,d);
    }

    public void drawTree(int x, int y,Graphics g){
        root.fixAndDraw(x,y,g);
    }

    public Node delete(int v){
        if (root!=null){
            if (root.getData()==v){
                Node replacement;
                if (root.getLeft()!=null)
                {
                    if (root.left.right!=null)
                    {
                        Node maxP= root.left.right.findMaxParent();
                        if (maxP!=null) {
                            replacement = maxP.getRight();
                            maxP.right=replacement.left;
                        }
                        else{
                            replacement=root.left.right;
                            root.left.right=replacement.left;
                        }
                        replacement.left=root.left;
                    }
                    else {
                        replacement=root.left;
                    }



                    replacement.right=root.right;
                    root=replacement;
                    return replacement;
                }


                if (root.getRight()!=null)
                {
                    if (root.right.getLeft()!=null)
                    {
                        Node minP=root.right.left.findMinParent();
                        if (minP!=null){
                            replacement=minP.left;
                            minP.left=replacement.right;
                        }
                        else {
                            replacement=root.right.left;
                            root.right.left=replacement.left;
                        }
                        replacement.right=root.right;
                    }
                    else{
                        replacement=root.right;
                    }




                    replacement.left=root.left;
                    root=replacement;
                    return replacement;
                }
                else
                {
                    Node deleted=root;
                    root=null;
                    return deleted;
                }


            }
            return root.delete(v);

        }

        return null;

    }

    public static void main(String args[]){
        BSTree tree=new BSTree();




    }
}
