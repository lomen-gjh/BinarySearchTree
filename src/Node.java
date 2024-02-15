
public class Node {
    private int data, x,y;
    private Node left, right;
    Node(int x, int y, int d){
        this.x=x;
        this.y=y;
        data=d;
        left=null;
        right=null;
    }
    //setters and getters
    int getX(){return x;}
    int getY(){return y;}
    void setX(int x){this.x=x;}
    void setY(int y){this.y=y;}
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
                right=new Node(x+50, y+30, d);
            else
                right.insert(d);
        }
        else if (d<data){
            if (left==null)
                left=new Node(x-50,y+30, d);
            else
                left.insert(d);
        }
    }

    Node findParent(int val){
        if (data==val)
            return null; //If we are root, we return null

        //if the found value is either in this node left OR right child, than this node is the parent
        if ((left!=null && left.data==val) || (right!=null && right.data==val))
            return this;
        else  //else we run recursion, either to the left OR to the right
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
            return null;  //Max parent does not exist, because it does not have a right node

        if (right.right!=null){
            return right.findMaxParent(); //if there is a right.right grandchild, we need to keep looking for the direct parent of max node
        }
        return this; // this node is the parent of the node with the max value

    }

    Node findMinParent(){
        //Similar to findMaxParent
        if (left==null){
            return null;
        }
        if (left.left!=null)
            return left.findMinParent();
        return this;
    }

    Node delete(int val){
        //Find the parent and node to be deleted
        Node parent=findParent(val);


        /* with no parent,
        we cant continue,
        this is resolved in BSTree delete() function

         */
        if (parent==null){
            return null;
        }
        //node to be deleted
        Node deleted=null;

        /*
        if the target node is to the left of parent
         */
        if (parent.left!=null && parent.left.data==val){
            //parent.left is to be deleted
            deleted=parent.left;
            Node replacement;

            /*if there the target node does not have the RIGHT subtree
            we just skip the target node
             */
            if (deleted.right==null)
            {
                parent.left=deleted.left;
            }
            else
            {
                /*
                we look for minimum value in the RIGHT subtree of the target node
                 */
                Node minP=parent.left.right.findMinParent();

                /*no parent found, for the delete.right node,
                therefore the node itself is a min value in the subtree
                 */
                if (minP==null){
                    replacement=deleted.right;
                    deleted.right=replacement.right;
                }
                //minP found!
                else {
                    replacement=minP.left;
                    minP.left=replacement.right;

                }

                //replace deleted node with replacement node
                parent.left=replacement;
                replacement.left=deleted.left;
                replacement.right=deleted.right;

            }




        }
        else if (parent.right!=null && parent.right.data==val){
            //FINISH RIGHT SIDE, similar to left side
            Node replacement;
            deleted=parent.right;
            if (parent.right.left==null)
            {
                parent.right=parent.right.right;
            }
            else
            {
                //replace minimum in the SUBTREE
                Node maxP=parent.right.left.findMaxParent();
                if (maxP==null){
                    replacement=parent.right.left;
                    parent.right.left=replacement.left;
                }
                else {
                    replacement=maxP.right;
                    maxP.right=replacement.left;

                }
                parent.right=replacement;
                replacement.left=deleted.left;
                replacement.right=deleted.right;

            }
        }
        return deleted;
    }


}
